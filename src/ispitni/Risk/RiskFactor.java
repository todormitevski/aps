//package ispitni.Risk;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Scanner;
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
//class MapEntry<K extends Comparable<K>, E> implements Comparable<K> {
//    K key;
//    E value;
//
//    public MapEntry(K key, E val) {
//        this.key = key;
//        this.value = val;
//    }
//
//    @Override
//    public int compareTo(K that) {
//        @SuppressWarnings("unchecked")
//        MapEntry<K, E> other = (MapEntry<K, E>) that;
//        return this.key.compareTo(other.key);
//    }
//
//    @Override
//    public String toString() {
//        return "<" + key + "," + value + ">";
//    }
//}
//
//class CBHT<K extends Comparable<K>, E> {
//
//    // An object of class CBHT is a closed-bucket hash table, containing
//    // entries of class MapEntry.
//    private SLLNode<MapEntry<K, E>>[] buckets;
//
//    @SuppressWarnings("unchecked")
//    public CBHT(int m) {
//        // Construct an empty CBHT with m buckets.
//        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
//    }
//
//    private int hash(K key) {
//        // Translate key to an index of the array buckets.
//        return Math.abs(key.hashCode()) % buckets.length;
//    }
//
//    public SLLNode<MapEntry<K, E>> search(K targetKey) {
//        // Find which if any node of this CBHT contains an entry whose key is
//        // equal
//        // to targetKey. Return a link to that node (or null if there is none).
//        int b = hash(targetKey);
//        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
//            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
//                return curr;
//        }
//        return null;
//    }
//
//    public void insert(K key, E val) {    // Insert the entry <key, val> into this CBHT.
//        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
//        int b = hash(key);
//        //for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
//        //if (key.equals(((MapEntry<K, E>) curr.element).key)) {
//        // Make newEntry replace the existing entry ...
//        //curr.element = newEntry;
//        // return;
//        // }
//        //}
//        // Insert newEntry at the front of the 1WLL in bucket b ...
//        buckets[b] = new SLLNode<MapEntry<K, E>>(newEntry, buckets[b]);
//    }
//
//    public void delete(K key) {
//        // Delete the entry (if any) whose key is equal to key from this CBHT.
//        int b = hash(key);
//        for (SLLNode<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
//            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
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
//            for (SLLNode<MapEntry<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
//                temp += curr.element.toString() + " ";
//            }
//            temp += "\n";
//        }
//        return temp;
//    }
//}
//
//public class RiskFactor {
//    public static void calculateRisk(String municipality, CBHT<String, Integer> numOfPositiveByMunicipality, CBHT<String, Integer> numOfNegativeByMunicipality) {
//        //risk = brPoz / (brNeg + brPoz)
//        int numPositive = numOfPositiveByMunicipality.search(municipality).element.value;
//        int numNegative = numOfNegativeByMunicipality.search(municipality).element.value;
//        System.out.printf("%.2f", (double) numPositive / (numPositive + numNegative));
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        CBHT<String, Integer> numOfPositiveByMunicipality = new CBHT<>(n * 2);
//        CBHT<String, Integer> numOfNegativeByMunicipality = new CBHT<>(n * 2);
//        br.lines()
//                .limit(n)
//                .forEach(line -> {
//                    String[] parts = line.split("\\s+");
//                    String municipality = parts[0];
//                    String posNeg = parts[2];
//
//                    if (posNeg.equals("позитивен")) {
//                        if (numOfPositiveByMunicipality.search(municipality) == null) {
//                            numOfPositiveByMunicipality.insert(municipality, 1);
//                        } else {
//                            numOfPositiveByMunicipality.insert(
//                                    municipality,
//                                    numOfPositiveByMunicipality.search(municipality).element.value + 1
//                            );
//                        }
//                    } else {
//                        if (numOfNegativeByMunicipality.search(municipality) == null) {
//                            numOfNegativeByMunicipality.insert(municipality, 1);
//                        } else {
//                            numOfNegativeByMunicipality.insert(
//                                    municipality,
//                                    numOfNegativeByMunicipality.search(municipality).element.value + 1
//                            );
//                        }
//                    }
//                });
//        String municipalityToSearch = br.readLine();
//        calculateRisk(municipalityToSearch,numOfPositiveByMunicipality,numOfNegativeByMunicipality);
//    }
//}