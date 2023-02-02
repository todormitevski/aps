//package ispitni.clients;
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
//class SLL<E> {
//    private SLLNode<E> first;
//
//    public SLL() {
//        this.first = null;
//    }
//
//    public void deleteList() {
//        first = null;
//    }
//
//    public int length() {
//        int ret;
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            ret = 1;
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret++;
//            }
//            return ret;
//        } else
//            return 0;
//
//    }
//
//    @Override
//    public String toString() {
//        String ret = new String();
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            ret += tmp;
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret += " " + tmp;
//            }
//        } else
//            ret = "Prazna lista!!!";
//        return ret;
//    }
//
//    public void insertFirst(E o) {
//        SLLNode<E> ins = new SLLNode<E>(o, first);
//        first = ins;
//    }
//
//    public void insertAfter(E o, SLLNode<E> node) {
//        if (node != null) {
//            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
//            node.succ = ins;
//        } else {
//            System.out.println("Dadenot jazol e null");
//        }
//    }
//
//    public void insertBefore(E o, SLLNode<E> before) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            if (first == before) {
//                this.insertFirst(o);
//                return;
//            }
//            while (tmp.succ != before)
//                tmp = tmp.succ;
//            if (tmp.succ == before) {
//                SLLNode<E> ins = new SLLNode<E>(o, before);
//                tmp.succ = ins;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//            }
//        } else {
//            System.out.println("Listata e prazna");
//        }
//    }
//
//    public void insertLast(E o) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while (tmp.succ != null)
//                tmp = tmp.succ;
//            SLLNode<E> ins = new SLLNode<E>(o, null);
//            tmp.succ = ins;
//        } else {
//            insertFirst(o);
//        }
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
//    public SLLNode<E> getFirst() {
//        return first;
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
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getLoyalty() {
//        return loyalty;
//    }
//
//    public void setLoyalty(int loyalty) {
//        this.loyalty = loyalty;
//    }
//
//    public int getAccounts() {
//        return accounts;
//    }
//
//    public void setAccounts(int accounts) {
//        this.accounts = accounts;
//    }
//
//    public int calcImportance(){
//        return loyalty * 10 + accounts * 20;
//    }
//
//    @Override
//    public String toString() {
//        return String.valueOf(id);
//    }
//}
//
//public class Clients{
//
//    public static void bank(SLL<Client> normal, SLL<Client> golden) {
//        SLLNode<Client> tmpGolden = golden.getFirst();
//        SLLNode<Client> leastImportant = golden.getFirst();
//
//        while(tmpGolden != null){
//            if(tmpGolden.element.calcImportance() < leastImportant.element.calcImportance()){
//                leastImportant = tmpGolden;
//            }
//            tmpGolden = tmpGolden.succ;
//        }
//
//        //delete from golden, place at the end of normal
//        golden.delete(leastImportant);
//        normal.insertLast(leastImportant.element);
//
//        SLLNode<Client> tmpNormal = normal.getFirst();
//        SLLNode<Client> mostImportant = normal.getFirst();
//
//        while(tmpNormal != null){
//            if(tmpNormal.element.calcImportance() > mostImportant.element.calcImportance()){
//                mostImportant = tmpNormal;
//            }
//            tmpNormal = tmpNormal.succ;
//        }
//
//        //delete from normal, place at the end of golden
//        normal.delete(mostImportant);
//        golden.insertLast(mostImportant.element);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int m = Integer.parseInt(br.readLine());
//
//        SLL<Client> normal = new SLL<Client>();
//        SLL<Client> golden = new SLL<Client>();
//
//        for(int i=0;i<n;i++){
//            String line = br.readLine();
//            String[] parts = line.split(" ");
//            Client c = new Client(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
//            normal.insertLast(c);
//        }
//        for(int i=0;i<m;i++){
//            String line = br.readLine();
//            String[] parts = line.split(" ");
//            Client c = new Client(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
//            golden.insertLast(c);
//        }
//
//        bank(normal,golden);
//        System.out.println(normal);
//        System.out.println(golden);
//    }
//}
