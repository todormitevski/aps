//package vezbiKolokv;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//class SLLNode {
//    protected int id;
//    protected int plata;
//    protected SLLNode succ;
//
//    public SLLNode(int id, int plata, SLLNode succ) {
//        this.id = id;
//        this.plata = plata;
//        this.succ = succ;
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
//    public int length(){
//        int ret;
//        if(first != null){
//            SLLNode tmp = first;
//            ret = 1;
//            while(tmp.succ != null){
//                tmp = tmp.succ;
//                ret++;
//            }
//            return ret;
//        } else{
//            return 0;
//        }
//    }
//
//    public void insertFirst(int id, int plata) {
//        SLLNode ins = new SLLNode(id, plata, first);
//        first = ins;
//    }
//
//    public void insertLast(int id, int plata) {
//        if (first != null) {
//            SLLNode tmp = first;
//            while (tmp.succ != null)
//                tmp = tmp.succ;
//            SLLNode ins = new SLLNode(id, plata, null);
//            tmp.succ = ins;
//        } else {
//            insertFirst(id, plata);
//        }
//    }
//
//    public int size() {
//        int listSize = 0;
//        SLLNode tmp = first;
//        while (tmp != null) {
//            listSize++;
//            tmp = tmp.succ;
//        }
//        return listSize;
//    }
//
//    @Override
//    public String toString() {
//        String ret = new String();
//        if (first != null) {
//            SLLNode tmp = first;
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
//
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
//
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            if (first == before) {
//                this.insertFirst(o);
//                return;
//            }
//            //ako first!=before
//            while (tmp.succ != before && tmp.succ != null)
//                tmp = tmp.succ;
//            if (tmp.succ == before) {
//                tmp.succ = new SLLNode<E>(o, before);
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//            }
//        } else {
//            System.out.println("Listata e prazna");
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
////    public E delete(SLLNode<E> node) {
////        if (first != null) {
////            SLLNode<E> tmp = first;
////            if (first == node) {
////                return this.deleteFirst();
////            }
////            while (tmp.succ != node && tmp.succ.succ != null)
////                tmp = tmp.succ;
////            if (tmp.succ == node) {
////                tmp.succ = tmp.succ.succ;
////                return node.element;
////            } else {
////                System.out.println("Elementot ne postoi vo listata");
////                return null;
////            }
////        } else {
////            System.out.println("Listata e prazna");
////            return null;
////        }
////
////    }
//
//    public SLLNode getFirst() {
//        return first;
//    }
//
////    public SLLNode<E> find(E o) {
////        if (first != null) {
////            SLLNode<E> tmp = first;
////            while (!tmp.element.equals(o) && tmp.succ != null)
////                tmp = tmp.succ;
////            if (tmp.element.equals(o)) {
////                return tmp;
////            } else {
////                System.out.println("Elementot ne postoi vo listata");
////            }
////        } else {
////            System.out.println("Listata e prazna");
////        }
////        return null;
////    }
////
////    public void merge(SLL<E> in) {
////        if (first != null) {
////            SLLNode<E> tmp = first;
////            while (tmp.succ != null)
////                tmp = tmp.succ;
////            tmp.succ = in.getFirst();
////        } else {
////            first = in.getFirst();
////        }
////    }
////
////    public void mirror() {
////        if (first != null) {
////            //m=nextsucc, p=tmp,q=next
////            SLLNode<E> tmp = first;
////            SLLNode<E> newsucc = null;
////            SLLNode<E> next;
////
////            while (tmp != null) {
////                next = tmp.succ;
////                tmp.succ = newsucc;
////                newsucc = tmp;
////                tmp = next;
////            }
////            first = newsucc;
////        }
////    }
//
//    public SLL brisi_pomali_od(int iznos){
//        SLLNode current = first;
//        SLLNode prev = first;
//
//        while(current != null){
//            if(current.plata < iznos){
//                if(current == first){
//                    first = current.succ;
//                    prev = first;
//                    current = first;
//                }else{
//                    prev.succ = current.succ;
//                    current = current.succ;
//                }
//            }else{
//                prev = current;
//                current = current.succ;
//            }
//        }
//        return this;
//    }
//
//    public SLL sortiraj_opagacki(){
//        SLLNode node, prev1, prev2, tmp;
//        for(int i=0;i<length();i++){
//            node = first.succ;
//            prev1 = first;
//            prev2 = first;
//
//            while (node != null){
//                if(prev1.id < node.id){
//                    tmp = node.succ;
//                    node.succ = prev1;
//                    prev1.succ = tmp;
//
//                    if(prev1 == first){
//                        first = node;
//                    } else{
//                        prev2.succ = node;
//                    }
//                    prev2 = node;
//                    node = tmp;
//                } else{
//                    if(prev1 != first)
//                        prev2 = prev2.succ;
//                    prev1 = prev1.succ;
//                    node = node.succ;
//                }
//            }
//        }
//    }
//
//    public void pecati(SLL lista){
//        SLLNode p = lista.first;
//        while(p!=null){
//            System.out.println(p.id + " " + p.plata);
//            p = p.succ;
//        }
//    }
//}
//
//public class workers {
//    public static void main(String[] args) throws IOException {
//        SLL lista1 = new SLL();
//        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
//        String s = stdin.readLine();
//        int N = Integer.parseInt(s);
//
//        for(int i=0;i<N;i++){
//            s = stdin.readLine();
//            String s1 = stdin.readLine();
//            lista1.insertLast(Integer.parseInt(s), Integer.parseInt(s1));
//        }
//        s = stdin.readLine();
//
//        lista1 = lista1.brisi_pomali_od(Integer.parseInt(s));
//        if(lista1 != null){
//            lista1 = lista1.sortiraj_opagacki();
//            lista1.pecati(lista1);
//        }
//    }
//}
//
//
