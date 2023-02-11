//package ispitni.lists.concatUniqueDll;
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
//        return element.toString();
//    }
//}
//
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
//    public DLLNode<E> find(E o) {
//        if (first != null) {
//            DLLNode<E> tmp = first;
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
//        if(after==last){
//            insertLast(o);
//            return;
//        }
//        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
//        after.succ.pred = ins;
//        after.succ = ins;
//    }
//
//    public void insertBefore(E o, DLLNode<E> before) {
//        if(before == first){
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
//    public String toStringR() {
//        String ret = new String();
//        if (last != null) {
//            DLLNode<E> tmp = last;
//            ret += tmp + "<->";
//            while (tmp.pred != null) {
//                tmp = tmp.pred;
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
//public class ConcatUniqueDll {
//    public static void removeDupes(DLL<Integer> list){
//        DLLNode<Integer> curr = list.getFirst();
//        while(curr.succ != null){
//            if(curr.element.equals(curr.succ.element)){
//                list.delete(curr);
//            }
//            curr = curr.succ;
//        }
//        System.out.println(list);
//    }
//
//    public static DLL<Integer> concatUnique(DLL<Integer> firstList, DLL<Integer> secondList){
//        DLLNode<Integer> firstCurr = firstList.getFirst();
//        DLLNode<Integer> secondCurr = secondList.getFirst();
//        DLL<Integer> newDll = new DLL<Integer>();
//        while(firstCurr != null && secondCurr != null){
//            if(firstCurr.element <= secondCurr.element){
//                newDll.insertLast(firstCurr.element);
//                firstCurr = firstCurr.succ;
//            } else{
//                newDll.insertLast(secondCurr.element);
//                secondCurr = secondCurr.succ;
//            }
//        }
//        if(firstCurr == null){
//            while(secondCurr != null){
//                newDll.insertLast(secondCurr.element);
//                secondCurr = secondCurr.succ;
//            }
//        } else{
//            while(firstCurr != null){
//                newDll.insertLast(firstCurr.element);
//                firstCurr = firstCurr.succ;
//            }
//        }
//        return newDll;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        DLL<Integer> firstList = new DLL<Integer>();
//        DLL<Integer> secondList = new DLL<Integer>();
//        for(int i=0;i<n;i++){
//            firstList.insertLast(sc.nextInt());
//        }
//        int m = sc.nextInt();
//        for(int i=0;i<m;i++){
//            secondList.insertLast(sc.nextInt());
//        }
//        System.out.println("Lists:");
//        System.out.println(firstList);
//        System.out.println(secondList);
//        System.out.println("Resulting list:");
//        removeDupes(concatUnique(firstList,secondList));
//    }
//}
