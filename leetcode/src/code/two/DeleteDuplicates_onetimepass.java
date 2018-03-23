package code.two;

//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//For example,
//Given 1->1->2, return 1->2.
//Given 1->1->2->3->3, return 1->2->3.
public class DeleteDuplicates_onetimepass {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		final ListNode node = head;

		while (head.next != null) {
			if (head.val == head.next.val) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}

		return node;
	}
}
