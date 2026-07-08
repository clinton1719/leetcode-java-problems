package problems.p102_binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    TreeNode p = TreeNodeUtility.buildTree("3,9,20,null,null,15,7");
    System.out.println(solution.levelOrder(p));
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    if (root != null) {
      queue.offer(root);
    }
    List<List<Integer>> answer = new ArrayList<>();

    while (!queue.isEmpty()) {
      int n = queue.size();
      List<Integer> list = new ArrayList<>(n);

      for (int i = 0; i < n; i++) {
        TreeNode node = queue.poll();

        list.add(node.val);

        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }

      answer.add(list);
    }

    return answer;
  }
}
