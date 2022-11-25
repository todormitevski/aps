package labs.lab4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    static int najdiNajdolgaCikCak(int a[]) {
        // Vasiot kod tuka

        int max = 1, br = 1;
        boolean sign;
        for (int i = 0; i < a.length - 1; i++) {

            sign = getSign(a[i]);
            if(a[i] == 0) {
                br = 0;
            }

            if (sign != getSign(a[i + 1]) && a[i+1] != 0) {
                br++;
            } else br = 1;

            if (br > max) {
                max = br;
            }
        }

        return max;
    }

    private static boolean getSign(int num) {
        return num >= 0;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}