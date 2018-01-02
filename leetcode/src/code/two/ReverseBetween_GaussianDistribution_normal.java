package code.two;

//Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
//return 1->4->3->2->5->NULL.
//
//Note:
//Given m, n satisfy the following condition:
//1 ≤ m ≤ n ≤ length of list.
public class ReverseBetween_GaussianDistribution_normal {
	public ListNode reverseBetween(final ListNode head, int m, int n) {
		if (m == n) {
			return head;
		}
		final ListNode l0 = new ListNode(0);
		l0.next = head;

		ListNode l1 = l0;
		while (m != 1) {
			l1 = l1.next;
			m--;
			n--;
		}
		final ListNode l2 = l1;

		while (n != 0) {
			l1 = l1.next;
			n--;
		}
		final ListNode l3 = l2.next;
		final ListNode l4 = l1.next;
		dododo(l3, l1);
		l2.next = l1;
		l3.next = l4;
		return l0.next;

	}

	private void dododo(ListNode l1, final ListNode l2) {
		ListNode l3 = l1.next;

		ListNode l4 = l3.next;
		l3.next = l1;
		l1 = l3;
		l3 = l4;
		while (l1 != l2) {
			l4 = l3.next;
			l3.next = l1;
			l1 = l3;
			l3 = l4;
		}
	}

}
