package removelinkedlistelements;

/*ɾ�������е��ڸ���ֵ val �����нڵ㡣

        ʾ��:

        ����: 1->2->6->3->4->5->6, val = 6
        ���: 1->2->3->4->5*/

/**
 * ����ͷ�ڵ����
 */
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

    public static void main (String[] args){
        int [] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res = (new RemoveLinkedListElements2()).removeElements(head,6);
        System.out.println(res);
    }

}