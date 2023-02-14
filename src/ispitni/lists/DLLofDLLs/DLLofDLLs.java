package ispitni.lists.DLLofDLLs;

import ispitni.finkiHashingCodes.DLL;
import ispitni.finkiHashingCodes.DLLNode;

import java.util.Scanner;

public class DLLofDLLs {

    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        long sum = 0;
        long product = 1;
        DLLNode<DLL<Integer>> tmp = list.getFirst();
        while(tmp != null){
            DLLNode<Integer> tmp1 = tmp.element.getFirst();
            while(tmp1 != null){
                sum += tmp1.element;
                tmp1 = tmp1.succ;
            }
            product *= sum;
            sum = 0;
            tmp = tmp.succ;
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        in.close();
        System.out.println(findMagicNumber(list));
    }

}
