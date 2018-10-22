package removelinkedlistelements;

/*删除链表中等于给定值 val 的所有节点。

        示例:

        输入: 1->2->6->3->4->5->6, val = 6
        输出: 1->2->3->4->5*/

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        //链表头数据是否为需要删除的对象
        while (head!=null && head.val==val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head==null){
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if(prev.next.val==val){
                ListNode delNode = prev.next;
                prev.next=delNode.next;
                delNode.next=null;
            }else{
                prev=prev.next;
            }
        }
        return head;
    }
}
