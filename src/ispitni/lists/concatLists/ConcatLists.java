//package ispitni.lists.concatLists;
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
//            if (first.succ == null){
//                last = null;
//                first = null;
//            }
//            else{
//                DLLNode<E> tmp = first;
//                first = first.succ;
//                first.pred = null;
//                return tmp.element;
//            }
//        }
//        return null;
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
///*
//Дадени се две двострано поврзани листи чии што јазли содржат по еден
//природен број. Од овие две листи треба да се креира нова двострано
//поврзана листа, на тој начин што јазлите ќе се додаваат наизменично
//и тоа само оние со парни броеви (прв елемент од првата листа
//(ако е парен), последен од втората (ако е парен), втор елемент од
//првата листа (ако е парен), претпоследен од втората (ако е парен) итн.).
//Јазлите со парни броеви кои ќе останат треба да се додадат на крај во
//резултантната листа. Потоа на резултантната листа се додаваат само
//преостанатите јазли со непарни елементи од првата листа и преостанатите
//јазли со непарни елементи но во обратен редослед од втората листа.
//
//Освен наведените три листи немате право на користење на дополнителни помошни
//листи.
//Во првиот ред од влезот е даден бројот на јазли во првата листа,
//потоа во вториот ред се дадени броевите од кои се составени јазлите
//по редослед во првата листа, па во третиот ред е даден бројот на јазли
//во втората листа, и на крај во четвртиот ред броевите од кои се составени
//јазлите по редослед во втората листа. На излез треба да се испечатат јазлите
//по редослед во резултантната споена листа.
//
//Забелешка: При реализација на задачите МОРА да се користат дадените структури,
//а не да се користат помошни структури како низи или сл.
//Делумно решение: Задачата се смета за делумно решена доколку се поминати
//7 тест примери.
// */
//
//public class ConcatLists {
//    public static DLL<Integer> concatLists(DLL<Integer> list1, DLL<Integer> list2) {
//        DLLNode<Integer> tmp1 = list1.getFirst();
//        DLLNode<Integer> tmp2 = list2.getLast();
//        DLL<Integer> newList = new DLL<Integer>();
//        while(tmp1 != null && tmp2 != null){
//            if(tmp1.element % 2 == 0){
//                newList.insertLast(tmp1.element);
//            }
//            if(tmp2.element % 2 == 0){
//                newList.insertLast(tmp2.element);
//            }
//            tmp1 = tmp1.succ;
//            tmp2 = tmp2.pred;
//        }
//        if(tmp1 != null){
//            while(tmp1 != null){
//                if(tmp1.element % 2 == 0){
//                    newList.insertLast(tmp1.element);
//                }
//                tmp1 = tmp1.succ;
//            }
//        } else if(tmp2 != null){
//            while(tmp2 != null){
//                if(tmp2.element % 2 == 0){
//                    newList.insertLast(tmp2.element);
//                }
//                tmp2 = tmp2.pred;
//            }
//        }
//        tmp1 = list1.getFirst();
//        tmp2 = list2.getLast();
//        while(tmp1 != null){
//            if(tmp1.element % 2 != 0){
//                newList.insertLast(tmp1.element);
//            }
//            tmp1 = tmp1.succ;
//        }
//        while(tmp2 != null){
//            if(tmp2.element % 2 != 0){
//                newList.insertLast(tmp2.element);
//            }
//            tmp2 = tmp2.pred;
//        }
//        return newList;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        DLL<Integer> list1 = new DLL<Integer>();
//        for(int i=0;i<n;i++){
//            list1.insertLast(sc.nextInt());
//        }
//        int m = sc.nextInt();
//        DLL<Integer> list2 = new DLL<Integer>();
//        for(int i=0;i<m;i++){
//            list2.insertLast(sc.nextInt());
//        }
//        System.out.println(concatLists(list1,list2));
//    }
//}
