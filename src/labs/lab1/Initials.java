package labs.lab1;

import java.util.Scanner;

//За дадено име и презиме на личност кои се внесуваат
// од стандарден влез, да се испечатат иницијалите за
// таа личност. На влез во првиот ред се дава број на
// личности за кои ќе се внесуваат соодветото име и
// презиме. Во наредните линии се внесуваат имињата и
// презимињата одделени со празно место.

public class Initials {

    static void printInitials(String name)
    {
        String tmp = "";
        if (Character.isAlphabetic(name.charAt(0))) {
            tmp+=name.charAt(0);
        }
        for(int i=0;i<name.length();i++){
            if(name.charAt(i) == ' '){
                tmp+=name.charAt(++i);
            }
        }
        System.out.print(tmp.toUpperCase());
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        String name;
        input.nextLine();

        for(int i=0; i<n; i++){
            name = input.nextLine();
            printInitials(name);
            System.out.println();
        }
    }
}