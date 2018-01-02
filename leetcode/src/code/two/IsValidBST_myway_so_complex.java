package code.two;

//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
//Example 1:
//    2
//   / \
//  1   3
//Binary tree [2,1,3], return true.
//Example 2:
//    1
//   / \
//  2   3
//Binary tree [1,2,3], return false.
public class IsValidBST_myway_so_complex {
	public boolean isValidBST(final TreeNode root) {
		if (root == null) {
			return true;
		}

		return isValidRight(root, null) && isValidLeft(root, null);
	}

	private boolean isValidLeft(final TreeNode root, final TreeNode right) {
		if (root.left == null) {
			return true;
		}

		if (root.val > root.left.val) {
			if (right != null && root.left.val <= right.val) {
				return false;
			}

			return isValidLeft(root.left, right)
					&& isValidRight(root.left, root);
		}

		return false;
	}

	private boolean isValidRight(final TreeNode root, final TreeNode left) {
		if (root.right == null) {
			return true;
		}

		if (root.val < root.right.val) {
			if (left != null && root.right.val >= left.val) {
				return false;
			}

			return isValidLeft(root.right, root)
					&& isValidRight(root.right, left);
		}

		return false;
	}

	// private boolean isValidLeft(final TreeNode root, final TreeNode left) {
	// if (left == null) {
	// return true;
	// }
	//
	// if (root.val > left.val) {
	// if (left.right != null && left.right.val >= root.val) {
	// return false;
	// }
	//
	// return isValidLeft(left, left.left)
	// && isValidRight(left, left.right);
	// }
	//
	// return false;
	// }
	//
	// private boolean isValidRight(final TreeNode root, final TreeNode right) {
	// if (right == null) {
	// return true;
	// }
	//
	// if (root.val < right.val) {
	// if (right.left != null && right.left.val <= root.val) {
	// return false;
	// }
	//
	// return isValidLeft(right, right.left)
	// && isValidRight(right, right.right);
	// }
	//
	// return false;
	// }

}
