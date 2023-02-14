//package ispitni.lists_easy;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
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
//class Athlete{
//    int id;
//    double time;
//
//    public Athlete(int id, double time) {
//        this.id = id;
//        this.time = time;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public double getTime() {
//        return time;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%d",id);
//    }
//}
//
//public class Athletes {
//    public static void rearrangeAthletes(SLL<Athlete> lastYearWinners, SLL<Athlete> currentAthletes) {
//        SLLNode<Athlete> lastYearTmp = lastYearWinners.getFirst();
//        SLLNode<Athlete> currentTmp = currentAthletes.getFirst();
//        double worstTime = 0.0;
//        while(lastYearTmp != null){
//            if(lastYearTmp.element.getTime() > worstTime){
//                worstTime = lastYearTmp.element.getTime();
//            }
//            lastYearTmp = lastYearTmp.succ;
//        }
//        while(currentTmp != null){
//            if(currentTmp.element.getTime() > worstTime){
//                currentAthletes.delete(currentTmp);
//            }
//            currentTmp = currentTmp.succ;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int m = Integer.parseInt(br.readLine());
//        SLL<Athlete> lastYearWinners = new SLL<Athlete>();
//        SLL<Athlete> currentAthletes = new SLL<Athlete>();
//        for(int i=0;i<n;i++){
//            String[] parts = br.readLine().split("\\s+");
//            lastYearWinners.insertLast(new Athlete(
//                    Integer.parseInt(parts[0]),
//                    Double.parseDouble(parts[1])
//            ));
//        }
//        for(int i=0;i<m;i++){
//            String[] parts = br.readLine().split("\\s+");
//            currentAthletes.insertLast(new Athlete(
//                    Integer.parseInt(parts[0]),
//                    Double.parseDouble(parts[1])
//            ));
//        }
//        rearrangeAthletes(lastYearWinners,currentAthletes);
//        System.out.println(currentAthletes);
//    }
//}
