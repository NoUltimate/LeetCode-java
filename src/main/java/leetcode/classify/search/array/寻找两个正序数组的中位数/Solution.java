package leetcode.classify.search.array.寻找两个正序数组的中位数;
/*
 *
 *
 * @author sunbowen
 * @date 2021年08月04日 11:07
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m + n) / 2;
        int sum = m + n;
        if (sum == 0) return 0;
        int i = 0, j = 0;
        List<Integer> nums = new ArrayList<>();
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums.add(nums1[i++]);
            } else {
                nums.add(nums2[j++]);
            }
            if (i + j - 1 == mid) {
                if (sum % 2 == 0) return (double) (nums.get(mid) + nums.get(mid - 1)) / 2;
                else return nums.get(mid);
            }
        }

        while (i < m) {
            nums.add(nums1[i++]);
            if (i + j - 1 == mid) {
                if (sum % 2 == 0) return (double) (nums.get(mid) + nums.get(mid - 1)) / 2;
                else return nums.get(mid);
            }
        }

        while (j < n) {
            nums.add(nums2[j++]);
            if (i + j - 1 == mid) {
                if (sum % 2 == 0) return (double) (nums.get(mid) + nums.get(mid - 1)) / 2;
                else return nums.get(mid);
            }
        }
        return 0;
    }
}
