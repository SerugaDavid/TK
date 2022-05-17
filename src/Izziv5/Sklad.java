package Izziv5;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
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

    @Override
    public Tip remove(Tip e) {
        if (isEmpty())
            throw new EmptyStackException();
        Sklad<Tip> tmp = new Sklad<>();
        Tip tmp2 = null;
        while (!this.isEmpty()) {
            tmp2 = this.removeFirst();
            if (!tmp2.equals(e))
                tmp.add(tmp2);
            else
                break;
        }
        while (!tmp.isEmpty())
            this.add(tmp.removeFirst());
        if (tmp2 == null || !tmp2.equals(e))
            throw new NoSuchElementException();
        return tmp2;
    }

    @Override
    public boolean exists(Tip e) {
        if (isEmpty())
            throw new EmptyStackException();
        Sklad<Tip> tmp = new Sklad<>();
        Tip tmp2 = null;
        while (!this.isEmpty()) {
            tmp2 = this.removeFirst();
            tmp.add(tmp2);
            if (tmp2.equals(e))
                break;
        }
        while (!tmp.isEmpty())
            this.add(tmp.removeFirst());
        return tmp2 != null && tmp2.equals(e);
    }

    public List<Tip> asList(Element<Tip> node) {
        if (node == null)
            return new ArrayList<>();
        List<Tip> list = new ArrayList<>();
        list.add(node.vrednost);
        list.addAll(asList(node.naslednji));
        return list;
    }

    @Override
    public List<Tip> asList() {
        return asList(this.vrh);
    }


}
