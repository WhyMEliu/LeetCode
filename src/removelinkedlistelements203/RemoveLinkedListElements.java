package removelinkedlistelements203;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
    	
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
