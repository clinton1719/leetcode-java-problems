package problems.p230_kth_smallest_element_in_a_bst;

import java.util.*;
import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  int ans = -1;
  int count = 0;

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.kthSmallest(TreeNodeUtility.buildTree("3,1,4,null,2"), 1));
  }

  public int kthSmallest(TreeNode root, int k) {
    inorder(root, k);
    return ans;
  }

  void inorder(TreeNode node, int k) {
    if (node == null || ans != -1) return;

    inorder(node.left, k);

    count++;

    if (count == k) {
      ans = node.val;
      return;
    }

    inorder(node.right, k);
  }
}
