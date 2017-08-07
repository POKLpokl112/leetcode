package code.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum_NO {
	public List<List<Integer>> threeSum(int[] nums, int p) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);

		int position = 0;
		for (int i = 0; i < nums.length; i++) {
			if (p < nums[i]) {
				position = i;
				break;
			}

			if (i == nums.length - 1) {
				position = nums.length;
			}
		}

		for (int i = 0; i < position - 1; i++) {
			if (nums[i] == nums[i + 1] && i + 2 < position && nums[i] == nums[i + 2]) {
				continue;
			}
			for (int j = i + 1; j < position; j++) {
				if (j + 1 < position && nums[j] == nums[j + 1]) {
					continue;
				}
				for (int k = position; k < nums.length; k++) {
					if (nums[k] + nums[i] + nums[j] == p) {
						List<Integer> lii = new ArrayList<>();
						lii.add(nums[i]);
						lii.add(nums[j]);
						lii.add(nums[k]);
						list.add(lii);
						break;
					}
				}
			}
			if (nums[i] == nums[i + 1]) {
				if (p == 0 && i > 0 && nums[i - 1] == 0 && nums[i] == 0) {
					List<Integer> lii = new ArrayList<>();
					lii.add(0);
					lii.add(0);
					lii.add(0);
					list.add(lii);
				}
				i++;
			}
		}

		for (int i = position; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1] && i + 2 < nums.length && nums[i] == nums[i + 2]) {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if (j + 1 < nums.length && nums[j] == nums[j + 1]) {
					continue;
				}
				for (int k = 0; k < position; k++) {
					if (nums[k] + nums[i] + nums[j] == p) {
						List<Integer> lii = new ArrayList<>();
						lii.add(nums[i]);
						lii.add(nums[j]);
						lii.add(nums[k]);
						list.add(lii);
						break;
					}
				}
			}
			if (nums[i] == nums[i + 1]) {
				i++;
			}
		}
		return list;

	}

	public static void main(String[] args) {
		int[] i = { -1, 0, 1, 2, -1, -4 };
		System.out.println(new ThreeSum_NO().threeSum(i, 0));
	}
}
