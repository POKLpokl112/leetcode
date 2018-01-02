package code.two;

//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?
//
//For example,
//Given sorted array nums = [1,1,1,2,2,3],
//
//Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
public class RemoveDuplicates_unbelievable {
	public int removeDuplicates(final int[] nums) {
		final int[] ii = new int[nums.length];
		int length = nums.length, k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > 1 && nums[i] == nums[i - 2]) {
				length--;
				k++;
				continue;
			}
			ii[i - k] = nums[i];
		}
		for (int i = 0; i < length; i++) {
			nums[i] = ii[i];
		}
		return length;

	}

	public static void main(final String[] args) {
		final int[] ii = {1, 1, 1, 2};
		new RemoveDuplicates_unbelievable().removeDuplicates(ii);
	}
}
