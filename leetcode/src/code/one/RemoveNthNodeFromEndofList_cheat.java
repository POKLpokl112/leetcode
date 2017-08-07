package code.one;

public class RemoveNthNodeFromEndofList_cheat {

	public ListNode removeNthNodeFromEndofList(ListNode head, int n) {
		ListNode first = new ListNode(0);
		first.next=head;
		int length = 1;
		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
			length++;
		}

		int i = length - n ;
		temp = first;
		while (i > 0) {
			temp = temp.next;
			i--;
		}
		temp.next = temp.next.next;
		return first.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
	}
}
