package code.three;

import code.two.TreeNode;

//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//But the following [1,2,2,null,3,null,3] is not:
//    1
//   / \
//  2   2
//   \   \
//   3    3
//Note:
//Bonus points if you could solve it both recursively and iteratively.

public class IsSymmetric {
	public boolean isSymmetric(final TreeNode root) {
		return qqq(root.left, root.right);
	}

	public boolean qqq(final TreeNode left, final TreeNode right) {
		if (left == null && right == null) {
			return true;
		}

		else if (left != null && right != null && left.val == right.val) {
			return qqq(left.left, right.right) && qqq(left.right, right.left);
		}
		return false;
	}

}
