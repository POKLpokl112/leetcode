package code.one;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int length1 = nums1.length;
		int length2 = nums2.length;
		int mediumIndex = (length1 + length2) / 2;

		int[] nums = new int[length1 + length2];
		for (int i = 0; i < nums.length; i++) {
			if (i < length1) {
				nums[i] = nums1[i];
			} else {
				nums[i] = nums2[i - length1];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}

		return (length1 + length2) % 2 == 0 ? (nums[mediumIndex] + nums[mediumIndex - 1]) / 2.0 : nums[mediumIndex];
        
    }
}
