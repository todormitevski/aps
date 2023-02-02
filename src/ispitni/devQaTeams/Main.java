//package ispitni.devQaTeams;
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
//class Worker{
//    int id;
//    int age;
//
//    public Worker(int id, int age) {
//        this.id = id;
//        this.age = age;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%d ",id);
//    }
//}
//
//public class Main {
//
//    //inputs
////            2
////            3
////            16100 20
////            17200 30
////            19898 20
////            14203 35
////            18100 19
//
////            3
////            3
////            16100 20
////            17200 30
////            18112 45
////            14102 19
////            19203 35
////            18900 20
//
//    public static void bank(SLL<Worker> devTeam, SLL<Worker> qaTeam) {
//        SLLNode<Worker> tmp = qaTeam.getFirst();
//        SLLNode<Worker> toDelete = tmp;
//
//        //find youngest from qas & delete
//        int min = tmp.element.getAge();
//        while(tmp != null){
//            if(tmp.element.getAge() < min){
//                min = tmp.element.getAge();
//                toDelete = tmp;
//            }
//            tmp = tmp.succ;
//        }
//
//        qaTeam.delete(toDelete);
//
//        //insert to center of devs
//        int center = devTeam.length() / 2;
//        tmp = devTeam.getFirst();
//        for(int i=0;i<center;i++){
//            tmp = tmp.succ;
//        }
//
//        if(devTeam.length() % 2 != 0){
//            devTeam.insertAfter(toDelete.element,tmp);
//        } else{
//            devTeam.insertBefore(toDelete.element,tmp);
//        }
//
//        System.out.println(qaTeam);
//        System.out.println(devTeam);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int m = Integer.parseInt(br.readLine());
//
//        SLL<Worker> devTeam = new SLL<Worker>();
//        SLL<Worker> qaTeam = new SLL<Worker>();
//
//        for(int i=0;i<n;i++){
//            String line = br.readLine();
//            String[] parts = line.split(" ");
//            Worker w = new Worker(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
//            devTeam.insertFirst(w);
//        }
//        for(int i=0;i<m;i++){
//            String line = br.readLine();
//            String[] parts = line.split(" ");
//            Worker w = new Worker(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
//            qaTeam.insertFirst(w);
//        }
//
//        bank(qaTeam,devTeam);
//    }
//}
