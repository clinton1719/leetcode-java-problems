package problems.p530_minimum_absolute_difference_in_bst;

import java.util.*;
import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  private TreeNode prev = null;
  private int minDifference = Integer.MAX_VALUE;

  static void main() {
    Solution solution = new Solution();
    TreeNode p = TreeNodeUtility.buildTree("1, null, 2");
    System.out.println(solution.getMinimumDifference(p));
  }

  public int getMinimumDifference(TreeNode root) {
    prev = null;
    minDifference = Integer.MAX_VALUE;

    inOrder(root);
    return minDifference;
  }

  private void inOrder(TreeNode node) {
    if (node == null) return;

    inOrder(node.left);

    if (prev != null) {
      minDifference = Math.min(minDifference, node.val - prev.val);
    }
    prev = node;

    inOrder(node.right);
  }
}
