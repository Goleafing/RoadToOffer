/**
 * 输入一个链表，输出该链表中倒数第k个结点
 */

public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        //--首先判断链表是否为空，链表为空没有意义
        if(head == null) {
            return null;
        }
        //--首先判断输入的K的值的有效性。当K为非正整数时无意义
        if(k <= 0) {
            return null;
        }
        ListNode list = head;
        //--按照最初始的状态，不知道具体有多少个节点，需要能够计算出节点的个数
        int count = 0;
        while(list != null) {
            count += 1;
            list = list.next;
        }

        //--需要判断K的大小与链表的总结点之间的关系。当K大于链表结点总数时，没有意义
        if(count < k) {
            return null;
        }

        //--如何找到所要的倒数第k个结点，不是数组，不能通过角标，可以通过for循环
        ListNode p = head;
        for(int i = 0; i < count - k; i++) {
            p = p.next;
        }
        return p;
    }
}