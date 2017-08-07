package code.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//For example,
//[1,1,2] have the following unique permutations:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
public class PermuteUnique_cant_understand {
	// public List<List<Integer>> permuteUnique(int[] nums) {
	// List<List<Integer>> list = new ArrayList<>();
	// List<Integer> ll = new ArrayList<>();
	// for (int i = 0; i < nums.length; i++) {
	// ll.add(nums[i]);
	// }
	//
	// aa(list, new ArrayList<>(), ll);
	// return list;
	// }
	//
	// private void aa(List<List<Integer>> list, List<Integer> array,
	// List<Integer> ll) {
	// for (int i = 1; i < ll.size(); i++) {
	// List<Integer> qwe = new ArrayList<>(ll);
	// List<Integer> asd = new ArrayList<>(array);
	// while (i < qwe.size() && qwe.get(i).equals(qwe.get(i - 1))) {
	// i++;
	// }
	//
	// if ((i == ll.size() - 1) && !qwe.get(i).equals(qwe.get(i - 1))) {
	// asd.add(qwe.remove(i - 1));
	// aa(list, asd, qwe);
	// List<Integer> zxc = new ArrayList<>(ll);
	// List<Integer> wer = new ArrayList<>(array);
	// wer.add(zxc.remove(i));
	// aa(list, wer, zxc);
	// } else {
	// asd.add(qwe.remove(i - 1));
	// aa(list, asd, qwe);
	// }
	// }
	// if (ll.size() == 1) {
	// array.add(ll.remove(0));
	// list.add(array);
	// }
	// }

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return res;
		boolean[] used = new boolean[nums.length];
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfs(nums, used, list, res);
		return res;
	}

	public void dfs(int[] nums, boolean[] used, List<Integer> list,
			List<List<Integer>> res) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i])
				continue;
			if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
				continue;
			used[i] = true;
			list.add(nums[i]);
			dfs(nums, used, list, res);
			used[i] = false;
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] ii = {0, 0, 0, 0};
		new PermuteUnique_cant_understand().permuteUnique(ii);
	}
}
