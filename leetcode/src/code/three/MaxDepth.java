package code.three;

import code.two.TreeNode;

//Given a binary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its depth = 3.

public class MaxDepth {

	public int maxDepth(final TreeNode root) {

		return qweqwe(root, 0);
	}

	public int qweqwe(final TreeNode node, int i) {

		if (node == null) {
			return i;
		}

		i++;

		final int k = qweqwe(node.left, i);
		final int q = qweqwe(node.right, i);
		return k > q ? k : q;

	}
}
