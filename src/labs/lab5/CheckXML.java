package labs.lab5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class CheckXML {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String [] redovi = new String[n];

        for(int i=0;i<n;i++)
            redovi[i] = br.readLine();
        int valid = 1 ;

        // Vasiot kod tuka
        // Moze da koristite dopolnitelni funkcii ako vi se potrebni
        Stack<String> stack = new Stack<String>();
        for(String red : redovi){
            if(red.charAt(1)!='/' && red.charAt(0)=='[') stack.push(red);
            else{
                if(red.charAt(0)!='[') continue;
                try {
                    if (!stack.pop().substring(1).equals(red.substring(2))) valid = 0;
                }catch (Exception e){
                    valid = 0;
                }
            }
        }

        System.out.println(valid);

        br.close();
    }
}