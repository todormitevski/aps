//package ispitni.dllSorted;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.util.stream.Collectors;
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
//public class DLLSorted {
//    public static DLL<Integer> createNewDLL(DLL<Integer> listOne, DLL<Integer> listTwo){
//        DLLNode<Integer> listOneTmp = listOne.getFirst();
//        DLLNode<Integer> listTwoTmp = listTwo.getFirst();
//        DLL<Integer> newDLL = new DLL<>();
//        newDLL.insertLast(listOneTmp.element);
//        while(listOneTmp != null){
//            DLLNode<Integer> newListTmp = newDLL.getFirst();
//            int flag = 0;
//            while(newListTmp != null){
//                if(newListTmp.element.equals(listOneTmp.element)){
//                    flag = 1;
//                }
//                newListTmp = newListTmp.succ;
//            }
//            if(flag == 0){
//                newDLL.insertLast(listOneTmp.element);
//            }
//            listOneTmp = listOneTmp.succ;
//        }
//        while(listTwoTmp != null){
//            DLLNode<Integer> newListTmp = newDLL.getFirst();
//            int flag = 0;
//            while(newListTmp != null){
//                if(newListTmp.element.equals(listTwoTmp.element)){
//                    flag = 1;
//                }
//                newListTmp = newListTmp.succ;
//            }
//            if(flag == 0){
//                newDLL.insertLast(listTwoTmp.element);
//            }
//            listTwoTmp = listTwoTmp.succ;
//        }
//        return newDLL;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        DLL<Integer> listOne = new DLL<>();
//        DLL<Integer> listTwo = new DLL<>();
//        for(int i=0;i<n;i++){
//            listOne.insertLast(scanner.nextInt());
//        }
//        int m = scanner.nextInt();
//        for(int i=0;i<m;i++){
//            listTwo.insertLast(scanner.nextInt());
//        }
//
//        DLL<Integer> newDLL = createNewDLL(listOne,listTwo);
//        DLLNode<Integer> newDLLTmp = newDLL.getFirst();
//        List<Integer> listDLL = new ArrayList<>();
//        while(newDLLTmp != null){
//            listDLL.add(newDLLTmp.element);
//            newDLLTmp = newDLLTmp.succ;
//        }
//        listDLL = listDLL.stream()
//                .sorted()
//                .collect(Collectors.toList());
//        listDLL.forEach(elem -> System.out.printf("%d ",elem));
//    }
//}
