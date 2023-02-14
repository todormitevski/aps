package ispitni.pharmacy;

import ispitni.finkiHashingCodes.OBHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Drug{
    String name;
    int polarity;
    int price;
    int amount;

    public Drug(String name, int polarity, int price, int amount) {
        this.name = name;
        this.polarity = polarity;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getPolarity() {
        return polarity;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public boolean setAmount(int amount){
        if(amount <= this.amount){
            this.amount -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String polarity = (getPolarity() == 0) ? "NEG" : "POZ";
        return String.format("%s\n%s\n%d\n%d",name,polarity,price,amount);
    }
}

public class Pharmacy2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        OBHT<String, List<Drug>> drugs = new OBHT<>(n * 2);
        br.lines()
                .limit(n)
                .forEach(line ->{
                    String [] parts = line.split("\\s+");
                    String name = parts[0].toUpperCase();
                    int polarity = Integer.parseInt(parts[1]);
                    int price = Integer.parseInt(parts[2]);
                    int amount = Integer.parseInt(parts[3]);
                    Drug drug = new Drug(name,polarity,price,amount);
                    String initials = name.substring(0,3);
                    if(drugs.search(initials) == -1){
                        List<Drug> list = new ArrayList<Drug>();
                        list.add(drug);
                        drugs.insert(initials,list);
                    } else{
                        int index = drugs.search(initials);
                        List<Drug> gottenList = drugs.buckets[index].value;
                        gottenList.add(drug);
                        drugs.insert(initials,gottenList);
                    }
                });
        while(true){
            String name = br.readLine().toUpperCase();
            if(name.equals("KRAJ")){
                break;
            }
            String initials = name.substring(0,3);
            int amount = Integer.parseInt(br.readLine());
            boolean flag = false;
            if(drugs.search(initials) != -1){
                int index = drugs.search(initials);
                List<Drug> drugList = drugs.buckets[index].value;
                for(Drug drug : drugList){
                    if(drug.getName().equals(name)){
                        System.out.println(drug);

                        if(drug.setAmount(amount))
                            System.out.println("Napravena naracka");
                        else System.out.println("Nema dovolno lekovi");
                        flag = true;
                    }
                }
                if (!flag)
                    System.out.println("Nema takov lek");
            } else{
                System.out.println("Nema takov lek");
            }
        }
    }
}
