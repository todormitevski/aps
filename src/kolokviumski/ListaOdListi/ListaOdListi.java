//package kolokviumski.ListaOdListi;
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
//public class ListaOdListi {
//    //od risot
////        public static long findMagicNumber(DLL<DLL<Integer>> list) {
////            //Vashiot kod tuka...
////            //Vashiot kod tuka.. ????????????????????????????????????O.
////            int sum=0;
////            int i =0;
////            long proizvod=1;
////            int s[] = new int[list.length()];
////            DLLNode<DLL<Integer>> current = list.getFirst();
////            while(current != null){
////                DLL<Integer> tmp = current.element; //gets first line
////                DLLNode<Integer> tmp2 = tmp.getFirst(); //gets first element of first line (or nth)
////                while(tmp2 != null){
////                    sum+=tmp2.element;
////                    tmp2 = tmp2.succ;
////                }
////                s[i] = sum;
////                i++;
////                sum = 0;
////                current = current.succ;
////            }
////            for (int j = 0; j < s.length; j++) {
////                proizvod*=s[j];
////            }
////            return proizvod;
////        }
//
//    public static long findMagicNumber(DLL<DLL<Integer>> list) {
//        //Vashiot kod tuka...
////        Input	     Result
////        4          2352000
////        4
////        6 13 16 7
////        7 23 9 11
////        8 0 8 19
////        6 6 9 11
//
//        DLLNode<DLL<Integer>> lista = list.getFirst();
//
//        int sum = 0, sumArray[] = new int[list.length()], i = 0;
//        long product = 1;
//
//        while(lista != null){
//
//            DLL<Integer> currentLine = lista.element;
//            DLLNode<Integer> currentElem = currentLine.getFirst();
//
//            while(currentElem != null){
//
//                sum += currentElem.element;
//
//                currentElem = currentElem.succ;
//            }
//
//            sumArray[i] = sum; i++; sum = 0;
//
//            lista = lista.succ;
//        }
//
//        for(int j=0;j<i;j++){
//            product *= sumArray[j];
//        }
//
//        return product;
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
//        for (int i = 0; i < n; i++) {
//            DLL<Integer> tmp = new DLL<Integer>();
//            for (int j = 0; j < m; j++) {
//                tmp.insertLast(in.nextInt());
//            }
//            list.insertLast(tmp);
//        }
//        in.close();
//        System.out.println(findMagicNumber(list));
//    }
//
//}
