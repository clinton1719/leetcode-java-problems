package problems.p404_sum_of_left_leaves;

import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  int sum = 0;

  static void main() {
    Solution solution = new Solution();
    TreeNode p = TreeNodeUtility.buildTree("1,2,3,4,5");
    System.out.println(solution.sumOfLeftLeaves(p));
  }

  private void findSumRecursive(TreeNode node) {
    if (node.left == null && node.right == null) {
      return;
    }

    if (node.left != null) {
      if (node.left.left == null && node.left.right == null) {
        sum += node.left.val;
      }
      findSumRecursive(node.left);
    }
    if (node.right != null) {
      findSumRecursive(node.right);
    }
  }

  public int sumOfLeftLeaves(TreeNode root) {
    findSumRecursive(root);
    return sum;
  }
}
