package OnlineCourse;

import java.util.NoSuchElementException;

public class Queue { //(FIFO)
    private ListNode front;
    private ListNode rear;
    private int length;

    public Queue(){
        this.front=null;
        this.rear=null;
        this.length=0;
    }

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public void enqueue(int data){
        ListNode temp=new ListNode(data);
        if(isEmpty()){
            front=temp;
        } else {
            rear.next=temp;
        }
        rear=temp;
        length++;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("OnlineCourse.Queue is empty!");
        }
        int result=front.data;
        front=front.next;
        if(front==null){
            rear=null;
        }
        length--;
        return result;
    }

    public void print(){
        if(isEmpty()){
            return;
        }
        ListNode current=front;
        while(current!=null){
            System.out.print(current.data + " --> ");
            current=current.next;
        }
        System.out.print("null");
    }

    public int first(){
        if(isEmpty()){
            throw new NoSuchElementException("OnlineCourse.Queue is empty!");
        }
        return front.data;
    }

    public int last(){
        if(isEmpty()){
            throw new NoSuchElementException("OnlineCourse.Queue is empty!");
        }
        return rear.data;
    }

    public static void main(String[] args){
        Queue queue=new Queue();
        queue.enqueue(10);
        queue.enqueue(12);
        queue.enqueue(15);
        queue.print();

        System.out.println();

        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue(); //throws the exception
        queue.print();

        System.out.println();
        System.out.println(queue.first());
        System.out.println(queue.last());
    }
}
