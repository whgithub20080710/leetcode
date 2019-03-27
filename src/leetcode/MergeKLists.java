package leetcode;

/**
 * 23.合并k个排序链表 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入: [ 1->4->5, 1->3->4, 2->6 ] 输出: 1->1->2->3->4->4->5->6
 * 
 * @author stick
 *
 */
public class MergeKLists {

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode beforeResult = new ListNode(0);
		ListNode cur = beforeResult;
		int clearNode = 0;
		while (clearNode != lists.length) {
			Integer min = null;
			int minIndex = -1;
			for(int i = 0;i < lists.length;i++){
				if(lists[i] != null){
					if(minIndex == -1) minIndex = i;
					if(min == null){
						min = lists[i].val;
					}else{
						if(lists[i].val < min){
							min = lists[i].val;
							minIndex = i;
						}
					}
				}
			}
			if(minIndex == -1 || lists[minIndex] == null){
				clearNode++;
				continue;
			}
			cur.next = lists[minIndex];
			lists[minIndex] = lists[minIndex].next;
			if(lists[minIndex] == null){
				clearNode++;
			}
			cur = cur.next;
			
		}
		return beforeResult.next;
	}
	
	public static void main(String[] args) {
		MergeKLists test = new MergeKLists();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(5);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(6);
		a.next = b;
		c.next = d;
		ListNode[] aa = new ListNode[2];
		aa[0] = a;
		aa[1] = c;
		RemoveNthFromEnd.printListNode(test.mergeKLists(aa));
	}

}
