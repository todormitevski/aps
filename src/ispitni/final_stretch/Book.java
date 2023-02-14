package ispitni.final_stretch;

import ispitni.finkiHashingCodes.CBHT;
import ispitni.finkiHashingCodes.MapEntry;
import ispitni.finkiHashingCodes.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Book {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CBHT<String,Integer> table = new CBHT<>(51);
        CBHT<String,String> tableWholeSentence = new CBHT<>(26);
        while(true){
            String line = br.readLine();
            if(line.equals("#"))
                break;
            String[] parts = line.split(", ");
            String sentence = parts[0].toLowerCase();
            String[] sentenceParts = sentence.split("\\s+");
            int number = Integer.parseInt(parts[1]);
            for(String word : sentenceParts){
                table.insert(word,number);
                tableWholeSentence.insert(word,sentence);
            }
        }
        int n = Integer.parseInt(br.readLine());
        br.lines()
                .limit(n)
                .forEach(line ->{
                    String[] words = line.toLowerCase().split("\\s+");
                    boolean flag = false;
                    for(String word : words){
                        if(table.search(word) != null){
                            if(words.length > 1){
                                String sentence = tableWholeSentence.search(word).element.value;
                                if(!sentence.contains(line.toLowerCase())){
                                    flag = false;
                                    break;
                                }
                            }
                            System.out.println(table.search(word).element.value);
                            flag = true;
                            break;
                        } else{
                            System.out.println("Not found");
                            flag = true;
                        }
                    }
                    if(!flag){
                        System.out.println("Not found");
                    }
                });
    }
}
