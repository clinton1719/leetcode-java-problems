package problems.p4_median_of_two_sorted_arrays;

public class Solution {
  int m;
  int n;
  int[] nums1;
  int[] nums2;

  static void main() {
    Solution solution = new Solution();
    int[] nums1 = new int[] {1, 2};
    int[] nums2 = new int[] {3, 4};
    System.out.println(solution.findMedianSortedArrays(nums1, nums2));
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    m = nums1.length;
    n = nums2.length;
    this.nums1 = nums1;
    this.nums2 = nums2;
    int kOfFirstArray = (m + n + 1) / 2;
    int kOfSecondArray = (m + n + 2) / 2;

    int a = findKthElement(0, 0, kOfFirstArray);
    int b = findKthElement(0, 0, kOfSecondArray);

    return (a + b) / 2.0;
  }

  private int findKthElement(int i, int j, int k) {
    if (i >= m) {
      return nums2[j + k - 1];
    }
    if (j >= n) {
      return nums1[i + k - 1];
    }
    if (k == 1) {
      return Math.min(nums1[i], nums2[j]);
    }

    // Number of elements to potentially eliminate (half of k)
    int halfK = k / 2;

    int firstArrayMidValue = (i + halfK - 1 < m) ? nums1[i + halfK - 1] : Integer.MAX_VALUE;
    int secondArrayMidValue = (j + halfK - 1 < n) ? nums2[j + halfK - 1] : Integer.MAX_VALUE;

    if (firstArrayMidValue < secondArrayMidValue) {
      return findKthElement(i + halfK, j, k - halfK);
    } else {
      return findKthElement(i, j + halfK, k - halfK);
    }
  }
}
