package aud0;

public class Zadaca1 {
    private String opis;
    private int casovi;
    private boolean status;

    public Zadaca1() {
    }

    public Zadaca1(String opis, int casovi, boolean status) {
        this.opis = opis;
        this.casovi = casovi;
        this.status = status;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getCasovi() {
        return casovi;
    }

    public void setCasovi(int casovi) {
        this.casovi = casovi;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Zadaca1{" +
                "opis='" + opis + '\'' +
                ", casovi=" + casovi +
                ", status=" + status +
                '}';
    }

    public static void main(String[] args) {
        Zadaca1 z=new Zadaca1("APS", 30, true);
        System.out.println(z.toString());
    }
}
