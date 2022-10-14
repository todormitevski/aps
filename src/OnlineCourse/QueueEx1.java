package OnlineCourse;

import java.util.Queue;
import java.util.LinkedList;

public class QueueEx1 {
    public String [] generateBinaryNumbers(int n){
        String[] result=new String[n];
        Queue<String> q=new LinkedList<>();
        q.offer("1");
        for(int i=0;i<n;i++){
            result[i]=q.poll();
            String n1=result[i]+"0";
            String n2=result[i]+"1";
            q.offer(n1);
            q.offer(n2);
        }
        return result;
    }

    public static void main(String[] args){
        QueueEx1 ex=new QueueEx1();
        String[] result=ex.generateBinaryNumbers(5);
        for(String res:result){
            System.out.println(res);
        }
    }
}
