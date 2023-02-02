//package top75;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class prva {
//    //Given an unsorted integer array,
//    // find a pair with the given sum in it.
//
//    public static void findPair(int[] array, int target){
//        Map<Integer,Integer> hashmap = new HashMap<>();
//
//        for(int i=0;i<array.length;i++){
//            if(hashmap.containsKey(target - array[i])){
//                System.out.printf("Pair found (%d, %d)", target - array[i], array[i]);
//                return;
//            }
//            hashmap.put(array[i], i);
//        }
//        System.out.println("Pair not found");
//    }
//
//    public static void main(String[] args) {
//        int target;
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] array = new int[n]; /*= {0,6,2,4,1,3,5};*/
//
//        for(int i=0;i<n;i++){
//            array[i] = sc.nextInt();
//        }
//        target = sc.nextInt();
//
//        findPair(array, target);
//    }
//}
