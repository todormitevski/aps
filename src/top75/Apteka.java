//package top75;
//
//import javax.swing.*;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
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
//class Lek{
//    String ime;
//    int baranost;
//    int cena;
//    int brLekovi;
//
//    public Lek(int baranost, int cena, int brLekovi) {
//        this.baranost = baranost;
//        this.cena = cena;
//        this.brLekovi = brLekovi;
//    }
//
//    public void setBrLekovi(int brLekovi) {
//        this.brLekovi = brLekovi;
//    }
//
//    @Override
//    public String toString() {
//        String pozneg;
//        if(baranost == 1){
//            pozneg = "POZ";
//        } else pozneg = "NEG";
//
//        return String.format("%s\n%d\n%d",
//                pozneg, cena, brLekovi);
//    }
//
//    public void checkLek(int amount){
//        if(amount > this.brLekovi){
//            System.out.println("Nema dovolno lekovi");
//        } else{
//            setBrLekovi(brLekovi - amount); //ostanale tolku
//            System.out.println("Napravena naracka");
//        }
//    }
//}
//
//public class Apteka {
//    public static void main(String[] args) throws IOException {
//        // Scanner sc = new Scanner(System.in);
//        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(sc.readLine());
//        CBHT<String, Lek> map = new CBHT<>(n*2);
//
//        for(int i=0;i<n;i++){
//            String line = sc.readLine().toUpperCase();
//            String[] splitLine = line.split("\\s+");
//
//            Lek lek = new Lek(
//                    Integer.parseInt(splitLine[1]),
//                    Integer.parseInt(splitLine[2]),
//                    Integer.parseInt(splitLine[3])
//            );
//            map.insert(splitLine[0], lek);
//        }
//
//        while(true){
//            String line = sc.readLine().toUpperCase();
//            if(line.equals("KRAJ")) break;
//            int kolicina = Integer.parseInt(sc.readLine());
//
//            if(map.search(line) == null){
//                System.out.println("Nema takov lek");
//            } else{
//                System.out.println(line);
//                System.out.println(map.search(line).element.value.toString());
//                map.search(line).element.value.checkLek(kolicina);
//            }
//        }
//    }
//}
