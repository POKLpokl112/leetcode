package code.two;

import java.util.ArrayList;
import java.util.List;

//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//For example,
//If n = 4 and k = 2, a solution is:
//
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]

public class Combine_60point {
	public List<List<Integer>> combine(final int n, final int k) {
		final List<List<Integer>> list = new ArrayList<>();

		gogogo(list, new ArrayList<>(), 1, n, k);

		return list;

	}

	private void gogogo(final List<List<Integer>> list,
			final List<Integer> array, final int qwe, final int n,
			final int k) {
		for (int i = qwe; i < n + 1; i++) {
			final List<Integer> arraym = new ArrayList<>(array);
			arraym.add(i);

			if (arraym.size() == k) {
				list.add(arraym);
			} else {
				gogogo(list, arraym, i + 1, n, k);
			}
		}
	}
}
