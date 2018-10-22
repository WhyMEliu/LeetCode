package removelinkedlistelements;

/*ɾ�������е��ڸ���ֵ val �����нڵ㡣

        ʾ��:

        ����: 1->2->6->3->4->5->6, val = 6
        ���: 1->2->3->4->5*/

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        //����ͷ�����Ƿ�Ϊ��Ҫɾ���Ķ���
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
