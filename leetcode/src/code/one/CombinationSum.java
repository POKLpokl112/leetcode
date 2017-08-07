package code.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//The same repeated number may be chosen from C unlimited number of times.
//
//Note:
//All numbers (including target) will be positive integers.
//The solution set must not contain duplicate combinations.
//For example, given candidate set [2, 3, 6, 7] and target 7, 
//im bad,im tired.give me power
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
			int divide = target / candidates[i];
			if (divide == 0) {
				return;
			}

			if (target % candidates[i] == 0) {
				List<Integer> array1;
				if (array == null) {
					array1 = new ArrayList<>();
				} else {
					array1 = new ArrayList<>(array);
				}
				for (int j = 0; j < divide; j++) {
					array1.add(candidates[i]);
				}
				list.add(array1);
				for (int j = 1; j < divide - 1; j++) {
					int num = candidates[i] * j;
					List<Integer> array2;
					if (array == null) {
						array2 = new ArrayList<>();
					} else {
						array2 = new ArrayList<>(array);
					}
					for (int k = 1; k < j + 1; k++) {
						array2.add(candidates[i]);
					}
					asd(list, array2, candidates, i + 1, target - num);
				}
				continue;
			}

			for (int j = 1; j < divide + 1; j++) {
				List<Integer> array2;
				if (array == null) {
					array2 = new ArrayList<>();
				} else {
					array2 = new ArrayList<>(array);
				}
				for (int k = 0; k < j; k++) {
					array2.add(candidates[i]);
				}

				int num = candidates[i] * j;
				asd(list, array2, candidates, i + 1, target - num);
			}
		}
	}

	public static void main(String[] args) {
		int[] ii = {1, 2};
		new CombinationSum().combinationSum(ii, 3);
	}

}
