//package ispitni.birthdays;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
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
//public class Birthdays{
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        CBHT<String,String> cbht = new CBHT<>(n*2);
//
//        for(int i=0;i<n;i++){
//            String line = br.readLine();
//            String[] parts = line.split(" ");
//
//            String name = parts[0] + " " + parts[1];
//
//            String date = parts[2];
//            String[] dateParts = date.split("/");
//            String dayMonth = dateParts[0] + "/" + dateParts[1];
//            String year = dateParts[2];
//
//            String key = dayMonth;
//            String value = name + " " + year;
//
//            if(cbht.search(key) == null){
//                cbht.insert(key,value);
//            } else{
//                cbht.insert(key,cbht.search(key).element.value + "#" + value);
//            }
//        }
//        String birthday = br.readLine();
//
//        //System.out.println(cbht);
//        //System.out.println(birthday);
//
//        String[] birthdayParts = birthday.split("/");
//        String birthDayMonth = birthdayParts[0] + "/" + birthdayParts[1];
//        int birthYear = Integer.parseInt(birthdayParts[2]);
//
//        List<String> sortedBirthdays = new ArrayList<>();
//        if(cbht.search(birthDayMonth) != null){
//            String value = cbht.search(birthDayMonth).element.value;
//            String[] values = value.split("#");
//            for(String val : values){
//                String[] valParts = val.split(" ");
//                String name = valParts[0];
//                String surname = valParts[1];
//                int year = Integer.parseInt(valParts[2]);
//
//                int age = birthYear - year;
//                String personWithBirthday = name + " " + surname + " " + age;
//                sortedBirthdays.add(personWithBirthday);
//            }
//            sortedBirthdays.stream()
//                    .sorted()
//                    .forEach(System.out::println);
//        } else{
//            System.out.println("Nema");
//        }
//    }
//}
