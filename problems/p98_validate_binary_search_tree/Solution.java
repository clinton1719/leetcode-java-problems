package problems.p98_validate_binary_search_tree;

import java.util.*;
import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    TreeNode p = TreeNodeUtility.buildTree("2,1,3");
    System.out.println(solution.isValidBST(p));
  }

  public boolean isValidBST(TreeNode root) {
    return checkValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean checkValid(TreeNode node, long low, long high) {
    if (node == null) {
      return true;
    }

    if (!(node.val > low && node.val < high)) return false;

    return checkValid(node.left, low, node.val) && checkValid(node.right, node.val, high);
  }
}
