package code.two;

//Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//Note:
//You are not suppose to use the library's sort function for this problem.

public class SortColors {
	public void sortColors_slow(final int[] nums) {
		int r = 0, w = 0;
		for (final int i : nums) {
			switch (i) {
				case 0 :
					r++;
					break;
				case 1 :
					w++;
					break;
			}
		}

		final int b = r + w;
		for (int i = 0; i < nums.length; i++) {
			if (i < r) {
				nums[i] = 0;
				continue;
			} else if (i < b) {
				nums[i] = 1;
				continue;
			}
			nums[i] = 2;
		}
	}

}

// public void s(int i,int k, int[] c) {
// int temp = c[i];
// c[i] = c[k];
// c[k] = temp;
// }
//
// public void sortColors(int[] nums) {
// int r,b,j,red,blue;
//
// blue=2;
// red=r=j= 0;
// b = nums.length - 1;
//
//
// while (b>=j) {
// if (nums[j] == red) {s(j, r,nums);r=r+1;j++;}
// else if (nums[j] == blue) {s(j,b,nums);b=b-1;}
// else {j++;}
// }
// }
