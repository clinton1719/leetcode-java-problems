package problems.p108_convert_sorted_array_to_binary_search_tree;

import java.util.*;
import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    TreeNodeUtility.printLevelOrder(solution.sortedArrayToBST(new int[] {-10, -3, 0, 5, 9}));
  }

  private static TreeNode createBST(int[] nums, int left, int right) {
    int mid = left + ((right - left) / 2);

    TreeNode node = new TreeNode(nums[mid]);
    if (mid != left) {
      node.left = createBST(nums, left, mid - 1);
    }
    if (mid != right) {
      node.right = createBST(nums, mid + 1, right);
    }

    return node;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return createBST(nums, 0, nums.length - 1);
  }
}
