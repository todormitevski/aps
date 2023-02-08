//package ispitni.pharmacy;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//class CBHT<K extends Comparable<K>, E> {
//
//    // An object of class CBHT is a closed-bucket hash table, containing
//    // entries of class MapEntry.
//    private SLLNode<MapEntry<K,E>>[] buckets;
//
//    @SuppressWarnings("unchecked")
//    public CBHT(int m) {
//        // Construct an empty CBHT with m buckets.
//        buckets = (SLLNode<MapEntry<K,E>>[]) new SLLNode[m];
//    }
//
//    private int hash(K key) {
//        // Translate key to an index of the array buckets.
//        return Math.abs(key.hashCode()) % buckets.length;
//    }
//
//    public SLLNode<MapEntry<K,E>> search(K targetKey) {
//        // Find which if any node of this CBHT contains an entry whose key is
//        // equal
//        // to targetKey. Return a link to that node (or null if there is none).
//        int b = hash(targetKey);
//        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
//            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
//                return curr;
//        }
//        return null;
//    }
//
//    public void insert(K key, E val) {		// Insert the entry <key, val> into this CBHT.
//        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
//        int b = hash(key);
//        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
//            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
//                // Make newEntry replace the existing entry ...
//                curr.element = newEntry;
//                return;
//            }
//        }
//        // Insert newEntry at the front of the 1WLL in bucket b ...
//        buckets[b] = new SLLNode<MapEntry<K,E>>(newEntry, buckets[b]);
//    }
//
//    public void delete(K key) {
//        // Delete the entry (if any) whose key is equal to key from this CBHT.
//        int b = hash(key);
//        for (SLLNode<MapEntry<K,E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
//            if (key.equals(((MapEntry<K,E>) curr.element).key)) {
//                if (pred == null)
//                    buckets[b] = curr.succ;
//                else
//                    pred.succ = curr.succ;
//                return;
//            }
//        }
//    }
//
//    public String toString() {
//        String temp = "";
//        for (int i = 0; i < buckets.length; i++) {
//            temp += i + ":";
//            for (SLLNode<MapEntry<K,E>> curr = buckets[i]; curr != null; curr = curr.succ) {
//                temp += curr.element.toString() + " ";
//            }
//            temp += "\n";
//        }
//        return temp;
//    }
//
//}
//class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {
//
//    // Each MapEntry object is a pair consisting of a key (a Comparable
//    // object) and a value (an arbitrary object).
//    K key;
//    E value;
//
//    public MapEntry (K key, E val) {
//        this.key = key;
//        this.value = val;
//    }
//
//    public int compareTo (K that) {
//        // Compare this map entry to that map entry.
//        @SuppressWarnings("unchecked")
//        MapEntry<K,E> other = (MapEntry<K,E>) that;
//        return this.key.compareTo(other.key);
//    }
//
//    public String toString () {
//        return "<" + key + "," + value + ">";
//    }
//}
//class SLLNode<E> {
//    protected E element;
//    protected SLLNode<E> succ;
//
//    public SLLNode(E elem, SLLNode<E> succ) {
//        this.element = elem;
//        this.succ = succ;
//    }
//
//    @Override
//    public String toString() {
//        return element.toString();
//    }
//}
//
//class Drug{
//    String name;
//    int type;
//    int price;
//    int amount;
//
//    public Drug(String name, int type, int price, int amount) {
//        this.name = name;
//        this.type = type;
//        this.price = price;
//        this.amount = amount;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getType() {
//        return type;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        if(amount < this.amount){
//            this.amount -= amount;
//            System.out.println("Napravena naracka");
//        }
//        else System.out.println("Nema dovolno lekovi");
//    }
//
//    @Override
//    public String toString() {
//        String posNeg = "";
//        if(type == 1)
//            posNeg = "POZ";
//        else posNeg = "NEG";
//        return String.format(
//                "%s\n%s\n%d\n%d",
//                name,posNeg,price,amount
//        );
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Drug drug = (Drug) o;
//        return type == drug.type && price == drug.price && amount == drug.amount && Objects.equals(name, drug.name);
//    }
//
//    @Override
//    public int hashCode() {
//        //h(w)=(29∗(29∗(29∗0+ASCII(c1))+ASCII(c2))+ASCII(c3))%102780
//        return (29 * (29 * (29 * 0 + name.charAt(0)) + name.charAt(1)) + name.charAt(2)) % 102780;
//    }
//}
//
//public class Pharmacy1{
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        CBHT<String, List<Drug>> drugTable = new CBHT<String,List<Drug>>(n * 2);
//        br.lines()
//                .limit(n)
//                .forEach(line ->{
//                    String[] parts = line.split("\\s+");
//                    String name = parts[0].toUpperCase();
//                    String initials = name.substring(0,3);
//                    int type = Integer.parseInt(parts[1]);
//                    int price = Integer.parseInt(parts[2]);
//                    int amount = Integer.parseInt(parts[3]);
//                    Drug drug = new Drug(name,type,price,amount);
//                    List<Drug> drugList = new ArrayList<>();
//                    if(drugTable.search(name) == null){
//                        drugList.add(drug);
//                        drugTable.insert(initials,drugList);
//                    } else{
//                        List<Drug> gottenDrugList = drugTable.search(initials).element.value;
//                        gottenDrugList.add(drug);
//                        drugTable.insert(initials,gottenDrugList);
//                    }
//                });
//        while(true){
//            String name = br.readLine().toUpperCase();
//            if(name.equals("KRAJ")){
//                br.close();
//                break;
//            }
//            String initials = name.substring(0,3);
//            int amount = Integer.parseInt(br.readLine());
//            if(drugTable.search(initials) != null){
//                List<Drug> drugs = drugTable.search(initials).element.value;
//                int flag = 0;
//                for(Drug drug : drugs){
//                    if(drug.name.equals(name)){
//                        System.out.println(drug);
//                        drug.setAmount(amount);
//                        flag = 1;
//                    }
//                }
//                if(flag == 0){
//                    System.out.println("Nema takov lek");
//                }
//            } else{
//                System.out.println("Nema takov lek");
//            }
//        }
//    }
//}