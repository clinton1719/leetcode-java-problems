package problems.p104_maximum_depth_of_binary_tree;

import problems.TreeNode;
import problems.TreeNodeUtility;

import java.util.*;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    TreeNode root = TreeNodeUtility.buildTree("3,9,20,null,null,15,7");
    System.out.println(solution.maxDepth(root));
  }

  // BFS
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int depth = 0;

    while (!queue.isEmpty()) {
      int n = queue.size();
      for (int i = 0; i < n; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      depth++;
    }

    return depth;
  }

  // DFS
  public int maxDepth2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right));
  }
}
