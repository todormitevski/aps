package labs.lab1;

import java.util.Scanner;

//За дадена низа од случајни броеви кои се внесуваат од
// стандарден влез, да се направи преместување на сите
// нули на крајот на низата. На стандарден излез да се
// испечати трансформираната низа.

public class PushZero
{
    static void pushZerosToEnd(int arr[], int n)
    {
        int lastNum=0;

        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr[lastNum++]=arr[i];
            }
        }

        while(lastNum++<n){
            arr[lastNum]=0;
        }

        System.out.println("Transformiranata niza e:");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main (String[] args)
    {
        int arr[] = new int[100];
        int n;

        Scanner input=new Scanner(System.in);
        n=input.nextInt();

        for(int i=0;i<n;i++){
            arr[i]= input.nextInt();
        }

        pushZerosToEnd(arr, n);
    }
}
