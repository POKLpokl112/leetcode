package code.two;

//Two elements of a binary search tree (BST) are swapped by mistake.
//
//Recover the tree without changing its structure.
//
//Note:
//A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
public class RecoverTree_cheat_morrisalgo {
	public void recoverTree(final TreeNode root) {
		TreeNode cur = root, prev = null, first = null, second = null,
				temp = null;
		while (cur != null) {
			if (cur.left == null) {
				if (temp != null && temp.val > cur.val) {
					if (first == null) {
						first = temp;
					}
					second = cur;
				}
				temp = cur;

				System.out.println(cur.val);
				cur = cur.right;
			} else {
				prev = cur.left;
				while (prev.right != null && prev.right != cur) {
					prev = prev.right;
				}

				if (prev.right == null) {
					prev.right = cur;
					cur = cur.left;
				} else {
					if (temp != null && temp.val > cur.val) {
						if (first == null) {
							first = temp;
						}
						second = cur;
					}
					temp = cur;

					System.out.println(cur.val);
					prev.right = null;
					cur = cur.right;
				}
			}
		}

		final int i = first.val;
		first.val = second.val;
		second.val = i;

		// TreeNode *cur = root, *prev = NULL;
		// 3 while (cur != NULL)
		// 4 {
		// 5 if (cur->left == NULL) // 1.
		// 6 {
		// 7 printf("%d ", cur->val);
		// 8 cur = cur->right;
		// 9 }
		// 10 else
		// 11 {
		// 12 // find predecessor
		// 13 prev = cur->left;
		// 14 while (prev->right != NULL && prev->right != cur)
		// 15 prev = prev->right;
		// 16
		// 17 if (prev->right == NULL) // 2.a)
		// 18 {
		// 19 prev->right = cur;
		// 20 cur = cur->left;
		// 21 }
		// 22 else // 2.b)
		// 23 {
		// 24 prev->right = NULL;
		// 25 printf("%d ", cur->val);
		// 26 cur = cur->right;
		// 27 }
		// 28 }
		// 29 }

	}

	public static void main(final String[] args) {
		final TreeNode t = new TreeNode(0);
		t.left = new TreeNode(1);
		// t.right = new TreeNode(11);
		// t.right.right = new TreeNode(12);
		// t.left.left = new TreeNode(5);
		// t.left.right = new TreeNode(9);
		// t.left.right.left = new TreeNode(8);
		// t.left.right.right = new TreeNode(14);
		new RecoverTree_cheat_morrisalgo().recoverTree(t);
	}
}

// TreeNode pre = null;
// TreeNode first = null, second = null;
//// Morris Traversal
// TreeNode temp = null;
// while(root!=null){
// if(root.left!=null){
// // connect threading for root
// temp = root.left;
// while(temp.right!=null && temp.right != root)
// temp = temp.right;
// // the threading already exists
// if(temp.right!=null){
// if(pre!=null && pre.val > root.val){
// if(first==null){first = pre;second = root;}
// else{second = root;}
// }
// pre = root;
//
// temp.right = null;
// root = root.right;
// }else{
// // construct the threading
// temp.right = root;
// root = root.left;
// }
// }else{
// if(pre!=null && pre.val > root.val){
// if(first==null){first = pre;second = root;}
// else{second = root;}
// }
// pre = root;
// root = root.right;
// }
// }
//// swap two node values;
// if(first!= null && second != null){
// int t = first.val;
// first.val = second.val;
// second.val = t;
// }
