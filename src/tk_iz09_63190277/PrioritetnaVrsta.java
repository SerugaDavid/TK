package tk_iz09_63190277;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PrioritetnaVrsta<Tip extends Comparable> implements Seznam<Tip> {

    private Object[] heap;
    private int end = 0;

    public PrioritetnaVrsta() { this(100); }
    public PrioritetnaVrsta(int maxSize) { this.heap = new Object[maxSize]; }

    private void swap(int a, int b) {
        Object tmp = this.heap[a];
        this.heap[a] = this.heap[b];
        this.heap[b] = tmp;
    }

    private void bubbleUp(int index) {
        if (index == 0) return;
        int parentIdx = (index - 1) / 2;
        Tip element = (Tip) this.heap[index];
        Tip parent = (Tip) this.heap[parentIdx];
        if (element.compareTo(parent) > 0) {
            this.swap(index, parentIdx);
            this.bubbleUp(parentIdx);
        }
    }

    private void ensureCapacity() {
        if (this.end == this.heap.length) {
            Object[] tmp = new Object[this.heap.length * 2];
            System.arraycopy(this.heap, 0, tmp, 0, this.heap.length);
            this.heap = tmp;
        }
    }

    @Override
    public void add (Tip e) {
        this.ensureCapacity();
        this.heap[this.end++] = e;
        this.bubbleUp(this.end - 1);
    }

    private int[] getChildren(int index) {
        int[] children = new int[2];
        children[0] = index * 2 + 1;
        children[1] = index * 2 + 2;
        return children;
    }

    private boolean hasBothChildren(int index) {
        return this.getChildren(index)[1] < this.end;
    }

    private void bubbleDown(int index) {
        if (index >= this.end) return;
        int[] children = this.getChildren(index);
        Tip elt = (Tip) this.heap[index];
        if (children[0] < this.end) {
            Tip child = (Tip) this.heap[children[0]];
            int indexOfChild = children[0];
            if (this.hasBothChildren(index) && child.compareTo((Tip)this.heap[children[1]]) < 0) {
                child = (Tip) this.heap[children[1]];
                indexOfChild = children[1];
            }
            if (elt.compareTo(child) < 0) {
                this.swap(index, children[0]);
                bubbleDown(indexOfChild);
            }
        }
    }

    @Override
    public Tip removeFirst() {
        if (this.isEmpty())
            throw new java.util.NoSuchElementException();
        Tip elt = (Tip) this.heap[0];
        this.swap(0, --this.end);
        this.bubbleDown(0);
        return elt;
    }

    @Override
    public Tip getFirst() {
        if (this.isEmpty()) throw new
                java.util.NoSuchElementException();
        return (Tip) this.heap[0];
    }

    @Override
    public int depth() {
        if(this.end==0) return 0;
        return (int)
                (Math.log(this.end) / Math.log(2)) +1;
    }

    @Override
    public boolean isEmpty() {
        return this.end==0;
    }

    @Override
    public int size() {
        return this.end;
    }

    public void printTree() {
        System.out.println("Heap:");
        for(int i = 0; i < this.end; i++) {
            System.out.print(this.heap[i] + " ");
        }
        System.out.println();
    }

    @Override
    public Tip remove(Tip e) {
        if (this.isEmpty())
            throw new java.util.EmptyStackException();
        int index = -1;
        for (int i = 0; i < this.end; i++) {
            if(this.heap[i].equals(e)) {
                index = i;
                break;
            }
        }
        if (index == -1)
            throw new java.util.NoSuchElementException();
        Tip elt = (Tip) this.heap[index];
        this.swap(index, --this.end);
        this.bubbleDown(index);
        return elt;
    }

    @Override
    public boolean exists(Tip e) {
        if (this.isEmpty())
            throw new java.util.EmptyStackException();
        for (int i = 0; i < this.end; i++) {
            if (this.heap[i].equals(e))
                return true;
        }
        return false;
    }

    @Override
    public List<Tip> asList() {
        List<Tip> list = new ArrayList<>();
        for(int i = 0; i < this.end; i++) {
            list.add((Tip) this.heap[i]);
        }
        return list;
    }

    @Override
    public void print() {
        System.out.print("[ ");
        for(int i = 0; i < this.end; i++) {
            System.out.print(this.heap[i].toString() + " ");
        }
        System.out.println("]");
    }

    @Override
    public void save(OutputStream outputStream) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(this.heap);
        oos.close();
    }

    @Override
    public void restore(InputStream inputStream) throws IOException,ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        this.heap = (Object[]) ois.readObject();
        ois.close();
    }
}