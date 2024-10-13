package LeetCode.MedianOfTwoSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int idx1 = 0;
        int idx2 = 0;
        int[] mergedNums = new int[nums1.length + nums2.length];
        double median = 0;

        while (idx1 + idx2 < nums1.length + nums2.length) {
            if (idx1 == nums1.length) {
                mergedNums[idx1 + idx2] = nums2[idx2];
                idx2++;
            } else if (idx2 == nums2.length) {
                mergedNums[idx1 + idx2] = nums1[idx1];
                idx1++;
            } else {
                if (nums1[idx1] < nums2[idx2]) {
                    mergedNums[idx1 + idx2] = nums1[idx1];
                    idx1++;
                } else {
                    mergedNums[idx1 + idx2] = nums2[idx2];
                    idx2++;
                }
            }
        }

        if (mergedNums.length % 2 == 0) {
            median = (mergedNums[mergedNums.length / 2] + mergedNums[mergedNums.length / 2 - 1]) / 2.0;
        } else {
            median = mergedNums[mergedNums.length / 2];
        }

        return median;
    }

}
