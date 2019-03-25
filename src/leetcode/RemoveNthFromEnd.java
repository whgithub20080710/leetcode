package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author stick
 * 
 *         19.删除链表的倒数第N个节点 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 *         示例：
 * 
 *         给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 
 *         当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class RemoveNthFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		List<ListNode> list = new ArrayList<>();
		listNodeList(head, list);
		if (list.size() == 1) {
			return null;
		}
		if (list.size() - n + 1 == list.size()) {
			list.get(list.size() - n - 1).next = null;
		} else if (list.size() == n) {
			return list.get(1);
		} else {
			list.get(list.size() - n - 1).next = list.get(list.size() - n + 1);
		}

		return head;
	}

	private void listNodeList(ListNode node, List<ListNode> list) {
		list.add(node);
		if (node.next != null) {
			listNodeList(node.next, list);
		} else {
			return;
		}
	}

	public static void printListNode(ListNode node) {
		System.out.println(node.val);
		if (node.next != null) {
			printListNode(node.next);
		} else {
			return;
		}
	}

	// 官方解答
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		// Advances first pointer so that the gap between first and second is n
		// nodes apart
		int i = 1;
		// Move first to the end, maintaining the gap
		while (first != null) {
			if (i <= n + 1) {
				first = first.next;
				i++;
			} else {
				first = first.next;
				second = second.next;
			}
		}
		second.next = second.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		c.next = d;
		b.next = c;
		a.next = b;
		RemoveNthFromEnd test = new RemoveNthFromEnd();
		ListNode r = test.removeNthFromEnd2(a, 2);
		test.printListNode(r);
		System.out.println("end");
	}
}
