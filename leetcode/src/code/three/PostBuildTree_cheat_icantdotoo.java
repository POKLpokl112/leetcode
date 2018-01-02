package code.three;

import code.two.TreeNode;

//Given inorder and postorder traversal of a tree, construct the binary tree.
//
//Note:
//You may assume that duplicates do not exist in the tree.
//
//For example, given
//
//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3]
//Return the following binary tree:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7

public class PostBuildTree_cheat_icantdotoo {
	public TreeNode buildTree(final int[] inorder, final int[] postorder) {
		return rrrr(0, postorder.length - 1, 0, inorder.length - 1, inorder,
				postorder);
	}

	private TreeNode rrrr(final int m, final int i, final int j, final int k,
			final int[] inorder, final int[] postorder) {
		if (m > i || j > k) {
			return null;
		}

		final TreeNode node = new TreeNode(postorder[i]);
		int ii = 0;
		for (int l = j; l < k + 1; l++) {
			if (node.val == inorder[l]) {
				ii = l;
				break;
			}
		}

		node.left = rrrr(m, m + ii - 1 - j, j, ii-1, inorder, postorder);
		node.right = rrrr(m + ii - j, i - 1, ii+1, k, inorder, postorder);
		return node;
	}
}
