package leetcode;

public class ListNodeSum {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int i1 = listToNum(l1);
		int i2 = listToNum(l2);
		int i3 = i1 + i2;
		ListNode result = intToListNode(i3);
		return result;
	}

	static int listToNum(ListNode l1) {
		String listNodeStr = listNodeToStr(l1);
		return Integer.parseInt(listNodeStr);
	}

	static String listNodeToStr(ListNode l1) {
		String result = "";
		if (l1.next == null) {
			result = result + l1.val;
		} else {
			listNodeToStr(l1);
		}
		return result;
	}

	static ListNode intToListNode(int param) {
		int[] s = new int[10];
		ListNode lastNode = new ListNode(s[0]);
		for (int i = 1; i < s.length; i++) {
			ListNode l = buildListNode(lastNode, s[i]);

		}
		return null;
	}

	static ListNode buildListNode(ListNode l, int p) {
		ListNode r = new ListNode(p);
		r.next = l;
		return r;
	}
}
