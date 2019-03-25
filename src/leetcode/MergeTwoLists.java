package leetcode;

/**
 * 21.合并两个有序链表 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 * 
 * @author stick
 *
 */
public class MergeTwoLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode curNode = new ListNode(0);
		ListNode headerBefore = curNode;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curNode.next = l1;
				l1 = l1.next;
				curNode = curNode.next;
			} else {
				curNode.next = l2;
				l2 = l2.next;
				curNode = curNode.next;
			}
		}
		if (l1 != null) {
			curNode.next = l1;
		} else {
			curNode.next = l2;
		}
		return headerBefore.next;
	}

	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode res = new ListNode(0);
		if (l1.val >= l2.val) {
			res = l2;
			res.next = mergeTwoLists(l1, l2.next);
		} else {
			res = l1;
			res.next = mergeTwoLists(l1.next, l2);
		}
		return res;
	}

	public static void main(String[] args) {
		MergeTwoLists test = new MergeTwoLists();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(5);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		a.next = b;
		c.next = d;
		RemoveNthFromEnd.printListNode(test.mergeTwoLists2(a, c));
	}

}
