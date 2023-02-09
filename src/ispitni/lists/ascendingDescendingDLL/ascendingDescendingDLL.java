//package ispitni.lists.ascendingDescendingDLL;
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
//}
//
//public class ascendingDescendingDLL {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        DLL<Integer> listOne = new DLL<Integer>();
//        DLL<Integer> listTwo = new DLL<Integer>();
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        for(int i=0;i<n;i++){
//            listOne.insertLast(sc.nextInt());
//        }
//        for(int i=0;i<m;i++){
//            listTwo.insertLast(sc.nextInt());
//        }
//        System.out.println(concatDescAsc(listOne,listTwo,false));
//        System.out.println(concatDescAsc(listOne,listTwo,true));
//    }
//
//    private static DLL<Integer> concatDescAsc(DLL<Integer> listOne, DLL<Integer> listTwo, boolean isAscending) {
//        DLL<Integer> newDll = new DLL<Integer>();
//        if(!isAscending){
//            DLLNode<Integer> tmpOne = listOne.getLast();
//            DLLNode<Integer> tmpTwo = listTwo.getFirst();
//            while(tmpTwo != null || tmpOne != null){
//                if(tmpOne.element > tmpTwo.element){
//                    newDll.insertLast(tmpOne.element);
//                    tmpOne = tmpOne.succ;
//                } else{
//                    newDll.insertLast(tmpTwo.element);
//                    tmpTwo = tmpTwo.pred;
//                }
//            }
//        } else{
//            DLLNode<Integer> tmpOne = listOne.getFirst();
//            DLLNode<Integer> tmpTwo = listTwo.getLast();
//            while(tmpOne != null || tmpTwo != null){
//                if(tmpOne != null && (tmpTwo.element < tmpOne.element)){
//                    newDll.insertLast(tmpTwo.element);
//                    tmpTwo = tmpTwo.pred;
//                } else{
//                    newDll.insertLast(tmpOne.element);
//                    tmpOne = tmpOne.succ;
//                }
//            }
//        }
//        return newDll;
//    }
//}
//later