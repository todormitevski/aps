//package ispitni.mirroredDLL;
//
//import java.util.Scanner;
//
//class DLLNode<E> {
//    protected E element;
//    protected DLLNode<E> pred, succ;
//
//    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
//        this.element = elem;
//        this.pred = pred;
//        this.succ = succ;
//    }
//
//    @Override
//    public String toString() {
//        return "<-" + element.toString() + "->";
//    }
//}
//
//class DLL<E> {
//    private DLLNode<E> first, last;
//
//    public DLL() {
//        // Construct an empty SLL
//        this.first = null;
//        this.last = null;
//    }
//
//    public void deleteList() {
//        first = null;
//        last = null;
//    }
//
//    public int length() {
//        int ret;
//        if (first != null) {
//            DLLNode<E> tmp = first;
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
//    public void insertFirst(E o) {
//        DLLNode<E> ins = new DLLNode<E>(o, null, first);
//        if (first == null)
//            last = ins;
//        else
//            first.pred = ins;
//        first = ins;
//    }
//
//    public void insertLast(E o) {
//        if (first == null)
//            insertFirst(o);
//        else {
//            DLLNode<E> ins = new DLLNode<E>(o, last, null);
//            last.succ = ins;
//            last = ins;
//        }
//    }
//
//    public void insertAfter(E o, DLLNode<E> after) {
//        if (after == last) {
//            insertLast(o);
//            return;
//        }
//        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
//        after.succ.pred = ins;
//        after.succ = ins;
//    }
//
//    public void insertBefore(E o, DLLNode<E> before) {
//        if (before == first) {
//            insertFirst(o);
//            return;
//        }
//        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
//        before.pred.succ = ins;
//        before.pred = ins;
//    }
//
//    public E deleteFirst() {
//        if (first != null) {
//            DLLNode<E> tmp = first;
//            first = first.succ;
//            if (first != null) first.pred = null;
//            if (first == null)
//                last = null;
//            return tmp.element;
//        } else
//            return null;
//    }
//
//    public E deleteLast() {
//        if (first != null) {
//            if (first.succ == null)
//                return deleteFirst();
//            else {
//                DLLNode<E> tmp = last;
//                last = last.pred;
//                last.succ = null;
//                return tmp.element;
//            }
//        }
//        // else throw Exception
//        return null;
//    }
//
//    @Override
//    public String toString() {
//        String ret = new String();
//        if (first != null) {
//            DLLNode<E> tmp = first;
//            ret += tmp + "<->";
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret += tmp + "<->";
//            }
//        } else
//            ret = "Prazna lista!!!";
//        return ret;
//    }
//
//    public DLLNode<E> getFirst() {
//        return first;
//    }
//
//    public DLLNode<E> getLast() {
//
//        return last;
//    }
//
//    public E delete(DLLNode<E> node) {
//        if(node==first){
//            deleteFirst();
//            return node.element;
//        }
//        if(node==last){
//            deleteLast();
//            return node.element;
//        }
//        node.pred.succ = node.succ;
//        node.succ.pred = node.pred;
//        return node.element;
//
//    }
//}
//
//public class MirroredDLL {
////    public static void funkcija(DLL<Integer>lista) {
////        //to do:
////        int length = lista.length();
////        DLL<Integer> newList = new DLL<>();
////        DLLNode<Integer> tmpForward = lista.getFirst();
////        DLLNode<Integer> tmpBackward = lista.getLast();
////
////        while(tmpForward != null || tmpBackward != null){
////            if(tmpForward != null){
////                newList.insertLast(tmpForward.element);
////            }
////            if(tmpBackward != null){
////                newList.insertLast(tmpBackward.element);
////            }
////            tmpForward = tmpForward.succ;
////            tmpBackward = tmpBackward.pred;
////        }
////
////        int counter = 0;
////        while(counter != length){
////            newList.deleteLast();
////            counter++;
////        }
////        lista = newList;
////        System.out.println(lista);
////    }
//
//    public static void funkcija(DLL<Integer>lista) {
//        //WITHOUT NEW LIST CREATION
//        DLLNode<Integer> tmpForward = lista.getFirst();
//        DLLNode<Integer> tmpBackward = lista.getLast();
//        int length = lista.length();
//        if(length % 2 == 0){ //if even num of elems
//            for(int i=0;i<length/2;i++){
//                tmpForward = tmpForward.succ;
//                lista.insertBefore(tmpBackward.element, tmpForward); //inserts in between 1st and 2nd elem
//                lista.delete(tmpBackward); //deletes the then 2nd, now 3rd elem
//                tmpBackward = tmpBackward.pred;
//            }
//        }
//        else { //if odd num of elems
//            while (tmpForward != tmpBackward) {
//                tmpForward = tmpForward.succ;
//                lista.insertBefore(tmpBackward.element, tmpForward);
//                lista.delete(tmpBackward);
//                tmpBackward = tmpBackward.pred;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int N = input.nextInt();
//        DLL<Integer> lista = new DLL();
//        for(int i = 0;i < N;i++){
//            int broj = input.nextInt();
//            lista.insertLast(broj);
//        }
//        funkcija(lista);
//        System.out.println(lista);
//    }
//}
