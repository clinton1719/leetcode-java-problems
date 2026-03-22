package problems.p257_binary_tree_paths;

import java.util.ArrayList;
import java.util.List;
import problems.TreeNode;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    TreeNode root = new TreeNode(1);
    TreeNode two = new TreeNode(2);
    TreeNode three = new TreeNode(3);
    TreeNode five = new TreeNode(5);
    root.left = two;
    root.right = three;
    two.right = five;
    System.out.println(solution.binaryTreePaths(root));
  }

  private static void backtrack(List<String> result, TreeNode node, StringBuilder path) {
    if (node.left == null && node.right == null) {
      path.append(node.val);
      result.add(path.toString());
      while (!path.isEmpty() && path.charAt(path.length() - 1) != '>') {
        path.deleteCharAt(path.length() - 1);
      }
      return;
    }

    path.append(node.val).append("->");
    if (node.left != null) {
      backtrack(result, node.left, path);
    }
    if (node.right != null) {
      backtrack(result, node.right, path);
    }
    path.delete(path.length() - 2, path.length());
    while (path.charAt(path.length() - 1) != '>') {
      path.deleteCharAt(path.length() - 1);
    }
  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    backtrack(result, root, new StringBuilder());
    return result;
  }
}
