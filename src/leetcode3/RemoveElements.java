package leetcode3;

import leetcode.ListNode;

public class RemoveElements {

	public ListNode removeElements(ListNode head, int val) {
        //创建一个虚拟头结点
        ListNode dummyNode=new ListNode(val-1);
        dummyNode.next=head;
        ListNode prev=dummyNode;
        //确保当前结点后还有结点
        while(prev.next!=null){
            if(prev.next.val==val){
                prev.next=prev.next.next;
            }else{
                prev=prev.next;
            }
        }
        return dummyNode.next;
    }
}
