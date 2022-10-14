package OnlineCourse;

import java.util.Arrays;

public class WorkingWith2DArrays {
    public static void main(String[] args){
        char[][] board=new char [3][3];
        //polni
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]='-';
            }
        }
        //System.out.println(Arrays.deepToString(board));

//        char[][] boardTwo=new char[][]{
//                new char[]{'0', '-', '-'},
//                new char[]{'0', '-', '-'},
//                new char[]{'0', '-', '-'}
//        };

        board[0][0] = '0';
        board[1][0] = '0';
        board[2][0] = '0';

        //print
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
