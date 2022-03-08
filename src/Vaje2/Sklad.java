package Vaje2;

import java.util.NoSuchElementException;

public class Sklad<Tip> {
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

    public void push(Tip vrednost) {
        this.vrh = new Element<>(vrednost, this.vrh);
    }

    public Tip pop() {
        if (this.vrh == null)
            throw new NoSuchElementException();
        Tip tmp = this.vrh.vrednost;
        this.vrh = this.vrh.naslednji;
        return tmp;
    }
}
