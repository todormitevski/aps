//package ispitni.domainsVisited;
//
//import javax.swing.*;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.HashMap;
//
//public class DomainsVisited {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        HashMap<String,Integer> visitCount = new HashMap<String,Integer>();
//        for(int i=0;i<n;i++){
//            String line = br.readLine();
//            String[] parts = line.split("\\s+");
//            int occurrences = Integer.parseInt(parts[0]);
//            String domain = parts[1];
//
//            visitCount.putIfAbsent(domain,0);
//            visitCount.computeIfPresent(domain, (k,v) -> v + occurrences);
//            for(char c : domain.toCharArray()){
//                if(c == '.'){
//                    int beginning = domain.indexOf(c);
//                    domain = domain.substring(beginning + 1);
//                    visitCount.putIfAbsent(domain,0);
//                    visitCount.computeIfPresent(domain, (k,v) -> v + occurrences);
//                }
//            }
//        }
//        int m = Integer.parseInt(br.readLine());
//        for(int i=0;i<m;i++){
//            String line = br.readLine();
//            int visits = visitCount.get(line);
//            System.out.println(visits);
//        }
//    }
//}
