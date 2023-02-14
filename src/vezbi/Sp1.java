package vezbi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Sp1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        int maxProduct = 0, lineProduct = 1, index = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                lineProduct *= matrix[i][j];
            }
            if(lineProduct > maxProduct){
                maxProduct = lineProduct;
                index = i;
            }
            lineProduct = 1;
        }
        for(int j=0;j<m;j++){
            System.out.printf("%d ", matrix[index][j]);
        }
    }
}
