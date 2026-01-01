package problems.p89_merge_sorted_array;

import java.util.HashMap;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int pointer = m + n - 1;

        while (left >= 0 && right >= 0) {
            if (nums1[left] > nums2[right]) {
                nums1[pointer--] = nums1[left--];
            } else {
                nums1[pointer--] = nums2[right--];
            }
        }

        // Only nums2 may have leftovers
        while (right >= 0) {
            nums1[pointer--] = nums2[right--];
        }
    }

    static void main() {
        int[] nums1 = {2,5,6,0,0,0}, nums2 = {1,2,3};
        int m = 3, n = 3;
        Solution solution = new Solution();
        solution.merge(nums1, m, nums2, n);
        for (int num: nums1) {
            System.out.println(num);
        }
    }
}
