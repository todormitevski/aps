//package ispitni.balls;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
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
//class SLL<E> {
//    private SLLNode<E> first;
//
//    public SLL() {
//        this.first = null;
//    }
//
//    public void deleteList() {
//        first = null;
//    }
//
//    public int length() {
//        int ret;
//        if (first != null) {
//            SLLNode<E> tmp = first;
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
//    @Override
//    public String toString() {
//        String ret = new String();
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            ret += tmp;
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret += " " + tmp;
//            }
//        } else
//            ret = "Prazna lista!!!";
//        return ret;
//    }
//
//    public void insertFirst(E o) {
//        SLLNode<E> ins = new SLLNode<E>(o, first);
//        first = ins;
//    }
//
//    public void insertAfter(E o, SLLNode<E> node) {
//        if (node != null) {
//            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
//            node.succ = ins;
//        } else {
//            System.out.println("Dadenot jazol e null");
//        }
//    }
//
//    public void insertBefore(E o, SLLNode<E> before) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            if (first == before) {
//                this.insertFirst(o);
//                return;
//            }
//            while (tmp.succ != before)
//                tmp = tmp.succ;
//            if (tmp.succ == before) {
//                SLLNode<E> ins = new SLLNode<E>(o, before);
//                tmp.succ = ins;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//            }
//        } else {
//            System.out.println("Listata e prazna");
//        }
//    }
//
//    public void insertLast(E o) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while (tmp.succ != null)
//                tmp = tmp.succ;
//            SLLNode<E> ins = new SLLNode<E>(o, null);
//            tmp.succ = ins;
//        } else {
//            insertFirst(o);
//        }
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
//    public SLLNode<E> getFirst() {
//        return first;
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
//}
//
//public class RGBalls {
//    public static void calcBalls(String line){
//        String[] parts = line.split("\\s+");
//        SLL<String> balls = new SLL<String>();
//        for(String part : parts){
//            balls.insertLast(part);
//        }
//        SLLNode<String> tmp1 = balls.getFirst();
//        SLLNode<String> tmp2;
//        boolean flag = false;
//        while(tmp1.succ != null){
//            tmp2 = tmp1.succ;
//            while(tmp2 != null){
//                if(tmp1.element.charAt(0) == tmp2.element.charAt(0)
//                && tmp1.element.charAt(1) != tmp2.element.charAt(1)){
//                    balls.delete(tmp1);
//                    balls.delete(tmp2);
//                    tmp1 = balls.getFirst();
//                    flag = true;
//                    break;
//                }
//                if(flag) tmp2 = tmp2.succ;
//            }
//            tmp1 = tmp1.succ;
//        }
//        System.out.println(balls.length());
//        System.out.println(balls);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        calcBalls(line);
//    }
//}
//NOT WORKING