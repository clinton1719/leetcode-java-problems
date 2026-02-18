package problems.p101_symmetric_tree;

import java.util.Stack;
import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    TreeNode p = TreeNodeUtility.buildTree("1,2,2,3,4,4,3");
    System.out.println(solution.isSymmetric(p));
  }

  public boolean isSymmetric(TreeNode root) {
    Stack<TreeNode> left = new Stack<>();
    Stack<TreeNode> right = new Stack<>();
    if (root.left != null) {
      left.add(root.left);
    }
    if (root.right != null) {
      right.add(root.right);
    }

    while (!left.isEmpty() && !right.isEmpty()) {
      int n = left.size();
      for (int i = 0; i < n; i++) {
        TreeNode leftNode = left.pop();
        TreeNode rightNode = right.pop();

        if (leftNode.val != rightNode.val) return false;

        if (leftNode.left != null) {
          left.add(leftNode.left);
        }
        if (leftNode.right != null) {
          left.add(leftNode.right);
        }

        if (rightNode.right != null) {
          left.add(rightNode.right);
        }
        if (rightNode.left != null) {
          left.add(rightNode.left);
        }
      }
    }

    return left.isEmpty() && right.isEmpty();
  }
}
