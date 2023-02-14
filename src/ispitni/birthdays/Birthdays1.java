package ispitni.birthdays;

import ispitni.finkiHashingCodes.OBHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Birthdays1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        OBHT<String,String> birthdays = new OBHT<String,String>(n * 2);
        br.lines()
                .limit(n)
                .forEach(line ->{
                    String[] parts = line.split("\\s+");
                    String name = parts[0] + " " + parts[1];
                    String[] dateParts = parts[2].split("/");
                    String dayMonth = dateParts[0] + "/" + dateParts[1];
                    String year = dateParts[2];
                    String value = name + " " + year;
                    if(birthdays.search(dayMonth) == -1){
                        birthdays.insert(dayMonth,value);
                    } else{
                        int index = birthdays.search(dayMonth);
                        String gottenValue = birthdays.buckets[index].value;
                        gottenValue += "#" + value;
                        birthdays.insert(dayMonth,gottenValue);
                    }
                });
        String dateToSearch = br.readLine();
        String[] dateParts = dateToSearch.split("/");
        String dateMonth = dateParts[0] + "/" + dateParts[1];
        int year = Integer.parseInt(dateParts[2]);
        int index = birthdays.search(dateToSearch.substring(0,5));
        if(index == -1){
            System.out.println("Nema");
        } else{
            String value = birthdays.buckets[index].value;
            String[] valueParts = value.split("#");
            List<String> outputList = new ArrayList<String>();
            for(String fullNameYear : valueParts){
                String[] parts = fullNameYear.split("\\s+");
                String name = parts[0] + " " + parts[1];
                int age = year - Integer.parseInt(parts[2]);
                String nameAge = name + " " + age;
                outputList.add(nameAge);
            }
            outputList.stream()
                    .sorted()
                    .forEach(System.out::println);
        }
    }
}
