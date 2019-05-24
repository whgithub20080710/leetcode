package leetcode2;

import leetcode.ListNode;
import util.ListNodeUtil;

/**
 * 86. 分隔链表 
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 
 * @author stick
 *
 */
public class ListNodePartition {

	public ListNode partition(ListNode head, int x) {
		ListNode dummyHead1 = new ListNode(0);
		ListNode dummyHead2 = new ListNode(0);
		ListNode node1 = dummyHead1;
		ListNode node2 = dummyHead2;
		while (head != null) {
			if (head.val < x) {
				node1.next = head;
				head = head.next;
				node1 = node1.next;
				node1.next = null;
			} else {
				node2.next = head;
				head = head.next;
				node2 = node2.next;
				node2.next = null;
			}
		}
		node1.next = dummyHead2.next;
		return dummyHead1.next;
	}

	public static void main(String[] args) {
		ListNodePartition test = new ListNodePartition();
		ListNode head = ListNodeUtil.arrayToListNode(new int[] { 1, 4, 3, 2, 5, 2 });
		ListNodeUtil.printListNode(test.partition(head, 3));
	}
}
