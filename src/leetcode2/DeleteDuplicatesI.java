package leetcode2;

import leetcode.ListNode;
import util.ListNodeUtil;

/**
 * 83. 删除排序链表中的重复元素I
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * @author stick
 *
 */
public class DeleteDuplicatesI {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.next.val == current.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		DeleteDuplicatesI test = new DeleteDuplicatesI();
		ListNode head = ListNodeUtil.arrayToListNode(new int[] { 1, 1, 1, 2, 3, 3, 4 });
		ListNodeUtil.printListNode(test.deleteDuplicates(head));
	}
}
