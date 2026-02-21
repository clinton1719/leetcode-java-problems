package problems.p637_average_of_levels_in_binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    TreeNode p = TreeNodeUtility.buildTree("2147483647,2147483647,2147483647");
    System.out.println(solution.averageOfLevels(p));
  }

  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int n = queue.size();
      double sum = 0;

      for (int i = 0; i < n; i++) {
        TreeNode node = queue.poll();
        sum += (double) node.val;
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }

      res.add(sum / n);
    }

    return res;
  }
}
