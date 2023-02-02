//package ispitni.birthdays;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Birthdays {
//
//    //input
////    3
////    Magdalena Kostoska 15/05/1982
////    Hristina Mihajloska 30/05/1984
////    Ilinka Ivanoska 15/05/1986
////    15/05/2016
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        HashMap<String,String> hashMap = new HashMap<>();
//
//        for(int i=0;i<n;i++){
//            String line = br.readLine();
//            String[] parts = line.split(" ");
//            String[] date = parts[2].split("/");
//            String person = parts[0] + " " + parts[1] + " " + date[2];
//            String dayMonth = date[0] + date[1];
//
//            if(hashMap.get(dayMonth) == null){
//                hashMap.put(dayMonth,person);
//            } else{
//                String value = hashMap.get(dayMonth);
//                String result = value + "/" + person;
//                hashMap.put(dayMonth,result);
//            }
//        }
//
//        String[] lastInputDate = br.readLine().split("/");
//        String dayMonth = lastInputDate[0] + lastInputDate[1];
//        String year = lastInputDate[2];
//
//        //System.out.println(hashMap.get(dayMonth));
//        String[] people = hashMap.get(dayMonth).split("/");
//        for(String person : people){
//            //Ime Prezime 1987
//            String[] parts = person.split(" ");
//
//            String name = parts[0] + " " + parts[1] + " ";
//
//            int personYear = Integer.parseInt(parts[2]);
//            String age = String.valueOf(year - personYear);
//            String newPerson = name + age;
//
//            resultPeople.add(newPerson);
//        }
//        //...not finished
//    }
//}
