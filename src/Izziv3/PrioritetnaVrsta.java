package Izziv3;

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

    private void bubbleUp() {
        int eltIdx = this.end - 1;
        while (eltIdx >= 0) {
            Tip elt = (Tip) this.heap[eltIdx];
            int childIdx = eltIdx * 2 + 1;
            if (childIdx < this.end) {
                Tip child = (Tip) this.heap[childIdx];
                if (childIdx + 1 < this.end && child.compareTo(this.heap[childIdx+1]) < 0)
                    child = (Tip) this.heap[++childIdx];
                if (elt.compareTo(child) >= 0)
                    return;
                this.swap(eltIdx, childIdx);
            }
            eltIdx = eltIdx % 2 == 1 ? (eltIdx - 1) / 2 : (eltIdx - 2) / 2;
        }
    }
    @Override
    public void add (Tip e) {
        this.heap[this.end++] = e;
        this.bubbleUp();
    }

    private void bubbleDown(int start) {
        int eltIdx = start;
        int childIdx = eltIdx * 2 + 1;
        while (childIdx <= this.end) {
            Tip elt = (Tip) this.heap[eltIdx];
            Tip child = (Tip) this.heap[childIdx];
            if (childIdx + 1 < this.end && child.compareTo(this.heap[childIdx+1]) < 0)
                child = (Tip) this.heap[++childIdx];
            if (elt.compareTo(child) >= 0)
                return;
            this.swap(eltIdx, childIdx);
            eltIdx = childIdx;
            childIdx = eltIdx * 2 + 1;
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
        if(this.isEmpty()) throw new
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
        for (int i = 0; i < this.end; i++) {
            System.out.println(this.heap[i].toString());
        }
        System.out.println("---");
    }
}