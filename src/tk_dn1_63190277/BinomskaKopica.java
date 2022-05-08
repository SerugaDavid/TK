package tk_dn1_63190277;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinomskaKopica<Tip extends Comparable> implements Seznam<Tip> {

    class BinomialHeapNode<Tip extends Comparable> {
        public Tip value;
        public int degree;
        public BinomialHeapNode<Tip> parent;
        public BinomialHeapNode<Tip> child;
        public BinomialHeapNode<Tip> sibling;

        public BinomialHeapNode(Tip value) {
            this.value = value;
            this.degree = 0;
            this.parent = null;
            this.child = null;
            this.sibling = null;
        }
    }

    private BinomialHeapNode<Tip> topNode;
    private int length;

    public BinomskaKopica() {
        this.topNode = null;
        this.length = 0;
    }

    @Override
    public void add(Tip e) {
        BinomialHeapNode<Tip> node = new BinomialHeapNode<>(e);
        node.sibling = this.topNode;
        this.topNode = node;
        this.length++;
        this.fixStructure();
    }

    private void fixStructure() {
        if (this.length == 1)
            return;
        BinomialHeapNode<Tip> current = this.topNode;
        BinomialHeapNode<Tip> prev = null;
        BinomialHeapNode<Tip> max;
        BinomialHeapNode<Tip> min;
        while (current != null) {
            if (prev != null && current.degree == prev.degree) {
                if (current.value.compareTo(prev.value) < 0) {
                    max = prev;
                    min = current;
                }
                else {
                    max = current;
                    min = prev;
                }
                max.sibling = current.sibling;
                min.sibling = max.child;
                max.child = min;
                min.parent = max;
                current = max;
                //prev = max;
                max.degree++;
                if (this.topNode.degree >= max.degree-1)
                    this.topNode = max;
                else {
                    min = this.topNode;
                    int count = 0;
                    while (min.degree != max.degree - 1) {
                        min = min.sibling;
                        count++;
                    }
                    min = this.topNode;
                    for (int i = 0; i < count - 1; i++)
                        min = min.sibling;
                    min.sibling = max;
                }
            }
            if (current == null)
                return;
            prev = current;
            current = current.sibling;
        }
    }

    @Override
    public Tip removeFirst() {
        ArrayList<Object> max = this.getMaxElement();
        if (max == null)
            return null;
        Tip value = (Tip) max.get(0);
        int index = (int) max.get(1);
        BinomialHeapNode<Tip> node = (BinomialHeapNode<Tip>) max.get(2);
        this.length--;
        if (this.length == 0) {
            this.topNode = null;
            return value;
        }
        if (index == 0)
            this.topNode = node.sibling;
        else {
            BinomialHeapNode<Tip> current = this.topNode;
            for (int i = 0; i < index - 1; i++)
                current = current.sibling;
            current.sibling = node.sibling;
        }
        // split tree
        this.splitTree(node.child);
        return value;
    }

    private void splitTree(BinomialHeapNode<Tip> node) {
        if (node == null)
            return;
        if (node.sibling != null)
            this.splitTree(node.sibling);
        int index = this.getIndexByDegree(node.degree);
        node.parent = null;
        if (index == 0) {
            node.sibling = this.topNode;
            this.topNode = node;
            this.fixStructure();
            return;
        }
        BinomialHeapNode<Tip> current = this.topNode;
        for (int i = 0; i < index - 1; i++)
            current = current.sibling;
        node.sibling = current.sibling;
        current.sibling = node;
        this.fixStructure();
    }

    private int getIndexByDegree(int degree) {
        BinomialHeapNode<Tip> current = this.topNode;
        int index = 0;
        while (current != null) {
            if (current.degree >= degree)
                return index;
            current = current.sibling;
            index++;
        }
        return index;
    }

    private ArrayList<Object> getMaxElement() {
        if (this.isEmpty())
            return null;
        int counter = 0;
        int maxCounter = 0;
        BinomialHeapNode<Tip> maxCurrent = this.topNode;
        Tip max = this.topNode.value;
        BinomialHeapNode<Tip> current = this.topNode;
        while (current.sibling != null) {
            if (current.sibling.value.compareTo(max) > 0) {
                max = current.sibling.value;
                maxCounter = counter;
                maxCurrent = current.sibling;
            }
            current = current.sibling;
            counter++;
        }
        return new ArrayList<>(Arrays.asList(max, maxCounter, maxCurrent));
    }

    @Override
    public Tip getFirst() {
        ArrayList<Object> max = this.getMaxElement();
        if (max == null)
            return null;
        return (Tip) max.get(0);
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public int depth() {
        if (this.isEmpty())
            return 0;
        BinomialHeapNode<Tip> current = this.topNode;
        while (current.sibling != null)
            current = current.sibling;
        return current.degree;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public Tip remove(Tip e) {
        return null;
    }

    @Override
    public boolean exists(Tip e) {
        return asList().contains(e);
    }

    public List<Tip> asList(BinomialHeapNode<Tip> node) {
        List<Tip> list = new ArrayList<>();
        if (node == null)
            return list;
        list.add(node.value);
        list.addAll(asList(node.child));
        list.addAll(asList(node.sibling));
        return list;
    }

    @Override
    public List<Tip> asList() {
        return asList(this.topNode);
    }
}
