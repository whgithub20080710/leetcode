package leetcode3;

import leetcode.ListNode;
import util.ListNodeUtil;

/**
 * 203. 移除链表元素
 * 
 * @author stick
 *
 */
public class RemoveElements {

	public ListNode removeElements(ListNode head, int val) {
		// 创建一个虚拟头结点
		ListNode dummyNode = new ListNode(val - 1);
		dummyNode.next = head;
		ListNode prev = dummyNode;
		// 确保当前结点后还有结点
		while (prev.next != null) {
			if (prev.next.val == val) {
				prev.next = prev.next.next;
			} else {
				prev = prev.next;
			}
		}
		return dummyNode.next;
	}

	public static void main(String[] args) {
		RemoveElements test = new RemoveElements();
		ListNode head = ListNodeUtil.arrayToListNode(new int[] { 1, 2, 3, 2, 6, 2 });
		test.removeElements(head, 2);
		ListNodeUtil.printListNode(head);
	}
}
