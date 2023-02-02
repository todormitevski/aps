//package ispitni.pharmacy;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
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
//
//class Drug{
//    String name;
//    int positive;
//    int price;
//    int amount;
//
//    public Drug(String name, int positive, int price, int amount) {
//        this.name = name;
//        this.positive = positive;
//        this.price = price;
//        this.amount = amount;
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
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount -= amount;
//    }
//
//    public boolean checkAmount(int amount) {
//        if(amount > this.amount){
//            return false;
//        } else{
//            return true;
//        }
//    }
//
//    @Override
//    public String toString() {
//        String positiveOrNegative = "";
//        if(positive == 1){
//            positiveOrNegative = "POZ";
//        } else{
//            positiveOrNegative = "NEG";
//        }
//        return String.format(
//                "%s\n%s\n%d\n%d",
//                name.toUpperCase(),positiveOrNegative,price,amount
//        );
//    }
//}
//
//public class Pharmacy{
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        CBHT<String,Drug> cbht = new CBHT<>(n*2);
//        for(int i=0;i<n;i++){
//            String line = br.readLine();
//            String[] parts = line.split(" ");
//
//            String name = parts[0];
//            int posNeg = Integer.parseInt(parts[1]);
//            int price = Integer.parseInt(parts[2]);
//            int amount = Integer.parseInt(parts[3]);
//
//            Drug drug = new Drug(name,posNeg,price,amount);
//            cbht.insert(name.toUpperCase(),drug);
//        }
//
//        while(true){
//            String name = br.readLine().toUpperCase();
//            if(name.equals("KRAJ")){
//                break;
//            }
//            //todo: make it so user can enter as little as 3
//            // letters of the name of the drug to start searching
//            // for it in the cbht
//            //name = name.substring(0,3);
//            //System.out.println(name);
//            int amount = Integer.parseInt(br.readLine());
//
//            if(cbht.search(name) != null){
//                Drug drug = cbht.search(name).element.value;
//                if(drug.checkAmount(amount)){
//                    System.out.println(drug);
//                    drug.setAmount(amount);
//                    System.out.println("Napravena naracka");
//                } else{
//                    System.out.println(drug);
//                    System.out.println("Nema dovolno lekovi");
//                }
//            } else{
//                System.out.println("Nema takov lek");
//            }
//        }
//    }
//}
