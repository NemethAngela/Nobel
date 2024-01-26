public class NobelDij {

    private int evszam;
    private String tipus;
    private String keresztnev;
    private String vezeteknev;

    public NobelDij(int evszam, String tipus, String keresztnev, String vezeteknev) {
        this.evszam = evszam;
        this.tipus = tipus;
        this.keresztnev = keresztnev;
        this.vezeteknev = vezeteknev;
    }

    public int getEvszam() {
        return evszam;
    }

    public String getTipus() {
        return tipus;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public void setVezeteknev(String ujVezetekNev) {        ////vezetéknév változtatása, set-el
        vezeteknev = ujVezetekNev;
    }

    @Override
    public String toString() {
        return "Év: " + evszam + ", Típus: " + tipus + ", Név: " + keresztnev + " " + vezeteknev;
    }

    public void kiir() {
        System.out.println(this.toString());
    }
}
