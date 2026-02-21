package problems.p222_count_complete_tree_nodes;

import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    TreeNode p = TreeNodeUtility.buildTree("1,2,3,4,5,6");
    System.out.println(solution.countNodes(p));
  }

  public int countNodes(TreeNode root) {
    if (root == null) return 0;
    int leftHeight = findLeftHeight(root);
    int rightHeight = findRightHeight(root);

    if (leftHeight == rightHeight) {
      return (int) Math.pow(2, leftHeight) - 1;
    } else {
      return 1 + countNodes(root.left) + countNodes(root.right);
    }
  }

  private int findLeftHeight(TreeNode root) {
    int height = 0;

    while (root != null) {
      root = root.left;
      height++;
    }

    return height;
  }

  private int findRightHeight(TreeNode root) {
    int height = 0;

    while (root != null) {
      root = root.right;
      height++;
    }

    return height;
  }
}
