package code.one;

//cheat thinking is two score
public class MergeKLists_No {
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode ln = null;

		for (ListNode listNode : lists) {
			if (ln == null) {
				ln = listNode;
			} else
				ln = mergeTwoLists(ln, listNode);
		}

		return ln;
    }

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

	public ListNode mergeKLists2(ListNode[] lists) {
		ListNode ln = null;

		for (ListNode listNode : lists) {
			if (ln == null) {
				ln = listNode;
			} else
				ln = mergeTwoLists(ln, listNode);
		}

		return ln;
	}

	private ListNode rrrr(ListNode[] list, int start, int end) {
		if (start == end) {
			return list[start];
		}

		if (end > start) {
			int half = (start + end) / 2;
			ListNode l1 = rrrr(list, start, half);
			ListNode l2 = rrrr(list, half + 1, end);
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
		} else {
			return null;
		}

	}
}
