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

	public ListNode partition2(ListNode head, int x) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode tail = dummy;
		ListNode find = head;
		ListNode find_follow = dummy;
		while (find != null) {
			if (find.val < x) {
				if (find == head || find_follow == tail) {// 用于处理两种特殊情况
					find_follow = find;
					find = find.next;
					tail = tail.next;
					continue;
				}
				ListNode tmp = tail.next;// 取下find节点放到tail后方
				find_follow.next = find.next;
				tail.next = find;
				find.next = tmp;

				tail = find;// 更新指针
				find = find_follow.next;
			} else {
				find_follow = find;
				find = find.next;
			}
		}
		return dummy.next;
	}

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
