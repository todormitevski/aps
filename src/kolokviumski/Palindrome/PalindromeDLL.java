//package kolokviumski.Palindrome;
//
//import java.util.Scanner;
//
//class DLLNode<E> {
//    protected E element;
//    protected kolokviumski.ListaOdListi.DLLNode<E> pred, succ;
//
//    public DLLNode(E elem, kolokviumski.ListaOdListi.DLLNode<E> pred, kolokviumski.ListaOdListi.DLLNode<E> succ) {
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
//    private kolokviumski.ListaOdListi.DLLNode<E> first, last;
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
//            kolokviumski.ListaOdListi.DLLNode<E> tmp = first;
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
//        kolokviumski.ListaOdListi.DLLNode<E> ins = new kolokviumski.ListaOdListi.DLLNode<E>(o, null, first);
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
//            kolokviumski.ListaOdListi.DLLNode<E> ins = new kolokviumski.ListaOdListi.DLLNode<E>(o, last, null);
//            last.succ = ins;
//            last = ins;
//        }
//    }
//
//    public void insertAfter(E o, kolokviumski.ListaOdListi.DLLNode<E> after) {
//        if (after == last) {
//            insertLast(o);
//            return;
//        }
//        kolokviumski.ListaOdListi.DLLNode<E> ins = new kolokviumski.ListaOdListi.DLLNode<E>(o, after, after.succ);
//        after.succ.pred = ins;
//        after.succ = ins;
//    }
//
//    public void insertBefore(E o, kolokviumski.ListaOdListi.DLLNode<E> before) {
//        if (before == first) {
//            insertFirst(o);
//            return;
//        }
//        kolokviumski.ListaOdListi.DLLNode<E> ins = new kolokviumski.ListaOdListi.DLLNode<E>(o, before.pred, before);
//        before.pred.succ = ins;
//        before.pred = ins;
//    }
//
//    public E deleteFirst() {
//        if (first != null) {
//            kolokviumski.ListaOdListi.DLLNode<E> tmp = first;
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
//                kolokviumski.ListaOdListi.DLLNode<E> tmp = last;
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
//            kolokviumski.ListaOdListi.DLLNode<E> tmp = first;
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
//    public kolokviumski.ListaOdListi.DLLNode<E> getFirst() {
//        return first;
//    }
//
//    public kolokviumski.ListaOdListi.DLLNode<E> getLast() {
//
//        return last;
//    }
//
//}
//
//public class PalindromeDLL {
//
//    public static int isItPalindrome(kolokviumski.ListaOdListi.DLL<Integer> list){
//        //Vashiot kod tuka...
////        Input	        Result
////        5
////        1 2 3 1 2     -1
//// print 1 if palindrome, otherwise -1
//
//        kolokviumski.ListaOdListi.DLLNode<Integer> current = list.getFirst();
//        kolokviumski.ListaOdListi.DLLNode<Integer> reverse = list.getLast();
//
//        int flag = 1;
//
//        while(current != null){
//
//            if(!current.element.equals(reverse.element)){
//                flag = -1;
//            }
//
//            current = current.succ;
//            reverse = reverse.pred;
//        }
//        return flag;
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        kolokviumski.ListaOdListi.DLL<Integer> list = new kolokviumski.ListaOdListi.DLL<Integer>();
//        for (int i = 0; i < n; i++) {
//            list.insertLast(in.nextInt());
//        }
//        in.close();
//        System.out.println(isItPalindrome(list));
//    }
//
//}
