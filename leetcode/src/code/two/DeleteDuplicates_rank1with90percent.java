package code.two;

//
//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
//For example,
//Given 1->2->3->3->4->4->5, return 1->2->5.
//Given 1->1->1->2->3, return 2->3.

public class DeleteDuplicates_rank1with90percent {
	public ListNode deleteDuplicates1(final ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode pre = new ListNode(head.val);
		pre.next = head;

		final ListNode node = new ListNode(0);
		node.next = head;

		final ListNode ln = pre;

		boolean b = false;
		while (node.next.next != null) {
			if (pre.next.val == node.next.next.val) {
				b = true;
			} else {
				if (b) {
					pre.next = node.next.next;
					b = false;
				} else {
					pre = pre.next;
				}

			}
			node.next = node.next.next;
		}

		if (b) {
			pre.next = node.next.next;
		}
		return ln.next;
	}

	public static void main(final String[] args) {
		final ListNode l = new ListNode(1);
		l.next = new ListNode(1);
		new DeleteDuplicates_rank1with90percent().deleteDuplicates1(l);
	}
}
