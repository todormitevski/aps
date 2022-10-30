package labs.lab1;

import java.util.Scanner;

class RabotnaNedela{

    private int [] casovi;
    private int brNedela;

    public RabotnaNedela(int[] casovi, int brNedela) {
        super();
        this.casovi = casovi;
        this.brNedela = brNedela;
    }
    @Override
    public String toString() {
        return null;
    }

    public int totalHoursInOneWeek(){
        int sum=0;
        for(int i=0;i<casovi.length;i++){
            sum+=casovi[i];
        }
        return sum;
    }
}

class Rabotnik{

    private String ime;
    private RabotnaNedela [] nedeli;

    public Rabotnik(String ime, RabotnaNedela[] nedeli) {
        super();
        this.ime = ime;
        this.nedeli = nedeli;
    }
    @Override
    public String toString() {
        return null;
    }

    public int sumNedeli(Rabotnik r){
        int sum=0;
        for(int i=0;i<nedeli.length;i++){
            sum+=nedeli[i].totalHoursInOneWeek();
        }
        return sum;
    }

    public String getIme() {
        return ime;
    }

    public RabotnaNedela[] getNedeli() {
        return nedeli;
    }

    public RabotnaNedela getNedela(int i){
        return nedeli[i];
    }
}

public class Rabota {

    public static Rabotnik najvreden_rabotnik(Rabotnik [] niza)
    {
        int max=0, maxIndex=0;
        for(int i=0;i<niza.length;i++){
            if(niza[i].sumNedeli(niza[i])>max){
                max=niza[i].sumNedeli(niza[i]);
                maxIndex=i;
            }
        }
        return niza[maxIndex];
    }
    public static void table(Rabotnik [] niza)
    {
        System.out.println("Rab   1   2   3   4   Vkupno");
        for(int i=0;i<niza.length;i++){
            System.out.print(niza[i].getIme());
            for(int j=0;j<niza[i].getNedeli().length;j++){
                System.out.print("   " + niza[i].getNedela(j).totalHoursInOneWeek());
            }
            System.out.println("   " + niza[i].sumNedeli(niza[i]));
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        Rabotnik [] niza = new Rabotnik[n];
        for(int i=0;i<n;i++)
        {
            //vasiot kod tuka
            String name;
            input.nextLine();
            name = input.nextLine();
            RabotnaNedela[] rabotniNedeli=new RabotnaNedela[4];
            for(int j=0;j<4;j++){
                int[] casoviVoRabotniDenovi=new int[5];
                for(int k=0;k<5;k++){
                    casoviVoRabotniDenovi[k]=input.nextInt();
                }
                rabotniNedeli[j]=new RabotnaNedela(casoviVoRabotniDenovi,j+1);
            }
            niza[i]=new Rabotnik(name,rabotniNedeli);
        }

        table(niza);
        System.out.println("NAJVREDEN RABOTNIK: " +najvreden_rabotnik(niza).getIme());

    }
}