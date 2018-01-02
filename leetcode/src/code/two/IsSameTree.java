package code.two;

public class IsSameTree {
	public boolean isSameTree(final TreeNode p, final TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p != null && q != null && p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return false;
	}

}
