package vezbi;

import java.util.Scanner;

public class Sp2 {
    private static void readMatrix(Scanner sc, int n, int m, int[][] matrix) {
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    private static int getRowSum(int m, int[][] matrix, int row, int column) {
        int sum = 0;
        for(int j = 0; j< m; j++){
            if(matrix[row][j] != matrix[row][column]){
                sum += matrix[row][j];
            }
        }
        return sum;
    }

    private static void writeMatrix(int n, int m, int[][] matrix) {
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                System.out.printf("%d ",matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] matrix = new int[n][m];
        readMatrix(sc, n, m, matrix);
        int row = 0, column = 0, max = matrix[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] > max){
                    max = matrix[i][j];
                    row = i;
                    column = j;
                }
            }
        }
        int sum = getRowSum(m, matrix, row, column);
        matrix[row][column] = sum;
        writeMatrix(n, m, matrix);
    }
}
