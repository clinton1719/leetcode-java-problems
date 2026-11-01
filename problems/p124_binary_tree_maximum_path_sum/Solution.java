package problems.p124_binary_tree_maximum_path_sum;

import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  static int maxPathSum = -1001;

  static void main() {
    Solution solution = new Solution();
    TreeNode treeNode = TreeNodeUtility.buildTree("-10,9,20,null,null,15,7");
    System.out.println(solution.maxPathSum(treeNode));
  }

  private static int dfs(TreeNode node) {
    if (node == null) return 0;

    int left = Math.max(0, dfs(node.left));
    int right = Math.max(0, dfs(node.right));

    maxPathSum = Math.max(maxPathSum, node.val + left + right);

    return node.val + Math.max(left, right);
  }

  public int maxPathSum(TreeNode root) {
    Math.max(maxPathSum, dfs(root));
    return maxPathSum;
  }
}
