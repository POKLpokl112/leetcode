package code.three;

import code.two.TreeNode;

//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

public class Mindepth {
	public int minDepth(final TreeNode root) {
		if (root == null) {
			return 0;
		}
		final int left = minDepth(root.left);
		final int right = minDepth(root.right);
		return left == 0 || right == 0
				? (left + right + 1)
				: Math.min(left, right) + 1;

	}

}
