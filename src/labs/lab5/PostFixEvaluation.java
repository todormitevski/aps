package labs.lab5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostFixEvaluation {
    private static int getNextInt(char[] c, int start){
        int i = start;
        String num = "";
        while (c[i] != ' '){
            num += String.valueOf(c[i]);
            i++;
        }
        return Integer.parseInt(num);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        Stack<Integer> numbers = new Stack<Integer>();
        for(int i=0;i < exp.length;i++){
            if(Character.isDigit(exp[i])){
                numbers.push(getNextInt(exp,i));
                i += numbers.peek().toString().length();
            }
            else{
                char c = exp[i];
                if(c==' ') continue;
                int second = numbers.pop();
                int first = numbers.pop();
                if(c=='+') numbers.push(first+second);
                if(c=='-') numbers.push(first-second);
                if(c=='*') numbers.push(first*second);
                if(c=='/') numbers.push(first/second);
            }
        }
        System.out.println(numbers.pop());

        br.close();
    }
}