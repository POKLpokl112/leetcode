package code.three;

//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//Note:
//You may assume that nums1 has enough space (size that is greater or equal to m + n) 
//to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

public class Merge_slowfivetimes {
	public void merge(final int[] nums1, int m, final int[] nums2, int n) {
		while (m > 0 && n > 0) {
			if (nums1[m - 1] > nums2[n - 1]) {
				nums1[m + n - 1] = nums1[m - 1];
				m--;
			} else if (nums1[m - 1] < nums2[n - 1]) {
				nums1[m + n - 1] = nums2[n - 1];
				n--;
			} else {
				nums1[m + n - 1] = nums2[n - 1];
				nums1[m + n - 2] = nums1[m - 1];
				m--;
				n--;
			}
		}

		if (m == 0) {
			for (int i = 0; i < n; i++) {
				nums1[i] = nums2[i];
			}
		}
	}

	public static void main(final String[] args) {
		final int[] i1 = {2, 0};
		final int[] i2 = {1};
		new Merge_slowfivetimes().merge(i1, 1, i2, 1);
	}
}
