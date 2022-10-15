package aud0;

import java.util.Scanner;

public class IO {
    public static void main(String[] args) {
        System.out.println("Hello!");
        Scanner input=new Scanner(System.in);
        System.out.println("Vnesi eden cel broj");
//        int broj=input.nextInt();
//        System.out.println("Vneseniot broj e: "+broj);
//        if(broj>10){
//            System.out.println("Brojot e > od 10");
//        } else System.out.println("Brojot e < od 10");

        Box<Integer> box=new Box<Integer>();
        box.setObject(10);

        Box<String> box1=new Box<String>("Zhaba");

        System.out.println(box.toString());
        System.out.println(box1.toString());

        Box<TV> kutijaSoTelevizor=new Box<TV>();
        TV t1=new TV("LG", 40, true);
        kutijaSoTelevizor.setObject(t1);

        System.out.println("Televizorot e "+t1);
        System.out.println("Kutijata so televizor: "+kutijaSoTelevizor);

        Box<Sarma> kutijaSoSarma=new Box<Sarma>();
        Sarma s1=new Sarma(10, true, 15.5f);
        kutijaSoSarma.setObject(s1);

        System.out.println("Sarmata e "+s1);
        System.out.println("Kutijata so sarma: "+kutijaSoSarma);

        TV televizori[]=new TV[10];
        televizori[0]=t1;

//        Box<TV>[] paleta;
//        paleta[0]=t1;
        //...
    }
}
