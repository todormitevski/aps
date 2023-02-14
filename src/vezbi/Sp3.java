package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sp3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        List<String> words = new ArrayList<String>();
        for(int i=parts.length-1;i>=0;i--){
            words.add(parts[i]);
        }
        words.forEach(word -> System.out.printf("%s ",word));
    }
}
