package code.one;

public class ReverseKGroup_cheat_fuckoff {
	 public ListNode reverseKGroup(ListNode head, int k) {
		ListNode ln = head;
		int i = 0;
		while (ln != null && i != k) {
			ln = ln.next;
			i++;
		}

		if (i == k) {
			ln = reverseKGroup(ln, k);

			while (i > 0) {
				i--;
				ListNode temp = head.next;
				head.next = ln;
				ln = head;
				head = temp;
			}
			head = ln;
		}
		return head;
	}
}
