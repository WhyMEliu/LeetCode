package removelinkedlistelements;

/*ɾ�������е��ڸ���ֵ val �����нڵ㡣

        ʾ��:

        ����: 1->2->6->3->4->5->6, val = 6
        ���: 1->2->3->4->5*/


public class RemoveLinkedListElements2 {

    public ListNode removeElements(ListNode head, int val) {
        //������ڵ�������ݲ������򻯴��룩
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

}
