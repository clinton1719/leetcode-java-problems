package problems.p101_symmetric_tree;

import java.util.Stack;
import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    TreeNode p = TreeNodeUtility.buildTree("1,2,2,null,3,null,3");
    System.out.println(solution.isSymmetric(p));
  }

  public boolean isSymmetric(TreeNode root) {
    Stack<TreeNode> left = new Stack<>();
    Stack<TreeNode> right = new Stack<>();
    left.add(root.left);
    right.add(root.right);

    while (!left.isEmpty() && !right.isEmpty()) {
      int n = left.size();

      for (int i = 0; i < n; i++) {
        TreeNode leftNode = left.pop();
        TreeNode rightNode = right.pop();

        if (leftNode == null && rightNode != null) return false;
        if (leftNode != null && rightNode == null) return false;

        if (leftNode == null && rightNode == null) continue;

        if (leftNode.val != rightNode.val) return false;

        left.add(leftNode.left);
        left.add(leftNode.right);

        right.add(rightNode.right);
        right.add(rightNode.left);
      }
    }

    return left.isEmpty() && right.isEmpty();
  }

  public boolean isSymmetric2(TreeNode root) {
    return root==null || isSymmetricHelp(root.left, root.right);
  }

  private boolean isSymmetricHelp(TreeNode left, TreeNode right){
    if(left==null || right==null)
      return left==right;
    if(left.val!=right.val)
      return false;
    return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
  }
}
