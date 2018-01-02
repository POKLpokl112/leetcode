package code.three;

import code.two.TreeNode;

//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//
//Example:
//
//Given the sorted array: [-10,-3,0,5,9],
//
//One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
public class SortedArrayToBST_cheat_shallowidea {
	public TreeNode sortedArrayToBST(final int[] nums) {

		return qwe(nums, 0, nums.length - 1);

	}

	public TreeNode qwe(final int[] nums, final int i, final int j) {
		if (i > j) {
			return null;
		}

		final int mid = i + (j - i) / 2;

		final TreeNode node = new TreeNode(nums[mid]);
		node.left = qwe(nums, i, mid - 1);
		node.right = qwe(nums, mid + 1, j);
		return node;

	}

}
