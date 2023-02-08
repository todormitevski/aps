//package ispitni.santa;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {
//
//    K key;
//    E value;
//
//    public MapEntry (K key, E val) {
//        this.key = key;
//        this.value = val;
//    }
//
//    public int compareTo (K that) {
//        @SuppressWarnings("unchecked")
//        MapEntry<K,E> other = (MapEntry<K,E>) that;
//        return this.key.compareTo(other.key);
//    }
//
//    public String toString () {
//        return "(" + key + "," + value + ")";
//    }
//}
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
//class CBHT<K extends Comparable<K>, E> {
//
//    private SLLNode<MapEntry<K,E>>[] buckets;
//
//    @SuppressWarnings("unchecked")
//    public CBHT(int m) {
//        buckets = (SLLNode<MapEntry<K,E>>[]) new SLLNode[m];
//    }
//
//    private int hash(K key) {
//        return Math.abs(key.hashCode()) % buckets.length;
//    }
//
//    public SLLNode<MapEntry<K,E>> search(K targetKey) {
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
//                curr.element = newEntry;
//                return;
//            }
//        }
//        buckets[b] = new SLLNode<MapEntry<K,E>>(newEntry, buckets[b]);
//    }
//
//    public void delete(K key) {
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
//public class ClausSmiriSe {
//    public static void main (String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        CBHT<String,String> tableChildren = new CBHT<String,String>(n * 2);
//        CBHT<String,String> newAddresses = new CBHT<String,String>(n * 2);
//        for(int i=0;i<n;i++){
//            String name = br.readLine();
//            String address = br.readLine();
//            tableChildren.insert(name,address);
//        }
//        int m = Integer.parseInt(br.readLine());
//        br.lines()
//                .limit(m)
//                .forEach(line -> {
//                    String[] parts = line.split("\\s+");
//                    String addressToSearch = parts[0];
//                    String addressToReplaceWith = parts[1];
//                    newAddresses.insert(addressToSearch,addressToReplaceWith);
//                });
//        String childToSearch = br.readLine();
//        if(tableChildren.search(childToSearch) != null){
//            String addressToPrint = tableChildren.search(childToSearch).element.value;
//            String[] parts = addressToPrint.split("\\s+");
//            parts[0] = newAddresses.search(parts[0]).element.value;
//            StringBuilder newString = new StringBuilder();
//            for(String part : parts){
//                newString.append(part).append(" ");
//            }
//            tableChildren.insert(childToSearch,newString.substring(0,newString.length()-1));
//            System.out.println(tableChildren.search(childToSearch).element.value);
//        } else{
//            System.out.println("Child doesn't exist!");
//        }
//        br.close();
//    }
//}