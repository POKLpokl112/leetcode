package code.one;


//Given a linked list, swap every two adjacent nodes and return its head.
//
//For example,
//Given 1->2->3->4, you should return the list as 2->1->4->3.
//
//Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
public class SwapPairs {

	 public ListNode swapPairs(ListNode head) {
		ListNode ln = new ListNode(0);
		ListNode asd = ln;
		ln.next = head;
		int i = 0;
		while (head != null) {
			if (head.next != null && i % 2 == 0) {
				ln.next = head.next;
				ListNode node = head.next.next;
				head.next.next = head;
				head.next = node;

				ln = ln.next;
				i++;
			} else {
				ln = ln.next;
				head = head.next;
				i++;
			}
		}
		return asd.next;
	  }

}
