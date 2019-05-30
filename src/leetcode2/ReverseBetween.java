package leetcode2;

import leetcode.ListNode;
import util.ListNodeUtil;

/**
 * 92. 反转链表 
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 
 * @author stick
 *
 */
public class ReverseBetween {

	/**
	 * 理一下思路：先设置一个头节点，来确保一些边界情况能够满足
	 * 由于只能遍历一次，所以需要一个count位来指示从哪一位开始翻转，哪一位停止翻转，并且要连成一个完整的链表
	 * 由于采用迭代法完成基础链表翻转的最后标志是curr指针指向头节点的下一位，所以利用他来完成一些功能
	 * 
	 * @param head
	 *            链表头结点
	 * @param m
	 *            翻转开始位置
	 * @param n
	 *            翻转截止位置
	 * @return 翻转后的链表头结点
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dumpyhead = new ListNode(0);
		dumpyhead.next = head;
		ListNode cur, curr, curr1, left, right, prev, temp;
		cur = dumpyhead;
		int count = 0;
		while (count < m - 1) {
			count++;
			cur = cur.next;

		}
		left = cur;
		count++;
		curr = cur.next;
		curr1 = curr;
		prev = null;
		while (curr != null && count <= n) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			count++;
		}
		right = curr;
		left.next = prev;
		curr1.next = right;
		return dumpyhead.next;
	}

	public static void main(String[] args) {
		ReverseBetween test = new ReverseBetween();
		ListNodeUtil.printListNode(
				test.reverseBetween(ListNodeUtil.arrayToListNode(new int[] { 1, 2, 3, 4, 5, 6, 7 }), 2, 5));
	}

}
