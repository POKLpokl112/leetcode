package code.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Given a binary tree, return the inorder traversal of its nodes' values.
//
//For example:
//Given binary tree [1,null,2,3],
// 1
//  \
//   2
//  /
// 3
//return [1,3,2].
//
//Note: Recursive solution is trivial, could you do it iteratively?

public class InorderTraversal_cheater {
	public List<Integer> inorderTraversal(final TreeNode root) {
		final List<Integer> list = new ArrayList<>();
		final Stack<TreeNode> stack = new Stack<>();

		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}

			final TreeNode tn = stack.pop();
			list.add(tn.val);
			cur = tn.right;
		}

		return list;
	}
}
