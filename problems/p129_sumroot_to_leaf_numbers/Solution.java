package problems.p129_sumroot_to_leaf_numbers;

import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  int sum = 0;

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.sumNumbers(TreeNodeUtility.buildTree("1,null,5")));
  }

  private void dfs(TreeNode node, StringBuilder currentDigit) {
    currentDigit.append(node.val);

    if (node.left == null && node.right == null) {
      sum += Integer.parseInt(currentDigit.toString());
      return;
    }

    if (node.left != null) {
      dfs(node.left, currentDigit);
      currentDigit.deleteCharAt(currentDigit.length() - 1);
    }
    if (node.right != null) {
      dfs(node.right, currentDigit);
      currentDigit.deleteCharAt(currentDigit.length() - 1);
    }
  }

  public int sumNumbers(TreeNode root) {
    dfs(root, new StringBuilder(root.val));
    return sum;
  }
}
