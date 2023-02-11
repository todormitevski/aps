//package ispitni.lists.combineSortedSLL;
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
//public class CombineSortedSLL {
//    /*
//    1 -> 2 -> 4
//    1 -> 3 -> 4
//    result:
//    1 -> 1 -> 2 -> 3 -> 4 -> 4
//     */
//
//    public static SLL<Integer> combineListsSorted(SLL<Integer> list1, SLL<Integer> list2){
//        SLLNode<Integer> head1 = list1.getFirst();
//        SLLNode<Integer> head2 = list2.getFirst();
//        SLL<Integer> newList = new SLL<Integer>();
//
//        while(head1 != null && head2 != null){
//            if(head1.element < head2.element){
//                newList.insertLast(head1.element);
//                head1 = head1.succ;
//            } else{
//                newList.insertLast(head2.element);
//                head2 = head2.succ;
//            }
//        }
//        if(head1 == null){
//            while(head2 != null){
//                newList.insertLast(head2.element);
//                head2 = head2.succ;
//            }
//        } else{
//            while(head1 != null){
//                newList.insertLast(head1.element);
//                head1 = head1.succ;
//            }
//        }
//        return newList;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        SLL<Integer> list1 = new SLL<Integer>();
//        SLL<Integer> list2 = new SLL<Integer>();
//        for(int i=0;i<n;i++){
//            list1.insertLast(sc.nextInt());
//        }
//        for(int i=0;i<m;i++){
//            list2.insertLast(sc.nextInt());
//        }
//        System.out.println(combineListsSorted(list1,list2));
//    }
//}
