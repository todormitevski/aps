package OnlineCourse;

public class SinglyLinkedList {
    private ListNode head;
    private static class ListNode{
        private int data; //Generic Type
        private ListNode next;

        public ListNode(int data){ //mesto public:, tuka nema toa
            this.data=data;
            this.next=null;
        }
    }

    public void display(){ //the same print in main, but in a function
        ListNode current=head;
        while(current!=null){
            System.out.print(current.data + "-->");
            current=current.next;
        }
        System.out.println("null");
    }

    public int length(){
        if(head==null){
            return 0;
        }
        int count=0;
        ListNode current=head;
        while(current!=null){
            count++;
            current=current.next;
        }
        return count;
    }

    public void insertFirst(int value){
        ListNode newNode=new ListNode(value);
        newNode.next=head;
        head=newNode;
    }

    public void insertLast(int value){
        ListNode newNode=new ListNode(value);
        if(head==null){ //the LL is empty
            head=newNode;
            return;
        }
        ListNode current=head;
        while(null!=current.next){
            current=current.next;
        }
        current.next=newNode;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll=new SinglyLinkedList();
        sll.head=new ListNode(10); //glavata, so data 10
        ListNode second=new ListNode(1); //data 1
        ListNode third=new ListNode(8);
        ListNode fourth=new ListNode(11);

        //now connecting together
        sll.head.next=second; //10 --> 1
        second.next=third; //10 --> 1 --> 8
        third.next=fourth; //10 --> 1 --> 8 --> 11 --> null

        //print
        sll.display();
        //count
        System.out.println(sll.length());

        sll.insertFirst(6);
        sll.insertFirst(5);
        sll.insertFirst(4);

        sll.display();

        sll.insertLast(7);
        sll.insertLast(8);
        sll.insertLast(9);

        sll.display();

        //ListNode current=sll.head;
//        while(sll.head!=null){ //this way it takes less time/capacity
//            System.out.print(sll.head.data + "-->");
//            sll.head=sll.head.next;
//        }
//        System.out.println("null");
    }
}
