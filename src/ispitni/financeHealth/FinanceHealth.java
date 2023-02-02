//package ispitni.financeHealth;
//
//import java.util.*;
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
//class SLL<E> {
//    private SLLNode<E> first;
//
//    public SLL() {
//        // Construct an empty SLL
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
//            ret += tmp + " ";
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret += tmp + " ";
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
//
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            if(first==before){
//                this.insertFirst(o);
//                return;
//            }
//            //ako first!=before
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
//            if(first ==node){
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
//
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
//
//}
//
//class Discussion
//{
//    private int id;
//    private int popularity;
//    private int users;
//
//    public Discussion(int id, int popularity, int users) {
//        this.id = id;
//        this.popularity = popularity;
//        this.users = users;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getPopularity() {
//        return popularity;
//    }
//
//    public void setPopularity(int popularity) {
//        this.popularity = popularity;
//    }
//
//    public int getUsers() {
//        return users;
//    }
//
//    public void setUsers(int users) {
//        this.users = users;
//    }
//
//    public String toString()
//    {
//        return id + "";
//    }
//    //new
//    public int calcPopularity(){
//        return users * popularity;
//    }
//}
//
//public class FinanceHealth{
//
////    INPUT
////
////        2
////        2
////        111 80 12
////        222 70 11
////        333 50 10
////        444 90 77
////
////    OUTPUT
////
////        111 222
////        444 111
//
//    public static void forum(SLL<Discussion> health, SLL<Discussion> finance){
//        //to do: Најдобрата популарност од Health(users * popularity)
//        // треба да се додаде на крајот од Finance, и најслабата популарност
//        // од Finance да се избрише
//        SLLNode<Discussion> tmpHealth = health.getFirst();
//        SLLNode<Discussion> tmpFinance = finance.getFirst();
//
//        int maxPopularity = tmpHealth.element.calcPopularity();
//        //this also works
//        //Discussion highPopularityDiscussion = tmpHealth.element;
//        SLLNode<Discussion> highPopularityDiscussion = tmpHealth;
//        while(tmpHealth != null){
//            if(tmpHealth.element.calcPopularity() > maxPopularity){
//                maxPopularity = tmpHealth.element.calcPopularity();
//                highPopularityDiscussion = tmpHealth;
//            }
//            tmpHealth = tmpHealth.succ;
//        }
//        finance.insertLast(highPopularityDiscussion.element);
//
//        int minPopularity = tmpFinance.element.calcPopularity();
//        //not this
//        //Discussion lowPopularityDiscussion = null;
//        SLLNode<Discussion> lowPopularityDiscussion = tmpFinance;
//        while(tmpFinance != null){
//            if(tmpFinance.element.calcPopularity() < minPopularity){
//                minPopularity = tmpFinance.element.calcPopularity();
//                lowPopularityDiscussion = tmpFinance;
//            }
//            tmpFinance = tmpFinance.succ;
//        }
//        finance.delete(finance.find(lowPopularityDiscussion.element));
//    }
//
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        SLL<Discussion> health = new SLL();
//        SLL<Discussion> finance = new SLL<>();
//        int N = input.nextInt();
//        int M = input.nextInt();
//
//        for(int i=0;i<N;i++)
//        {
//            int id = input.nextInt();
//            int popularity = input.nextInt();
//            int users = input.nextInt();
//
//            health.insertLast(new Discussion(id,popularity,users));
//        }
//        for(int i=0;i<M;i++)
//        {
//            int id = input.nextInt();
//            int popularity = input.nextInt();
//            int users = input.nextInt();
//
//            finance.insertLast(new Discussion(id,popularity,users));
//        }
//
//        forum(health,finance);
//
//        System.out.println(health);
//        System.out.println(finance);
//    }
//}
