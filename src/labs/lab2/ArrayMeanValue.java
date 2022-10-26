package labs.lab2;

import java.util.Scanner;

import static java.lang.Math.abs;

public class ArrayMeanValue {

    //todo: implement function
    public static int brojDoProsek(Array<Integer> arr) {
        for(int i=0;i<arr.getSize();i++){
            double tmp=0;
            tmp=arr.get(i);
            if(tmp==prosekArr(arr)){
                return arr.get(i);
            }

            double razlika=0, minRazlika=0;
            razlika= abs(prosekArr(arr)-arr.get(i));
            if(razlika<minRazlika){
                minRazlika=razlika;
            }

            int[] tmpArr=new int[arr.getSize()];
            if(){
                tmpArr[i]+=arr.get(i);
            }
        }
    }

    private static double prosekArr(Array<Integer> arr) {
        double prosek=0;
        for(int i = 0; i< arr.getSize(); i++){
            prosek+= arr.get(i);
        }
        prosek/= arr.getSize();
        return prosek;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        Array<Integer> arr = new Array<>(N);

        for(int i=0;i<N;i++) {
            arr.insertLast(input.nextInt());
        }

        System.out.println(brojDoProsek(arr));
    }
}
