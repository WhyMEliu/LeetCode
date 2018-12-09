package removelinkedlistelements;

/*删除链表中等于给定值 val 的所有节点。

        示例:

        输入: 1->2->6->3->4->5->6, val = 6
        输出: 1->2->3->4->5*/

/**
 * 虚拟头节点解题
 */
public class RemoveLinkedListElements2 {

    public ListNode removeElements(ListNode head, int val) {
        //用虚拟节点进行数据操作（简化代码）
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next=head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if(prev.next.val==val){
                prev.next=prev.next.next;
            }else{
                prev=prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main (String[] args){
        int [] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res = (new RemoveLinkedListElements2()).removeElements(head,6);
        System.out.println(res);
    }

}
