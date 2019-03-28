package leetcode;

/**
 * 24. 两两交换链表中的节点 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 示例:
 * 
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 
 * @author stick
 *
 */
public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		head.next = swapPairs(next.next);
		next.next = head;
		return next;
	}

	public ListNode swapPairs2(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		while (pre.next != null && pre.next.next != null) {
			ListNode node1 = pre.next;
			ListNode node2 = node1.next;
			ListNode next = node2.next;
			node2.next = node1;
			node1.next = next;
			pre.next = node2;
			pre = node1;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		SwapPairs test = new SwapPairs();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		c.next = d;
		b.next = c;
		a.next = b;
		RemoveNthFromEnd.printListNode(test.swapPairs2(a));
	}
}
