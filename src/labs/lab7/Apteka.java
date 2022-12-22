//package labs.lab7;
//
//import javax.swing.*;
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
//    int positive;
//    int price;
//    int brDrugs;
//
//    public Drug(String name, int positive, int price, int brDrugs) {
//        this.name = name;
//        this.positive = positive;
//        this.price = price;
//        this.brDrugs = brDrugs;
//    }
//
//    public void setBrDrugs(int brDrugs) {
//        this.brDrugs = brDrugs;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getPositive() {
//        return positive;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public int getBrDrugs() {
//        return brDrugs;
//    }
//
//    @Override
//    public String toString() {
//        String positiveOrNegative = "";
//        if(positive == 1){
//            positiveOrNegative = "POZ";
//        } else positiveOrNegative = "NEG";
//
//        return String.format("%s\n%s\n%d\n%d",
//                name,positiveOrNegative,price,brDrugs);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Drug drug = (Drug) o;
//        return positive == drug.positive && price == drug.price && brDrugs == drug.brDrugs && Objects.equals(name, drug.name);
//    }
//
//    @Override
//    public int hashCode() {
//        //h(w)=(29∗(29∗(29∗0+ASCII(c1))+ASCII(c2))+ASCII(c3))%102780
//        // каде зборот w=c1c2c3c4c5…. е составен од сите големи букви
//        return (29 * (29 * (29 * 0 + name.charAt(0)) + name.charAt(1)) % 102780 + name.charAt(2));
//    }
//}
//
//class Pharmacy{
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        CBHT<String, List<Drug>> table = new CBHT<>(2*n);
//
//        for(int i=0;i<n;i++){
//            String line = br.readLine();
//            String[] splitLine = line.split("\\s+");
//            Drug drug = new Drug(splitLine[0].toUpperCase(), Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]));
//
//            if(table.search(splitLine[0].substring(0,3)) == null){
//                List<Drug> drugs = new ArrayList<>();
//                drugs.add(drug);
//                table.insert(splitLine[0].substring(0,3).toUpperCase(),drugs);
//            } else{
//                List<Drug> drugs = table.search(splitLine[0].substring(0,3)).element.value;
//                drugs.add(drug);
//                table.insert(splitLine[0].substring(0,3).toUpperCase(),drugs);
//            }
//        }
//
//        while(true){
//            String line = br.readLine();
//            if(line.equals("KRAJ")) break;
//            String drug = line.toUpperCase();
//            if(table.search(drug.substring(0,3)) == null){
//                System.out.println("Nema takov lek");
//                br.readLine();
//                continue;
//            }
//
//            boolean found = false;
//            for(Drug drug1: table.search(drug.substring(0,3)).element.value){
//                if(drug1.getName().equals(drug)){
//                    found = true;
//                    int num = Integer.parseInt(br.readLine());
//                    System.out.println(drug1);
//                    if(drug1.getBrDrugs()<num){
//                        System.out.println("Nema dovolno lekovi");
//                        continue;
//                    }
//                    drug1.setBrDrugs(drug1.getBrDrugs() - num);
//                    System.out.println("Napravena naracka");
//                    break;
//                }
//            }
//            if(!found){
//                br.readLine();
//                System.out.println("Nema takov lek");
//            }
//        }
//    }
//}
