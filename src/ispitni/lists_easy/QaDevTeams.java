//package ispitni.lists_easy;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
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
//class Employee{
//    int id;
//    int age;
//
//    public Employee(int id, int age) {
//        this.id = id;
//        this.age = age;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%d",id);
//    }
//}
//
////remove youngest from Qas, insert in the middle of Devs
//
//public class QaDevTeams {
//    public static void rearrangeTeams(SLL<Employee> devs, SLL<Employee> qas) {
//        SLLNode<Employee> tmpDevs = devs.getFirst();
//        SLLNode<Employee> tmpQas = qas.getFirst();
//        SLLNode<Employee> youngestQa = qas.getFirst();
//        while(tmpQas != null){
//            if(tmpQas.element.getAge() < youngestQa.element.getAge()){
//                youngestQa = tmpQas;
//            }
//            tmpQas = tmpQas.succ;
//        }
//        int devLength = devs.getLength();
//        int i = 0;
//        SLLNode<Employee> whereToInsert = null;
//        if(devLength % 2 == 0){
//            while(i < devLength/2){
//                whereToInsert = tmpDevs;
//                i++;
//                tmpDevs = tmpDevs.succ;
//            }
//        } else{
//            while(i < devLength/2 + 1){
//                whereToInsert = tmpDevs;
//                i++;
//                tmpDevs = tmpDevs.succ;
//            }
//        }
//        devs.insertAfter(youngestQa.element,whereToInsert);
//        qas.delete(youngestQa);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int m = Integer.parseInt(br.readLine());
//        SLL<Employee> Devs = new SLL<Employee>();
//        SLL<Employee> Qas = new SLL<Employee>();
//        for(int i=0;i<n;i++){
//            String[] parts = br.readLine().split("\\s+");
//            Employee employee = new Employee(
//                    Integer.parseInt(parts[0]),
//                    Integer.parseInt(parts[1])
//            );
//            Devs.insertLast(employee);
//        }
//        for(int i=0;i<m;i++){
//            String[] parts = br.readLine().split("\\s+");
//            Employee employee = new Employee(
//                    Integer.parseInt(parts[0]),
//                    Integer.parseInt(parts[1])
//            );
//            Qas.insertLast(employee);
//        }
//        rearrangeTeams(Devs,Qas);
//        System.out.println(Devs);
//        System.out.println(Qas);
//    }
//}
