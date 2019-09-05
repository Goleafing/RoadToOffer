package baseDataStructure;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author leaf
 * @date 2019-8-31 10:43
 */

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */

public class ListFromTailToHead {

    class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    private static ArrayList<Integer> listMethodCore(ListNode listNode){
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> tempStack = new Stack<>();
        while (listNode != null){
            tempStack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!tempStack.isEmpty()){
            result.add(tempStack.pop());
        }
        return result;
    }
}
