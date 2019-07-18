/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicationNode{
    class ListNode {
        int val;
        ListNode next = null;
    
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null){
            return null;
        }
        ListNode p = pHead;
        ListNode n = new ListNode(0);
        ListNode pre = n;
        n.next = pHead;
        boolean flag = false;
        while(p != null){
            ListNode q = p.next;
            if(q == null){
                break;
            }
            if(p.val == q.val){
                while(q != null && q.val == p.val){
                    q = p.next;
                }
                pre.next = q;
                p = q;
            }else{
                if(!flag){
                    n.next = p;
                    flag = true;
                }
                pre = p;
                p = q;
            }
        }
        return n.next;
    }

    /**
     * 思路：
     * 首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
     * 设置pre，last指针，pre指针指向当前确定不重复的那个节点，而last指针相当于工作节点一直向后搜索
     */
    public ListNode deleteDuplication2(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode Head = new ListNode(0);
        Head.next = pHead;
        ListNode pre = Head;
        ListNode last = Head.next;
        while(last != null){
            if(last.next != null && last.val == last.next.val){
                while (last.next!=null && last.val == last.next.val){
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            }else{
                pre = pre.next;
                last = last.next;
            }    
        }
        return Head.next;
    }
}