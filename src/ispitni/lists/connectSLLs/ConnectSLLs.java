package ispitni.lists.connectSLLs;

import ispitni.finkiHashingCodes.SLL;
import ispitni.finkiHashingCodes.SLLNode;

import java.util.Scanner;

public class ConnectSLLs {
    public static SLL<Integer> connectLists(SLL<Integer> list1, SLL<Integer> list2){
        SLL<Integer> result = new SLL<Integer>();
        SLLNode<Integer> tmp1 = list1.getFirst();
        SLLNode<Integer> tmp2 = list2.getFirst();
        int counter = 0;
        while(tmp1 != null && tmp2 != null){
            while(tmp1 != null){
                if(counter == 2){
                    counter = 0;
                    break;
                }
                result.insertLast(tmp1.element);
                counter++;
                tmp1 = tmp1.succ;
            }
            while(tmp2 != null){
                if(counter == 2){
                    counter = 0;
                    break;
                }
                result.insertLast(tmp2.element);
                counter++;
                tmp2 = tmp2.succ;
            }
        }
        while(tmp1 != null){
            result.insertLast(tmp1.element);
            tmp1 = tmp1.succ;
        }
        while(tmp2 != null){
            result.insertLast(tmp2.element);
            tmp2 = tmp2.succ;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL<Integer> list1 = new SLL<Integer>();
        SLL<Integer> list2 = new SLL<Integer>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            list1.insertLast(sc.nextInt());
        }
        n = sc.nextInt();
        for(int i=0;i<n;i++){
            list2.insertLast(sc.nextInt());
        }
        System.out.println(connectLists(list1,list2));
    }
}
