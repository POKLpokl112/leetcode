package code.one;

public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode ln = new ListNode(0);
		ListNode l3 = ln;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				ln.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				ln.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			ln = ln.next;
		}

		if (l1 == null && l2 != null) {
			ln.next = l2;
			return l3.next;
		} else if (l2 == null && l1 != null) {
			ln.next = l1;
			return l3.next;
		}

		return l3.next;
	}
}
