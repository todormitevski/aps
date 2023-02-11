//package vezbi;
//
//import java.util.Objects;
//
//public class DLL<E> {
//    private DLLNode<E> first;
//    private DLLNode<E> last;
//
//    public DLL(){
//        this.first=null;
//        this.last=null;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        DLL<?> dll = (DLL<?>) o;
//        return Objects.equals(first, dll.first) && Objects.equals(last, dll.last);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(first, last);
//    }
//
//    @Override
//    public String toString() {
//        return "DLL{" +
//                "first=" + first +
//                ", last=" + last +
//                '}';
//    }
//
//    private int getSize(){
//        int br=0;
//        DLLNode<E> current=first;
//        while(current!=null){
//            br++;
//            current=current.succ;
//        }
//        return br;
//    }
//
//    public void insertFirst(E o){
//        DLLNode<E> ins=new DLLNode<E>(o,null,first);
//        if(first==null) {
//            last=ins;
//        } else {
//            first.pred=ins;
//        }
//        first=ins;
//    }
//
//    public void insertLast(E o){
//        if(first==null){
//            insertFirst(o);
//        } else{
//            DLLNode<E> ins=new DLLNode<E>(o,last,null);
//            last.succ=ins;
//            last=ins;
//        }
//    }
//
//    public void insertAfter(E o,DLLNode<E> after){
//        if(after==last){
//            insertLast(o);
//            return;
//        }
//        DLLNode<E> ins=new DLLNode<E>(o,after,after.succ);
//        after.succ.pred=ins;
//        after.succ=ins;
//    }
//
//    public void insertBefore(E o, DLLNode<E> before){
//        if(before==first){
//            insertFirst(o);
//            return;
//        }
//        DLLNode<E> ins=new DLLNode<E>(o, before.pred, before);
//        before.pred.succ=ins;
//        before.pred=ins;
//    }
//
//    public E deleteFirst(){
//        if(first!=null){
//            DLLNode<E> tmp=first;
//            first=first.succ;
//            if(first!=null){
//                first.pred=null;
//            }
//            if(first==null){
//                last=null;
//            }
//            return tmp.element;
//        } else return null;
//    }
//
//    public E deleteLast(){
//        if(first!=null){
//            if(first.succ==null){
//                return deleteFirst();
//            } else{
//                DLLNode<E> tmp=last;
//                last=last.succ;
//                last.succ=null;
//                return tmp.element;
//            }
//        } else return null;
//    }
//
//    public E delete(DLLNode<E> node){
//        if(node==first) return deleteFirst();
//        if(node==last) return deleteLast();
//
//        node.pred.succ=node.succ;
//        node.succ.pred=node.pred;
//        return node.element;
//    }
//
//    public DLLNode<E> find(E o){
//        if(first!=null){
//            DLLNode<E> tmp=first;
//            while(!tmp.element.equals(o) && tmp.succ!=null){
//                tmp=tmp.succ;
//            }
//            if(tmp.element.equals(o)) return tmp;
//            else System.out.println("Element not in list");
//        }
//        return null;
//    }
//
//    public void printList(){
//        DLLNode<E> current=first.succ;
//        System.out.println("DLL print:");
//        System.out.print(first.element + " <-> ");
//        while(current.succ!=null){
//            System.out.print(current.element + " <-> ");
//            current=current.succ;
//        }
//        System.out.println(current.element + "\n");
//    }
//
//    public void deleteDupes(){
//        DLLNode<E> current1=first;
//        DLLNode<E> current2;
//        while(current1!=null){
//            current2=current1.succ;
//            while(current2!=null){
//
//                if(current2.occurrences>1 || current2.element.equals(current1.element)){
//                    delete(current2);
//                }
//                if(current2.element.equals(current1.element)){
//                    current2.occurrences++;
//                }
//
//                current2=current2.succ;
//            }
//            current1=current1.succ;
//        }
//    }
//
//    public void locateMiddleElem(){
//        int length=getSize();
//        double middle=Math.ceil((double)length/2);
//
//        DLLNode<E> current=first;
//        while(current!=null){
//            if(middle==1){
//                if(length%2==0){
//                    System.out.println("Middle nodes are: " + current.element + " and " + current.succ.element);
//                    return;
//                }
//                System.out.println("Middle node is: " + current.element);
//                return;
//            }
//            middle--;
//            current=current.succ;
//        }
//    }
//
//    public static void main(String[] args) {
//        DLL<String> clashTeam=new DLL<>();
//        clashTeam.insertLast("AnAssimilator");
//        clashTeam.insertLast("MightOfWalkorion");
//        clashTeam.insertLast("ive12334");
//        clashTeam.insertLast("100gecsfan");
//        clashTeam.insertLast("Aerraa");
//        clashTeam.insertLast("Hexodian");
//        clashTeam.printList();
//
//        System.out.println("--TESTING MIDDLE LOCATOR--");
//        clashTeam.printList();
//        clashTeam.locateMiddleElem();
//        System.out.println();
//
//        System.out.println("TESTING DELETION DUPLICATES");
//        DLL<Integer> dll=new DLL<>();
//        dll.insertLast(1);
//        dll.insertLast(6);
//        dll.insertLast(1);
//        dll.insertLast(2);
//        dll.insertLast(1);
//        dll.insertLast(2);
//        dll.insertLast(7);
//
//        System.out.println("--BEFORE DELETION--");
//        dll.printList();
//        dll.deleteDupes();
//        System.out.println("--AFTER DELETION--");
//        dll.printList();
//    }
//}