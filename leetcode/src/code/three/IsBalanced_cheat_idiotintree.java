package code.three;

import code.two.TreeNode;

//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as:
//
//a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//Example 1:
//
//Given the following tree [3,9,20,null,null,15,7]:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//Return true.
//
//Example 2:
//
//Given the following tree [1,2,2,3,3,null,null,4,4]:
//
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//Return false.
public class IsBalanced_cheat_idiotintree {
	public boolean isBalanced(final TreeNode root) {
		return dfdfdf(root) == -1;
	}

	private int dfdfdf(final TreeNode root) {
		if (root == null) {
			return 0;
		}

		final int left = dfdfdf(root.left);
		if (left == -1) {
			return -1;
		}

		final int right = dfdfdf(root.right);
		if (right == -1) {
			return -1;
		}

		if (Math.abs(left - right) > 1) {
			return -1;
		}

		return Math.max(left, right) + 1;
	}
}
