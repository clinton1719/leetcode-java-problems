package problems.p94_binary_tree_inorder_traversal;

import java.util.*;
import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    TreeNode p = TreeNodeUtility.buildTree("1,2,3,4,5,null,8,null,null,6,7,9");
    System.out.println(solution.inorderTraversal2(p));
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inorderRecursive(root, result);
    return result;
  }

  private void inorderRecursive(TreeNode root, List<Integer> result) {
    if (root == null) return;

    inorderRecursive(root.left, result);
    result.add(root.val);
    inorderRecursive(root.right, result);
  }

  public List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    while(root != null || !stack.isEmpty()) {
      while(root != null) {
        stack.push(root);
        root = root.left;
      }

      root = stack.pop();
      result.add(root.val);
      root = root.right;
    }

    return result;
  }
}
