package code.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import code.two.TreeNode;

//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its level order traversal as:
//[
//  [3],
//  [9,20],
//  [15,7]
//]

public class LevelOrder_fix_speedup_twice {
	public List<List<Integer>> levelOrder(final TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		final List<List<Integer>> list = new ArrayList<>();

		final Queue<TreeNode> qwe = new LinkedList<>();
		qwe.add(root);
		qwe.add(null);
		while (!qwe.isEmpty()) {
			final ArrayList<Integer> array = new ArrayList<>();
			while (!qwe.isEmpty()) {
				final TreeNode treeNode = qwe.poll();
				if (treeNode == null) {
					if (!qwe.isEmpty()) {
						qwe.add(null);
					}
					break;
				}
				if (treeNode.left != null) {
					qwe.add(treeNode.left);
				}

				if (treeNode.right != null) {
					qwe.add(treeNode.right);
				}

				array.add(treeNode.val);
			}
			list.add(array);
		}

		return list;
	}

	public static void main(final String[] args) {
		final TreeNode node = new TreeNode(6);
		node.left = new TreeNode(3);
		node.right = new TreeNode(8);
		node.right.left = new TreeNode(7);
		node.right.right = new TreeNode(9);
		new LevelOrder_fix_speedup_twice().levelOrder(node);
	}

}
