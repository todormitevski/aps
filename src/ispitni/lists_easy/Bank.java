//package ispitni.lists_easy;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Scanner;
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
//class Client{
//    int id;
//    int loyalty;
//    int accounts;
//
//    public Client(int id, int loyalty, int accounts) {
//        this.id = id;
//        this.loyalty = loyalty;
//        this.accounts = accounts;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public int getLoyalty() {
//        return loyalty;
//    }
//
//    public int getAccounts() {
//        return accounts;
//    }
//
//    public int calcImportance(){
//        return loyalty * 10 + accounts * 20;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%d",id);
//    }
//}
//
////remove least important from golden and put at the end of normal
////remove most important from normal and put at the end of golden
//
//public class Bank {
//    public static void rearrangeByImportance(SLL<Client> normal, SLL<Client> golden) {
//        SLLNode<Client> normalTmp = normal.getFirst();
//        SLLNode<Client> goldenTmp = golden.getFirst();
//        SLLNode<Client> leastImportantGolden = golden.getFirst();
//        SLLNode<Client> mostImportantNormal = normal.getFirst();
//
//        while(goldenTmp != null){
//            if(goldenTmp.element.calcImportance() < leastImportantGolden.element.calcImportance()){
//                leastImportantGolden = goldenTmp;
//            }
//            goldenTmp = goldenTmp.succ;
//        }
//        golden.delete(leastImportantGolden);
//        normal.insertLast(leastImportantGolden.element);
//
//        while(normalTmp != null){
//            if(normalTmp.element.calcImportance() > mostImportantNormal.element.calcImportance()){
//                mostImportantNormal = normalTmp;
//            }
//            normalTmp = normalTmp.succ;
//        }
//        normal.delete(mostImportantNormal);
//        golden.insertLast(mostImportantNormal.element);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int m = Integer.parseInt(br.readLine());
//        SLL<Client> normalList = new SLL<Client>();
//        SLL<Client> goldenList = new SLL<Client>();
//        br.lines()
//                .limit(n)
//                .forEach(line ->{
//                    String[] parts = line.split("\\s+");
//                    Client client = new Client(
//                            Integer.parseInt(parts[0]),
//                            Integer.parseInt(parts[1]),
//                            Integer.parseInt(parts[2])
//                    );
//                    normalList.insertLast(client);
//                });
//        br.lines()
//                .limit(m)
//                .forEach(line ->{
//                    String[] parts = line.split("\\s+");
//                    Client client = new Client(
//                            Integer.parseInt(parts[0]),
//                            Integer.parseInt(parts[1]),
//                            Integer.parseInt(parts[2])
//                    );
//                    goldenList.insertLast(client);
//                });
//        System.out.println("Lists before:");
//        System.out.println(normalList);
//        System.out.println(goldenList);
//        rearrangeByImportance(normalList,goldenList);
//        System.out.println("Lists after:");
//        System.out.println(normalList);
//        System.out.println(goldenList);
//    }
//}
