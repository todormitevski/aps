import java.util.ArrayList;
import java.util.List;

public class WorkingWithLists {
    public static void main(String[] args){
        List<String> colors=new ArrayList<>();
        colors.add("blue");
        colors.add("purple");
        colors.add("yellow");
//        colors.add(1);
//        colors.add(new Object());
        System.out.println(colors);
        System.out.println(colors.size()); //golemina
        System.out.println(colors.contains("yellow")); //if it contains the elem
        System.out.println(colors.contains("pink")); //if it contains the elem

        for(String color:colors){
            System.out.println(color);
        }

        //other ways to print
//        colors.forEach(System.out::println);
//
//        for(int i=0;i<colors.size(); i++){
//            System.out.println(colors.get(i));
//        }
    }
}
