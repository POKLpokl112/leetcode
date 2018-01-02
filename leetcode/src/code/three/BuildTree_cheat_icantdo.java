package code.three;

import code.two.TreeNode;

//Given preorder and inorder traversal of a tree, construct the binary tree.
//
//Note:
//You may assume that duplicates do not exist in the tree.
//
//For example, given
//
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7]
//Return the following binary tree:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7

public class BuildTree_cheat_icantdo {
	public TreeNode buildTree(final int[] preorder, final int[] inorder) {
		return fffff(0, 0, inorder.length - 1, preorder, inorder);
	}

	public TreeNode fffff(final int i, final int j, final int k,
			final int[] preorder, final int[] inorder) {

		if (i > preorder.length - 1 || j > k) {
			return null;
		}

		final TreeNode node = new TreeNode(preorder[i]);

		int ii = 0;
		for (int l = j; l <= k; l++) {
			if (inorder[l] == node.val) {
				ii = l;
				break;
			}
		}

		node.left = fffff(i + 1, j, ii - 1, preorder, inorder);
		node.right = fffff(i + ii + 1 - j, ii + 1, k, preorder, inorder);
		return node;
	}
}
