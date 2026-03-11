package problems.p238_product_of_array_except_self;

import java.util.*;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.productExceptSelf(new int[] {1, 2, 3, 4}));
  }

  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    int currentProduct = 1;
    result[0] = 1;

    for (int i = 1; i < n; i++) {
      currentProduct = nums[i - 1] * currentProduct;
      result[i] = currentProduct;
    }

    currentProduct = 1;

    for (int i = n - 2; i >= 0; i--) {
      currentProduct = nums[i + 1] * currentProduct;
      result[i] *= currentProduct;
    }

    return result;
  }
}
