//package ispitni.lists.addEvenSubtractOdd;
//
//import java.util.Scanner;
//
//class SLL<E> {
//    public SLLNode<E> first;
//
//    public SLL() {
//        first = null;
//    }
//
//    public void insertFirst(E element) {
//        SLLNode<E> nov = new SLLNode<>(element, first);
//        first = nov;
//    }
//
//    public void insertLast(E element) {
//        if (first == null) insertFirst(element);
//        else {
//            SLLNode<E> dvizi = first;
//            while (dvizi.succ != null) {
//                dvizi = dvizi.succ;
//            }
//            SLLNode<E> last = new SLLNode<>(element, null);
//            dvizi.succ = last;
//        }
//    }
//
//    public void insertAfter(E element, SLLNode<E> node) {
//        if (node != null) {
//            SLLNode<E> nov = new SLLNode<>(element, node.succ);
//            node.succ = nov;
//        }
//    }
//
//    public int getLength() {
//        SLLNode<E> dvizi = first;
//        int length = 0;
//        while (dvizi != null) {
//            length++;
//            dvizi = dvizi.succ;
//        }
//        return length;
//    }
//
//
//    public String toString() {
//        String s = new String();
//        SLLNode<E> dvizi = first;
//        while (dvizi != null) {
//            s = s + dvizi.element + " ";
//            dvizi = dvizi.succ;
//        }
//        return s;
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
//
//    public SLLNode<E> getFirst() {
//        return first;
//    }
//
//}
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
//public class AddEvenSubtractOdd {
//    public static void addEvenSubtractOdd(SLL<Integer> list){
//        SLLNode<Integer> curr = list.getFirst();
//        SLLNode<Integer> tmpEven = null;
//        SLLNode<Integer> tmpOdd = null;
//        int counterEven = 0;
//        int counterOdd = 0;
//        while(curr != null){
//            if(curr.element % 2 == 0){
//                counterEven++;
//                if(counterEven == 2){
//                    tmpEven.element = tmpEven.element + curr.element;
//                    list.insertAfter(tmpEven.element,tmpEven);
//                    list.delete(tmpEven);
//                    list.delete(curr);
//                    counterEven = 0;
//                } else{
//                    tmpEven = curr;
//                }
//            } else{
//                counterOdd++;
//                if(counterOdd == 2){
//                    tmpOdd.element = tmpOdd.element - curr.element;
//                    list.insertAfter(tmpOdd.element,tmpOdd);
//                    list.delete(tmpOdd);
//                    list.delete(curr);
//                    counterOdd = 0;
//                } else{
//                    tmpOdd = curr;
//                }
//            }
//            curr = curr.succ;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        SLL<Integer> list = new SLL<Integer>();
//        for(int i=0;i<n;i++){
//            list.insertLast(sc.nextInt());
//        }
//        System.out.println("-- LIST BEFORE --");
//        System.out.println(list);
//        addEvenSubtractOdd(list);
//        System.out.println("-- LIST AFTER --");
//        System.out.println(list);
//    }
//}
