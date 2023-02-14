//package ispitni.lists_easy;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//class SLL<E> {
//    public SLLNode<E> first;
//
//    public SLL() {
//        first = null;
//    }
//
//    public void insertFirst(E element) {
//        SLLNode<E> nov = new SLLNode<>(element, first);
//        first = nov;
//    }
//
//    public void insertLast(E element) {
//        if (first == null) insertFirst(element);
//        else {
//            SLLNode<E> dvizi = first;
//            while (dvizi.succ != null) {
//                dvizi = dvizi.succ;
//            }
//            SLLNode<E> last = new SLLNode<>(element, null);
//            dvizi.succ = last;
//        }
//    }
//
//    public void insertAfter(E element, SLLNode<E> node) {
//        if (node != null) {
//            SLLNode<E> nov = new SLLNode<>(element, node.succ);
//            node.succ = nov;
//        }
//    }
//
//    public int getLength() {
//        SLLNode<E> dvizi = first;
//        int length = 0;
//        while (dvizi != null) {
//            length++;
//            dvizi = dvizi.succ;
//        }
//        return length;
//    }
//
//
//    public String toString() {
//        String s = new String();
//        SLLNode<E> dvizi = first;
//        while (dvizi != null) {
//            s = s + dvizi.element + " ";
//            dvizi = dvizi.succ;
//        }
//        return s;
//    }
//
//    public E deleteFirst() {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            first = first.succ;
//            return tmp.element;
//        } else {
//            System.out.println("Listata e prazna");
//            return null;
//        }
//    }
//
//    public E delete(SLLNode<E> node) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            if (first == node) {
//                return this.deleteFirst();
//            }
//            while (tmp.succ != node && tmp.succ.succ != null)
//                tmp = tmp.succ;
//            if (tmp.succ == node) {
//                tmp.succ = tmp.succ.succ;
//                return node.element;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//                return null;
//            }
//        } else {
//            System.out.println("Listata e prazna");
//            return null;
//        }
//    }
//
//    public SLLNode<E> find(E o) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while (tmp.element != o && tmp.succ != null)
//                tmp = tmp.succ;
//            if (tmp.element == o) {
//                return tmp;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//            }
//        } else {
//            System.out.println("Listata e prazna");
//        }
//        return first;
//    }
//
//    public SLLNode<E> getFirst() {
//        return first;
//    }
//
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
//class Discussion{
//    int id;
//    int users;
//    int popularity;
//
//    public Discussion(int id, int users, int popularity) {
//        this.id = id;
//        this.users = users;
//        this.popularity = popularity;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public int getUsers() {
//        return users;
//    }
//
//    public int getPopularity() {
//        return popularity;
//    }
//
//    public int calcPopularity(){
//        return users * popularity;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%d",id);
//    }
//}
//
////highest popularity from health to be added to end of finance
////remove the lowest popularity from finance
//
//public class FinanceHealth {
//    public static void rearrangeLists(SLL<Discussion> health, SLL<Discussion> finance) {
//        SLLNode<Discussion> tmpHealth = health.getFirst();
//        SLLNode<Discussion> tmpFinance = finance.getFirst();
//        SLLNode<Discussion> mostPopularHealth = health.getFirst();
//        SLLNode<Discussion> leastPopularFinance = finance.getFirst();
//        while(tmpHealth != null){
//            if(tmpHealth.element.calcPopularity() > mostPopularHealth.element.calcPopularity()){
//                mostPopularHealth = tmpHealth;
//            }
//            tmpHealth = tmpHealth.succ;
//        }
//        finance.insertLast(mostPopularHealth.element);
//        while(tmpFinance != null){
//            if(tmpFinance.element.calcPopularity() < leastPopularFinance.element.calcPopularity()){
//                leastPopularFinance = tmpFinance;
//            }
//            tmpFinance = tmpFinance.succ;
//        }
//        finance.delete(leastPopularFinance);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int m = Integer.parseInt(br.readLine());
//        SLL<Discussion> health = new SLL<Discussion>();
//        SLL<Discussion> finance = new SLL<Discussion>();
//        br.lines()
//                .limit(n)
//                .forEach(line ->{
//                    String[] parts = line.split("\\s+");
//                    Discussion discussion = new Discussion(
//                            Integer.parseInt(parts[0]),
//                            Integer.parseInt(parts[1]),
//                            Integer.parseInt(parts[2])
//                    );
//                    health.insertLast(discussion);
//                });
//        br.lines()
//                .limit(m)
//                .forEach(line ->{
//                    String[] parts = line.split("\\s+");
//                    Discussion discussion = new Discussion(
//                            Integer.parseInt(parts[0]),
//                            Integer.parseInt(parts[1]),
//                            Integer.parseInt(parts[2])
//                    );
//                    finance.insertLast(discussion);
//                });
//        rearrangeLists(health,finance);
//        System.out.println(health);
//        System.out.println(finance);
//    }
//}
