package naloga.src;

public class Oseba {
    private String emso;
    private String ime;
    private String priimek;
    private int odmerki;
    private String cepivo;

    public Oseba(String emso, String ime, String priimek, int odmerki, String cepivo) {
        this.emso = emso;
        this.ime = ime;
        this.priimek = priimek;
        this.odmerki = odmerki;
        this.cepivo = cepivo;
    }

    // create all getters
    public String getEmso() {
        return emso;
    }

    public String getIme() {
        return ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public int getOdmerki() {
        return odmerki;
    }

    public String getCepivo() {
        return cepivo;
    }

    public String celoIme() {
        return priimek + ", " + ime;
    }
}
