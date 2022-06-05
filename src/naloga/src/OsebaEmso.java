package naloga.src;

public class OsebaEmso implements java.util.Comparator<Oseba> {
    @Override
    public int compare(Oseba o1, Oseba o2) {
        String emso1 = o1.getEmso();
        String emso2 = o2.getEmso();
        return emso1.compareToIgnoreCase(emso2);
    }
}
