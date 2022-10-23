package vezbi;

public class SLL {
    private SLLNode first;

    public SLL() {
        this.first = null;
    }

    public void printNodes(){
        System.out.println("The nodes are: ");
        for (SLLNode tmp=first;tmp!=null;tmp=tmp.succ){
            if(tmp.succ==null){
                System.out.println(tmp.element);
                break;
            }
            System.out.print(tmp.element + " -> ");
        }
        System.out.println();
    }

    public void insertFirst(Object o){
        SLLNode nov=new SLLNode(o, null);
        nov.succ=first;
        first=nov;
    }

    public void insertLast(Object o){
        if (first!=null) {
            SLLNode last=new SLLNode(o,null);
            SLLNode tmp=first;
            while(tmp.succ!=null){
                tmp=tmp.succ;
            }
            tmp.succ=last;
        } else{
            insertFirst(o);
        }
    }

    public void insert(Object o, SLLNode posle) {
        // Ash->Androxus
        //  Ash - Asim - Androxus
        // Asim->null
        // Asim -> Androxus
        // Ash -> Asim
        SLLNode ins = new SLLNode(o, null);
        if(posle == null) {
            ins.succ = first;
            first = ins;
        } else {
            ins.succ = posle.succ;
            posle.succ = ins;
        }
    }

    public SLLNode find(Object o){
        for(SLLNode curr=first; curr!=null; curr=curr.succ){
            if(o.equals(curr.element)){
                return curr;
            }
        }
        return null;
    }

    public int size(){
        int num=0;
        for(SLLNode curr=first; curr!=null;curr=curr.succ){
            num++;
        }
        return num;
    }

    public static void main(String[] args) {
        SLL leagueChamps=new SLL();
//        SLLNode vtoro=new SLLNode("Katarina", new SLLNode("Pyke", null));
//        SLLNode prvo=new SLLNode("Jhin", null);
        leagueChamps.insertFirst("Pyke");
        leagueChamps.insertFirst("Asim");
        leagueChamps.insertFirst("Kai'Sa");
        leagueChamps.insertFirst("K'Sante");
        leagueChamps.printNodes();

        SLLNode ins=leagueChamps.find("Asim");
        leagueChamps.insert("Androxus", ins);

        leagueChamps.printNodes();

        System.out.println("SIZE() TESTING");
        System.out.println(leagueChamps.size());

        System.out.println("TESTING INSERT LAST");
        leagueChamps.insertLast("Risot");
        leagueChamps.printNodes();
    }
}
