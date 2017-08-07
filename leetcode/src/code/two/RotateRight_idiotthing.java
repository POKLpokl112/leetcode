package code.two;

//Given a list, rotate the list to the right by k places, where k is non-negative.
//
//For example:
//Given 1->2->3->4->5->NULL and k = 2,
//return 4->5->1->2->3->NULL.
public class RotateRight_idiotthing {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0) {
			return head;
		}
		ListNode tail = head;
		int i = 1;
		while (tail.next != null) {
			tail = tail.next;
			i++;
		}

		int n = i - k - 1;
		ListNode node = head;
		while (n > 0) {
			node = node.next;
			n--;
		}

		if (node.next == null) {
			return head;
		}
		ListNode q = node.next;
		node.next = null;
		tail.next = head;

		return q;
	}
}

class ListNode {
	ListNode next;
	int val;

	public ListNode(int x) {
		val = x;
	}
}
