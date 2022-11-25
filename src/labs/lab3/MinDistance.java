package labs.lab3;

import java.util.Scanner;

public class MinDistance {

    public static float minimalDistance(float points[][]) {
        //Vasiot kod ovde
        //Math.sqrt(Math.sqr(x2 - x1) + Math.sqr(y2 - y1));
        float x1, x2, y1, y2, min = 9999; //min - distance between 2 dots

        for(int i=0;i<points.length-1;i++){
            for(int j=i+1;j<points.length;j++){
                x1 = points[i][0]; y1 = points[i][1]; //dot 1
                x2 = points[j][0]; y2 = points[j][1]; //dot 2
                float d = (float) Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));

                if(d < min){
                    min = d;
                }
            }
        }

        return min;
    }

    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        float points[][] = new float[N][2];

        for(int i=0;i<N;i++) {
            points[i][0] = input.nextFloat();
            points[i][1] = input.nextFloat();
        }

        System.out.printf("%.2f\n", minimalDistance(points));
    }
}