package OnlineCourse;

import java.util.Stack;

public class WorkingWithStacks { //last in first out (LIFO)
    public static void main(String[] args){
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek()); //gives elem at top of stack
        System.out.println(stack.size()); //golemina na stackot
        System.out.println(stack.pop());  //printa koj element go vadi
        System.out.println(stack.size()); //novata golemina
        System.out.println(stack.empty()); //if it's empty
    }
}
