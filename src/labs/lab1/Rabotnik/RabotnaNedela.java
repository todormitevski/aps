package labs.lab1.Rabotnik;

public class RabotnaNedela{

    private int [] casovi;
    private int brNedela;

    public RabotnaNedela(int[] casovi, int brNedela) {
        super();
        this.casovi = casovi;
        this.brNedela = brNedela;
    }

    public int getCasovi() {
        int sum=0;
        for(int i=0;i<casovi.length;i++){
            sum+=casovi[i];
        }
        return sum;
    }

    public void setCasovi(int[] casovi) {
        this.casovi = casovi;
    }

    public int getBrNedela() {
        return brNedela;
    }

    public void setBrNedela(int brNedela) {
        this.brNedela = brNedela;
    }

    @Override
    public String toString() {

        return null;
    }

}
