package removelinkedlistelements;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    /**
     * 链表节点构造函数
     * 使用arr为参数,创建一个链表，当前的listNode为链表的头节点
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
     * 以当前节点为头结点的链表信息字符串
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
