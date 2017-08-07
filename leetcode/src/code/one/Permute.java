package code.one;

import java.util.ArrayList;
import java.util.List;

//Given a collection of distinct numbers, return all possible permutations.
//
//For example,
//[1,2,3] have the following permutations:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]

public class Permute {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> l = new ArrayList<>();
		for (int i : nums) {
			l.add(i);
		}
		ww(list, new ArrayList<>(), l);

		return list;
    }

	private void ww(List<List<Integer>> list, List<Integer> array,
			List<Integer> l) {

		for (int j = 0; j < l.size(); j++) {
			List<Integer> ll = new ArrayList<>(l);
			List<Integer> qwe = new ArrayList<>(array);
			qwe.add(ll.remove(j));
			if (ll.size() == 0) {
				list.add(qwe);
			} else
			ww(list, qwe, ll);
		}
	}

}
