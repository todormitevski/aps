package labs.lab1.Rabotnik;

import java.util.Scanner;

public class Main {

    public static Rabotnik najvreden_rabotnik(Rabotnik [] niza)
    {
        int maxIndex=0, max=0;
        for(int i=0;i< niza.length;i++){
            if(sumNedeli(niza[i])>max){
                max=sumNedeli(niza[i]);
                maxIndex=i;
            }
        }
        return niza[maxIndex];
    }
    public static void table(Rabotnik [] niza)
    {

    }

    //implementations

    public static int sumNedeli(Rabotnik r){
        int sum=0;
        for(int i=0;i<r.getNedeli().length;i++){
            sum+=r.getNedeli()[i].getCasovi();
        }
        return sum;
    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        Rabotnik [] niza = new Rabotnik[n];
        for(int i=0;i<n;i++)
        {
            //vasiot kod tuka
            niza[i].setIme(input.nextLine());
            //niza[i].setNedeli(input.nextInt());
            for(int j=0;j<4;j++){
                niza[i].getNedela(j).setCasovi();
            }
        }

        table(niza);
        System.out.println("NAJVREDEN RABOTNIK: " +najvreden_rabotnik(niza).getIme());

    }
}
