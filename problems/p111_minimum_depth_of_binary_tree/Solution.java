package problems.p111_minimum_depth_of_binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import problems.TreeNode;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    TreeNode node = new TreeNode(1);
    System.out.println(solution.minDepth(node));
  }

  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int depth = 0;

    while (!queue.isEmpty()) {
      int n = queue.size();

      for (int i = 0; i < n; i++) {
        TreeNode node = queue.poll();

        if (node.left == null && node.right == null) {
          return depth + 1;
        }

        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      depth++;
    }

    return depth + 1;
  }
}
