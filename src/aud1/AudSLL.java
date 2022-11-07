package aud1;

public class AudSLL<E extends Comparable<E>> {
    private AudSLLNode first;

    public AudSLL() {
        this.first = null;
    }

    public void printNodes(){
        System.out.println("The nodes are: ");
        for (AudSLLNode tmp=first;tmp!=null;tmp=tmp.succ){
            if(tmp.succ==null){
                System.out.println(tmp.element);
                break;
            }
            System.out.print(tmp.element + " -> ");
        }
        System.out.println();
    }

    public void insertFirst(Object o){
        AudSLLNode nov=new AudSLLNode(o, null);
        nov.succ=first;
        first=nov;
    }

    public void insertLast(Object o){
        if (first!=null) {
            AudSLLNode last=new AudSLLNode(o,null);
            AudSLLNode tmp=first;
            while(tmp.succ!=null){
                tmp=tmp.succ;
            }
            tmp.succ=last;
        } else{
            insertFirst(o);
        }
    }

    public void insert(Object o, AudSLLNode posle) {
        // Ash->Androxus
        //  Ash - Asim - Androxus
        // Asim->null
        // Asim -> Androxus
        // Ash -> Asim
        AudSLLNode ins = new AudSLLNode(o, null);
        if(posle == null) {
            ins.succ = first;
            first = ins;
        } else {
            ins.succ = posle.succ;
            posle.succ = ins;
        }
    }

    public AudSLLNode find(Object o){
        for(AudSLLNode curr=first; curr!=null; curr=curr.succ){
            if(o.equals(curr.element)){
                return curr;
            }
        }
        return null;
    }

    public int size(){
        int num=0;
        for(AudSLLNode curr=first; curr!=null;curr=curr.succ){
            num++;
        }
        return num;
    }

    public void deleteNode(Object o){
        AudSLLNode tmp=first;
        while(tmp.succ!=null){
            if(tmp.succ.equals(o)){
                tmp.succ=tmp.succ.succ;
            }
            tmp=tmp.succ;
        }
    }

    public void mirrorList(vezbi.SLL list){
        AudSLLNode current=first;
        AudSLLNode tmp=null; //pomoshen
        AudSLLNode next;

        while(current!=null){
            next=current.succ; //current:1, next:2
            current.succ=tmp;
            tmp=current;
            current=next;
        }
        first=tmp;
    }

    public static void main(String[] args) {
        AudSLL leagueChamps=new AudSLL();
//        AudSLLNode vtoro=new AudSLLNode("Katarina", new AudSLLNode("Pyke", null));
//        AudSLLNode prvo=new AudSLLNode("Jhin", null);
        leagueChamps.insertFirst("Pyke");
        leagueChamps.insertFirst("Asim");
        leagueChamps.insertFirst("Kai'Sa");
        leagueChamps.insertFirst("K'Sante");
        leagueChamps.printNodes();

        AudSLLNode ins=leagueChamps.find("Asim");
        leagueChamps.insert("Androxus", ins);

        leagueChamps.printNodes();

        System.out.println("SIZE() TESTING");
        System.out.println(leagueChamps.size());

        System.out.println("TESTING INSERT LAST");
        leagueChamps.insertLast("Risot");
        leagueChamps.printNodes();
        System.out.println();

        System.out.println("LIST BEFORE ASIM DELETION");
        leagueChamps.printNodes();
        System.out.println("LIST AFTER ASIM DELETION");
        leagueChamps.deleteNode(ins);
        leagueChamps.printNodes();
        System.out.println();

        System.out.println("-----TESTING MIRROR-----");
        vezbi.SLL numList=new vezbi.SLL();
        numList.insertLast(1);
        numList.insertLast(2);
        numList.insertLast(3);
        numList.insertLast(4);
        numList.insertLast(5);
        numList.insertLast(6);

        System.out.println("LIST BEFORE MIRROR");
        numList.printNodes();
        System.out.println("LIST AFTER MIRROR");
        numList.mirrorList(numList);
        numList.printNodes();
    }

    public AudSLLNode<E> getFirst() {
        return first;
    }
}