package code.three;

import code.two.TreeNode;

//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//
//Example:
//
//Given the sorted linked list: [-10,-3,0,5,9],
//
//One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5

public class SortedListToBST_cheat_idiot {
	public TreeNode sortedListToBST(final ListNode head) {
		return qwe(head, null);
	}

	private TreeNode qwe(final ListNode head, final ListNode tail) {
		if (head == tail) {
			return null;
		}

		ListNode fast = head, slow = head;
		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}

		final TreeNode node = new TreeNode(slow.val);
		node.left = qwe(head, slow);
		node.right = qwe(slow, tail);
		return node;
	}
}
