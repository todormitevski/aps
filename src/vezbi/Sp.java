package vezbi;

import java.util.Arrays;
import java.util.Scanner;

public class Sp {
    public static int[] reverse(int[] nums){
        int[] newArr = new int[nums.length];
        int j = 0;
        for(int i=nums.length-1;i>=0;i--){
            newArr[j++] = nums[i];
        }
        return newArr;
    }

    private static int[] removeEverySecondElem(int[] nums) {
        int n = (nums.length%2==0) ? nums.length/2 : nums.length/2+1;
        int[] newArr = new int[n];
        int j = 0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                newArr[j++] = nums[i];
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for(var i=0;i<n;i++){
            numbers[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(reverse(numbers)));
        System.out.println(Arrays.toString(removeEverySecondElem(numbers)));
        System.out.println(Arrays.toString(reverse(removeEverySecondElem(numbers))));
    }
}
