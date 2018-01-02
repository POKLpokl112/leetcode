package code.two;

import java.util.ArrayList;
import java.util.List;

//Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//
//For example,
//Given n = 3, your program should return all 5 unique BST's shown below.
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
public class GenerateTrees_fucker_icant {
	public List<TreeNode> generateTrees(final int n) {
		return gogogo(1, n);
	}

	private List<TreeNode> gogogo(final int i, final int n) {
		final List<TreeNode> list = new ArrayList<>();
		if (i > n) {
			list.add(null);
			return list;
		}

		if (i == n) {
			list.add(new TreeNode(i));
			return list;
		}

		List<TreeNode> left, right;
		for (int j = i; j <= n; j++) {
			left = gogogo(i, j - 1);
			right = gogogo(j + 1, n);
			for (final TreeNode tl : left) {
				for (final TreeNode tr : right) {
					final TreeNode ln = new TreeNode(j);
					ln.left = tl;
					ln.right = tr;
					list.add(ln);

				}
			}
		}

		return list;
	}

	public static void main(final String[] args) {
		new GenerateTrees_fucker_icant().generateTrees(0);
	}
}

// public List<TreeNode> genTrees (int start, int end)
// {
//
// List<TreeNode> list = new ArrayList<TreeNode>();
//
// if(start>end)
// {
// list.add(null);
// return list;
// }
//
// if(start == end){
// list.add(new TreeNode(start));
// return list;
// }
//
// List<TreeNode> left,right;
// for(int i=start;i<=end;i++)
// {
//
// left = genTrees(start, i-1);
// right = genTrees(i+1,end);
//
// for(TreeNode lnode: left)
// {
// for(TreeNode rnode: right)
// {
// TreeNode root = new TreeNode(i);
// root.left = lnode;
// root.right = rnode;
// list.add(root);
// }
// }
//
// }
//
// return list;
// }
