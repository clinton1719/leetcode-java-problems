package problems.p103_binary_tree_zigzag_level_order_traversal;

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
    System.out.println(solution.zigzagLevelOrder(p));
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    if (root != null) {
      queue.add(root);
    }
    List<List<Integer>> answer = new ArrayList<>();
    int dir = 1;

    while (!queue.isEmpty()) {
      int n = queue.size();
      List<Integer> list = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        TreeNode node = queue.poll();

        if (dir == 1) {
          list.add(node.val);
        } else {
          list.addFirst(node.val);
        }

        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }

      dir *= -1;

      answer.add(list);
    }

    return answer;
  }
}
