package labs.lab1.Rabotnik;

public class Rabotnik{

    private String ime;
    private RabotnaNedela [] nedeli;

    public Rabotnik(String ime, RabotnaNedela[] nedeli) {
        super();
        this.ime = ime;
        this.nedeli = nedeli;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public RabotnaNedela[] getNedeli() {
        return nedeli;
    }

    //test
    public RabotnaNedela getNedela(int i){
        return nedeli[i];
    }

    public void setNedeli(RabotnaNedela[] nedeli) {
        this.nedeli = nedeli;
    }

    //implementations

    public int vkupnoCasovi(){ //(not vkupno,)
        int sum=0;
        for (int i=0;i< nedeli.length;i++){
            sum+=nedeli[i].getCasovi();
        }
        return sum;
    }

    @Override
    public String toString() {

        return null;
    }

}
