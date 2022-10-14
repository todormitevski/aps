package aud0;

import java.util.Arrays;

public class Vraboten {
    private String ime;
    private String prezime;
    private static double bod;
    private double plata;
    private int stazh;
    private int brBodovi;
    private Zadaca1 [] zadaci;
    private int brZadaci;

    public Vraboten() {

    }

    public Vraboten(String ime, String prezime, int stazh, int brBodovi) {
        super();
        this.ime = ime;
        this.prezime = prezime;
        this.stazh = stazh;
        this.brBodovi = brBodovi;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public static double getBod() {
        return bod;
    }

    public static void setBod(double bod) {
        Vraboten.bod = bod;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public int getStazh() {
        return stazh;
    }

    public void setStazh(int stazh) {
        this.stazh = stazh;
    }

    public int getBrBodovi() {
        return brBodovi;
    }

    public void setBrBodovi(int brBodovi) {
        this.brBodovi = brBodovi;
    }

    public Zadaca1[] getZadaci() {
        return zadaci;
    }

    public void setZadaci(Zadaca1[] zadaci) {
        this.zadaci = zadaci;
    }

    public int getBrZadaci() {
        return brZadaci;
    }

    public void setBrZadaci(int brZadaci) {
        this.brZadaci = brZadaci;
    }

    @Override
    public String toString() {
        return "Vraboten{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", plata=" + plata +
                ", stazh=" + stazh +
                ", brBodovi=" + brBodovi +
                ", zadaci=" + Arrays.toString(zadaci) +
                ", brZadaci=" + brZadaci +
                '}';
    }

    public void dodadi(Zadaca1 elem){
        if(brZadaci==10){
            System.out.println("Ne moze da se dodade zadaca!");
        } else zadaci[brZadaci++]=elem;
    }

    void print(){
        for(int i=0;i<zadaci.length;i++){
            System.out.println(zadaci[i] + " ");
        }
    }

    public static void main(String[] args) {
        Vraboten v1=new Vraboten("Genji", "Shimada", 0, 30);
        Zadaca1 z=new Zadaca1("np", 30, true);
        v1.dodadi(z);
        v1.print();
    }
}
