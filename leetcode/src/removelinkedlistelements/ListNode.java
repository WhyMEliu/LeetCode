package removelinkedlistelements;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    /**
     * ����ڵ㹹�캯��
     * ʹ��arrΪ����,����һ��������ǰ��listNodeΪ�����ͷ�ڵ�
     * @param arr
     */
    public ListNode (int[] arr){
        if (arr==null || arr.length==0){
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    /**
     * �Ե�ǰ�ڵ�Ϊͷ����������Ϣ�ַ���
     * @return
     */
    @Override
    public String toString (){
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur!=null){
            res.append(cur.val+"->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }
}
