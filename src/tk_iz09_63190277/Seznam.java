package tk_iz09_63190277;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface Seznam<Tip> {
    // Dodajanje elementa v podatkovno strukturo
    void add(Tip e);
    // Odstranjevanje (in vračanje) prvega elementa iz pod. struk.
    Tip removeFirst();
    // Vračanje prvega elementa iz pod. struk.
    Tip getFirst();
    // Število elementov v podatkovni strukturi
    int size();
    // Globina podatkovne strukture
    int depth();
    // Ali je podakovna struktura prazna
    boolean isEmpty();
    // odstranjevanje (in vracanje) dolocenega elementa iz strukture
    Tip remove(Tip e);
    // ali element obstaja v strukturi
    boolean exists(Tip e);

    List<Tip> asList();

    void print();

    void save(OutputStream outputStream) throws IOException;

    void restore(InputStream inputStream) throws IOException,ClassNotFoundException;
}