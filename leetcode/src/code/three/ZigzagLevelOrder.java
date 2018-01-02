package code.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import code.two.TreeNode;

public class ZigzagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(final TreeNode root) {

		if (root == null) {
			return new ArrayList<>();
		}
		final List<List<Integer>> list = new ArrayList<>();

		final Stack<TreeNode> qwe = new Stack<>();
		qwe.add(root);
		boolean b = true;
		while (!qwe.isEmpty()) {
			final ArrayList<Integer> array = new ArrayList<>();
			final Stack<TreeNode> sss = new Stack<>();
			while (!qwe.isEmpty()) {
				final TreeNode treeNode = qwe.pop();
				if (b) {
					if (treeNode.left != null) {
						sss.add(treeNode.left);
					}

					if (treeNode.right != null) {
						sss.add(treeNode.right);
					}
				} else {
					if (treeNode.right != null) {
						sss.add(treeNode.right);
					}

					if (treeNode.left != null) {
						sss.add(treeNode.left);
					}

				}

				array.add(treeNode.val);
			}
			qwe.addAll(sss);
			b = !b;
			list.add(array);
		}

		return list;

	}
	
	public List<List<Integer>> retert(final TreeNode root) {

		if (root == null) {
			return new ArrayList<>();
		}
		final List<List<Integer>> list = new ArrayList<>();

		final Stack<TreeNode> qwe = new Stack<>();
		qwe.add(root);
		boolean b = true;
		while (!qwe.isEmpty()) {
			final ArrayList<Integer> array = new ArrayList<>();
			final Stack<TreeNode> sss = new Stack<>();
			while (!qwe.isEmpty()) {
				final TreeNode treeNode = qwe.pop();
				if (b) {
					if (treeNode.left != null) {
						sss.add(treeNode.left);
					}

					if (treeNode.right != null) {
						sss.add(treeNode.right);
					}
				} else {
					if (treeNode.right != null) {
						sss.add(treeNode.right);
					}

					if (treeNode.left != null) {
						sss.add(treeNode.left);
					}

				}

				array.add(treeNode.val);
			}
			qwe.addAll(sss);
			b = !b;
			list.add(array);
		}

		return list;

	}
}
