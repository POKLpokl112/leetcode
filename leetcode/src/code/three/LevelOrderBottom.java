package code.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import code.two.TreeNode;

//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its bottom-up level order traversal as:
//[
//  [15,7],
//  [9,20],
//  [3]
//]

public class LevelOrderBottom {
	public List<List<Integer>> levelOrderBottom(final TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}

		final List<List<Integer>> list = new ArrayList<>();
		final Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);
		nodes.add(null);

		while (!nodes.isEmpty()) {
			final List<Integer> array = new ArrayList<>();
			while (!nodes.isEmpty()) {
				final TreeNode node = nodes.poll();
				if (node == null) {
					if (!nodes.isEmpty()) {
						nodes.add(null);
					}
					break;
				}

				array.add(node.val);

				if (node.left != null) {
					nodes.add(node);
				}

				if (node.right != null) {
					nodes.add(node);
				}
			}
			list.add(0, array);
		}

		return list;
	}
}
