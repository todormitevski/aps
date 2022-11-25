//package vezbiKolokv;
//
//import javax.print.attribute.standard.NumberOfDocuments;
//import java.util.Scanner;
//
//class Client {
//    private int id;
//    private int years;
//
//    public Client(int id, int years) {
//        this.id = id;
//        this.years = years;
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
//    public int getYears() {
//        return years;
//    }
//
//    public void setYears(int years) {
//        this.years = years;
//    }
//
//
//    @Override
//    public String toString() {
//        return String.valueOf(id);
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
//public class IOSolutions {
//
//    // todo: complete function
//    public static void bank(SLL<Client> devTeam, SLL<Client> qaTeam) {
//        /*
//        2 - num of devs  3 - num of qa  result:
//        16100 20                        16100 18100 17200
//        17200 30                        19898 14203
//        19898 20
//        14203 35
//        18100 19              move youngest qa into dev team
//         */
//
//        SLLNode<Client> devs = devTeam.getFirst();
//        SLLNode<Client> qas = qaTeam.getFirst();
//        Client youngest = null;
//        youngest = qas.element;
//
//        while(qas != null){
//            if(qas.element.getYears() < youngest.getYears()){
//                youngest = qas.element;
//            }
//            qas = qas.succ;
//        }
//
//        qaTeam.delete(qaTeam.find(youngest));
//
//        int numDevs = 0;
//        while(devs != null){
//            numDevs++;
//            devs = devs.succ;
//        }
//        int position = numDevs/2;
//
//        devs = devTeam.getFirst();
//        int br = 1;
//        while (devs != null){
//            if(numDevs % 2 == 0){
//                if(br == position){
//                    devTeam.insertAfter(youngest, devs);
//                }
//            } else{
//                if(br == position+1){
//                    devTeam.insertAfter(youngest, devs);
//                }
//            }
//            br++;
//            devs = devs.succ;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int numNormal = Integer.parseInt(scanner.nextLine());
//        int numGolden = Integer.parseInt(scanner.nextLine());
//
//        SLL<Client> normal = new SLL<Client>();
//        SLL<Client> golden = new SLL<Client>();
//
//        for (int i = 0; i < numNormal; i++) {
//            String line = scanner.nextLine();
//            String[] parts = line.split("\\s+");
//            normal.insertLast(new Client(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
//        }
//
//        for (int i = 0; i < numGolden; i++) {
//            String line = scanner.nextLine();
//            String[] parts = line.split("\\s+");
//            golden.insertLast(new Client(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
//        }
//
//        bank(normal, golden);
//        System.out.println(normal.toString());
//        System.out.println(golden.toString());
//    }
//}