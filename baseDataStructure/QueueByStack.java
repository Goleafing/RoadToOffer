package baseDataStructure;

import java.util.Stack;

/**
 * @author leaf
 * @date 2019-9-1 9:15
 */
public class QueueByStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop(){
        if(stack1.empty() && stack2.empty()){
            System.out.println("Queue is empty!");
        }
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
