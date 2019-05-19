package leetcode2;

import leetcode.ListNode;
import util.ListNodeUtil;

/**
 * 82. 删除排序链表中的重复元素II 
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 
 * @author stick
 *
 */
public class DeleteDuplicates {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode newhead = new ListNode(-1);
		ListNode tmp = newhead;

		while (head != null && head.next != null) {
			if (head.val == head.next.val) { // 遇到相同的元素，整段删除
				while (head.next != null && head.val == head.next.val) {
					head = head.next;
				}
				head = head.next;
			} else {
				tmp.next = head;
				tmp = tmp.next;
				head = head.next;

			}
		}
		tmp.next = head;
		return newhead.next;
	}

	public static void main(String[] args) {
		DeleteDuplicates test = new DeleteDuplicates();
		ListNode head = ListNodeUtil.arrayToListNode(new int[] { 1, 1, 1, 2, 3, 3, 4 });
		ListNodeUtil.printListNode(test.deleteDuplicates(head));
	}
}
