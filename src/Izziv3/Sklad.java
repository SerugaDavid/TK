package Izziv3;

import java.util.NoSuchElementException;

public class Sklad<Tip> implements Seznam<Tip> {
    private Element<Tip> vrh;

    class Element<Tip> {
        public Tip vrednost;
        public Element<Tip> naslednji;

        public Element(Tip vrednost, Element<Tip> naslednji) {
            this.vrednost = vrednost;
            this.naslednji = naslednji;
        }
    }

    public Sklad() {
        this.vrh = null;
    }

    private void push(Tip vrednost) {
        this.vrh = new Element<>(vrednost, this.vrh);
    }

    private Tip pop() {
        if (this.vrh == null)
            throw new NoSuchElementException();
        Tip tmp = this.vrh.vrednost;
        this.vrh = this.vrh.naslednji;
        return tmp;
    }

    private Tip top() {
        if (this.vrh == null)
            throw new NoSuchElementException();
        return this.vrh.vrednost;
    }

    @Override
    public void add(Tip e) {
        this.push(e);
    }

    @Override
    public Tip removeFirst() {
        return this.pop();
    }

    @Override
    public Tip getFirst() {
        return this.top();
    }

    @Override
    public int size() {
        Element tmp = this.vrh;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.naslednji;
        }
        return count;
    }

    @Override
    public int depth() {
        return this.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
}
