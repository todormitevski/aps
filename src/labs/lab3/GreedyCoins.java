package labs.lab3;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyCoins {

    //insane solution
//    public static int minNumCoins(int coins[], int sum) {
//        //Vasiot kod ovde
//        int tmp = sum;
//        int max = 0;
//        int br = 0;
//
//        boolean daliDaZimaLol[] = new boolean[coins.length];
//
//        while (tmp != 0){
//            for(int i=0;i<coins.length;i++){
//                if(coins[i] < max && daliDaZimaLol[i] == false){
//                    max = coins[i];
//                    tmp -= coins[i];
//                    br++;
//                    if(!(tmp - max < 0)){
//                        daliDaZimaLol[i] = true; //flag za da ne zima vekje
//                    }
//                }
//            }
//        }
//        return br;
//    }

    public static int minNumCoins(int coins[], int sum) {
        //Vasiot kod ovde
        Arrays.sort(coins);
        int tmp = sum, br = 0;

        for(int i=coins.length-1;i>=0;i--){
            while(tmp - coins[i] >= 0){
                br++;
                tmp -= coins[i];
                //System.out.println(tmp);
            }
        }
        return br;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String coinsStringLine = input.nextLine();
        String coinsString[] = coinsStringLine.split(" ");
        int coins[] = new int[coinsString.length];
        for(int i=0;i<coinsString.length;i++) {
            coins[i] = Integer.parseInt(coinsString[i]);
        }

        int sum = input.nextInt();

        System.out.println(minNumCoins(coins, sum));
    }
}