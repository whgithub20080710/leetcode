package leetcode2;

import leetcode.ListNode;

/**
 * 61.旋转链表 
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 
 * @author stick
 *
 */
public class RotateRight {

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0) {
			return head;
		}
		ListNode cursor = head;
		ListNode tail = null;// 尾指针
		int length = 1;
		while (cursor.next != null)// 循环 得到总长度
		{
			cursor = cursor.next;
			length++;
		}
		int loop = length - (k % length);// 得到循环的次数
		tail = cursor;// 指向尾结点
		cursor.next = head;// 改成循环链表
		cursor = head;// 指向头结点
		for (int i = 0; i < loop; i++) {// 开始循环
			cursor = cursor.next;
			tail = tail.next;
		}
		tail.next = null;// 改成单链表
		return cursor;// 返回当前头
	}

	public static void main(String[] args) {
		RotateRight test = new RotateRight();
		System.out.println(test.rotateRight(new ListNode(1), 1));
	}
}
