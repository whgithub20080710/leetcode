package leetcode3;

import leetcode.ListNode;
import util.ListNodeUtil;

public class ReverseList {

	public ListNode reverseList1(ListNode head) {
	    ListNode prev = null;
	    ListNode curr = head;
	    while (curr != null) {
	        ListNode nextTemp = curr.next;
	        curr.next = prev;
	        prev = curr;
	        curr = nextTemp;
	    }
	    return prev;
	}
	
	public static void main(String[] args) {
		ReverseList test = new ReverseList();
		ListNode head = ListNodeUtil.arrayToListNode(new int[] { 1, 2, 3, 2, 6, 2 });
		test.reverseList1(head);
		ListNodeUtil.printListNode(head);
	}
}
