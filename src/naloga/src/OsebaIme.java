package naloga.src;

public class OsebaIme implements java.util.Comparator<Oseba> {
    @Override
    public int compare(Oseba o1, Oseba o2) {
        String ime1 = o1.celoIme();
        String ime2 = o2.celoIme();
        return ime1.compareToIgnoreCase(ime2);
    }
}
