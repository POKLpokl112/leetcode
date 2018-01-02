package code.two;

//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions.
//
//For example,
//Given 1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5.
/**
 *
 * @author libo
 * @date 2018年1月12日
 *
 */
public class Partition {
	/**
	 *
	 * @author libo
	 * @date 2018年1月12日 下午5:17:06
	 *
	 * @param head
	 * @param x
	 * @return
	 */
	public ListNode partition(final ListNode head, final int x) {

		ListNode node = new ListNode(0);
		final ListNode qwe = node;
		node.next = head;

		while (node.next != null) {
			if (node.next.val >= x) {
				break;
			}
			node = node.next;
		}
		if (node.next == null) {
			return head;
		}
		ListNode qq = node;

		node = node.next;

		while (node.next != null) {
			if (node.next.val < x) {
				final ListNode xx = node.next;
				node.next = node.next.next;
				xx.next = qq.next;
				qq.next = xx;
				qq = xx;
				continue;
			}

			node = node.next;
		}

		return qwe.next;
	}

	public static void main(final String[] args) {
		final ListNode ln = new ListNode(2);
		ln.next = new ListNode(1);
		new Partition().partition(ln, 2);
	}

	public ListNode doxx(final ListNode head, final ListNode xx) {
		if (head.val > xx.val) {
			xx.next = head;
			return xx;
		}
		ListNode node = head;
		while (true) {
			if (node.next.val > xx.val) {
				xx.next = node.next;
				node.next = xx;
				break;
			}
			node = node.next;
		}
		return head;
	}
}
