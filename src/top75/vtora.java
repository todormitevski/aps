package top75;

import java.util.*;

public class vtora {
    //Given an integer array,
    //check if it contains a subarray
    //having zero-sum.

    /*
    Input:  { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }

    Output: Subarray with zero-sum exists

    The subarrays with a sum of 0 are:

    { 3, 4, -7 }
    { 4, -7, 3 }
    { -7, 3, 1, 3 }
    { 3, 1, -4 }
    { 3, 1, 3, 1, -4, -2, -2 }
    { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }
     */

    public static boolean zeroSum(int[] array){
        Set<Integer> hashSet = new HashSet<>();
        int sum = 0;
        hashSet.add(0);

        for(int i=0;i<array.length;i++){
            sum += array[i];
            if(hashSet.contains(sum)) return true;
            hashSet.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {

        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }

        if(zeroSum(array)){
            System.out.println("ima");
        } else System.out.println("nema be");
    }
}
