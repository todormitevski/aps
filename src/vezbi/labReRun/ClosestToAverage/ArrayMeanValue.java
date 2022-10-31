package vezbi.labReRun.ClosestToAverage;

import java.util.Scanner;

import static java.lang.Math.abs;

public class ArrayMeanValue {

    //todo: implement function
    public static int brojDoProsek(Array<Integer> arr) {
        int min=0, minIndex=0;
        for(int i=0;i<arr.getSize();i++){
            if(arr.get(i) == arrayAvg(arr))
                minIndex=i;
            else minIndex=closestFromTwo(arr);
        }
        return arr.get(minIndex);
    }

    private static double arrayAvg(Array<Integer> arr) {
        double prosek=0;
        for(int i = 0; i< arr.getSize(); i++){
            prosek+= arr.get(i);
        }
        prosek/= arr.getSize();
        return prosek;
    }

    private static int closestFromTwo(Array<Integer> arr){
        int closestIndex=0;
        for (int i=0;i<arr.getSize();i++) {
            if(abs(arr.get(i)-arrayAvg(arr)) == abs(arr.get(i+1)-arrayAvg(arr))){
                if(arr.get(i)<arr.get(i+1)){
                    closestIndex=i;
                } else closestIndex=i+1;
            }
        }
        return closestIndex;
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
