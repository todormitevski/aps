//package ispitni.kmb;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Kmb {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        Map<String,String> routingTable = new HashMap<String,String>();
//        for(int i=0;i<n;i++){
//            String inputInterface = br.readLine();
//            String[] parts = br.readLine().split("\\s+");
//            StringBuilder values = new StringBuilder(parts[0]);
//            for(int j=1;j<parts.length;j++){
//                values.append(",").append(parts[j]);
//            }
//            routingTable.putIfAbsent(inputInterface, String.valueOf(values));
//        }
//        int m = Integer.parseInt(br.readLine());
//        for(int i=0;i<m;i++){
//            String key = br.readLine();
//            String value = br.readLine();
//            if(routingTable.containsKey(key)){
//                String tableValues = routingTable.get(key);
//                String[] tableValuesParts = tableValues.split(",");
//                int lastDot = value.lastIndexOf('.');
//                value = value.substring(0,lastDot-1);
//                int flag = 0;
//                for (String tableValuesPart : tableValuesParts) {
//                    if(value.equals(tableValuesPart.substring(0,lastDot-1))){
//                        System.out.println("postoi");
//                        flag = 1;
//                    }
//                }
//                if(flag == 0){
//                    System.out.println("ne postoi");
//                }
//            } else{
//                System.out.println("ne postoi");
//            }
//        }
//    }
//}
