package problems.p2331_evaluate_boolean_binary_tree;

import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  private TreeNode prev = null;
  private int minDifference = Integer.MAX_VALUE;

  static void main() {
    Solution solution = new Solution();
    TreeNode p = TreeNodeUtility.buildTree("1, null, 2");
    System.out.println(solution.evaluateTree(p));
  }

  public boolean evaluateTree(TreeNode root) {
    if (root.left == null && root.right == null) {
      return root.val == 1;
    }

    if (root.val == 2) {
      return evaluateTree(root.left) ? true : evaluateTree(root.right);
    } else {
      return evaluateTree(root.left) && evaluateTree(root.right);
    }
  }
}
