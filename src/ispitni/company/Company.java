//package ispitni.company;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//import java.util.stream.Collectors;
//
//class SLLNode {
//    protected int id;
//    protected int plata;
//    protected SLLNode succ;
//
//    public SLLNode(int id,int plata, SLLNode succ) {
//        this.id = id;
//        this.plata=plata;
//        this.succ = succ;
//    }
//
//    public int getId() {
//        return id;
//    }
//}
//
//class SLL {
//    private SLLNode first;
//
//    public SLL() {
//        // Construct an empty SLL
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
//            SLLNode tmp = first;
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
//
//    public void insertFirst(int id, int plata) {
//        SLLNode ins = new SLLNode(id,plata, first);
//        first = ins;
//    }
//
//    public void insertLast(int id,int plata) {
//        if (first != null) {
//            SLLNode tmp = first;
//            while (tmp.succ != null)
//                tmp = tmp.succ;
//            SLLNode ins = new SLLNode(id, plata, null);
//            tmp.succ = ins;
//        } else {
//            insertFirst(id,plata);
//        }
//    }
//
//    public SLLNode getFirst() {
//        return first;
//    }
//
//    public SLL brisi_pomali_od(int iznos) {
//        // Vasiot kod tuka
//        SLL newSLL = new SLL();
//        if(first != null){
//            SLLNode tmp = first;
//            while(tmp != null){
//                if(tmp.plata >= iznos){
//                    newSLL.insertLast(tmp.id,tmp.plata);
//                }
//                tmp = tmp.succ;
//            }
//        } else{
//            System.out.println("Empty list!");
//        }
//        return newSLL;
//    }
//
//    public SLL sortiraj_opagacki() {
//        // Vasiot kod tuka
//        //my way
////        Set<SLLNode> sortedTreeSet = new TreeSet<>(Comparator.comparing(SLLNode::getId).reversed());
////        if(first != null){
////            SLLNode tmp = first;
////            while(tmp != null){
////                sortedTreeSet.add(tmp);
////                tmp = tmp.succ;
////            }
////        } else{
////            System.out.println("Empty list!");
////        }
////        SLL newSLL = new SLL();
////        for (SLLNode sllNode : sortedTreeSet) {
////            int id = sllNode.id;
////            int wage = sllNode.plata;
////            newSLL.insertLast(id, wage);
////        }
////        return newSLL;
//
//        //right way
////        if(first != null){
////            SLLNode curr = null,
////                    new_head = null,
////                    move_node = null,
////                    prev = null;
////            while(first != null){
////                prev = null;
////                curr = first;
////                move_node = first;
////                while(curr != null){
////                    if(curr.succ != null && curr.succ.id > move_node.id){
////                        move_node = curr.succ;
////                        prev = curr;
////                    }
////                    curr = curr.succ;
////                }
////                if(move_node == first){
////                    first = (first).succ;
////                }
////                if(prev != null){
////                    prev.succ = move_node.succ;
////                }
////                move_node.succ = new_head;
////                new_head = move_node;
////            }
////            first = new_head;
////        } else{
////            System.out.println("Empty list!");
////        }
//
//        //slave way
//        SLLNode curr1 = getFirst(),curr2;
//        int tmpId,tmpWage;
//
//        if(first != null){
//            while(curr1 != null){
//                curr2 = curr1.succ;
//                while(curr2 != null){
//                    if(curr1.id < curr2.id){
//                        tmpId = curr1.id;
//                        curr1.id = curr2.id;
//                        curr2.id = tmpId;
//
//                        tmpWage = curr1.plata;
//                        curr1.plata = curr2.plata;
//                        curr2.plata = tmpWage;
//                    }
//                    curr2 = curr2.succ;
//                }
//                curr1 = curr1.succ;
//            }
//        } else{
//            System.out.println("Empty list!");
//        }
//        return this;
//    }
//
//    public void pecati (SLL lista)
//    {
//        SLLNode p=lista.first;
//        while(p!=null)
//        {
//            System.out.println(p.id+","+p.plata);
//            p=p.succ;
//        }
//    }
//
//}
//public class Company {
//    public static void main(String[] args) throws IOException {
//
//        SLL lista1 = new SLL();
//        BufferedReader stdin = new BufferedReader(new InputStreamReader(
//                System.in));
//        String s = stdin.readLine();
//        int N = Integer.parseInt(s);
//
//        for (int i = 0; i < N; i++) {
//            s=stdin.readLine();
//            String s1=stdin.readLine();
//            lista1.insertLast(Integer.parseInt(s),Integer.parseInt(s1));
//        }
//        s = stdin.readLine();
//
//        lista1=lista1.brisi_pomali_od(Integer.parseInt(s));
//        if(lista1!=null)
//        {
//            lista1=lista1.sortiraj_opagacki();
//            lista1.pecati(lista1);
//        }
//
//    }
//}