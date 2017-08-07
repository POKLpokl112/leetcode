package code.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//Each number in C may only be used once in the combination.
//
//Note:
//All numbers (including target) will be positive integers.
//The solution set must not contain duplicate combinations.
//For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
public class CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		if (candidates == null || candidates.length == 0) {
			return list;
		}

		Arrays.sort(candidates);
		asd(list, null, candidates, 0, target);
		return list;
    }

	public void asd(List<List<Integer>> list, List<Integer> array,
			int[] candidates, int start, int target) {
		for (int i = start; i < candidates.length; i++) {
			if (candidates[i] > target) {
				return;
			}

			int j = 1;
			while (i + j < candidates.length
					&& candidates[i + j] == candidates[i + j - 1]) {
				j++;
			}
			if (j != 1) {
				for (int k = 1; k < j + 1; k++) {
					List<Integer> array2;
					if (array == null) {
						array2 = new ArrayList<>();
					} else {
						array2 = new ArrayList<>(array);
					}

					if (target == candidates[i] * k) {
						for (int k2 = 0; k2 < k; k2++) {
							array2.add(candidates[i]);
						}
						list.add(array2);
						break;
					} else if (target < candidates[i] * k) {
						break;
					} else {
						for (int k2 = 0; k2 < k; k2++) {
							array2.add(candidates[i]);
						}

						asd(list, array2, candidates, i + j,
								target - candidates[i] * k);
					}
				}
				i = i + j - 1;
			} else {
				List<Integer> array1;
				if (array == null) {
					array1 = new ArrayList<>();
				} else {
					array1 = new ArrayList<>(array);
				}
				array1.add(candidates[i]);
				if (target == candidates[i]) {
					list.add(array1);
					return;
				}
				asd(list, array1, candidates, i + 1, target - candidates[i]);
			}
		}
	}

	public static void main(String[] args) {
		int[] ii = {1, 2};
		new CombinationSum2().combinationSum2(ii, 3);
	}

}
