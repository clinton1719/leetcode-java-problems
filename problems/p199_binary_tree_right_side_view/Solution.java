package problems.p199_binary_tree_right_side_view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    TreeNode node = TreeNodeUtility.buildTree("1,2,3,4,null,null,null,5");
    System.out.println(solution.rightSideViewDFS(node));
  }

  public List<Integer> rightSideViewBFS(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    if (root != null) {
      queue.offer(root);
    }
    List<Integer> result = new ArrayList<>();

    while(!queue.isEmpty()) {
      int n = queue.size();

      for(int i = 0; i<n; i++) {
        TreeNode node = queue.poll();

        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }

        if (i == n-1) {
          result.add(node.val);
        }
      }
    }

    return result;
  }

  private static void dfs(TreeNode root, List<Integer> result, int depth) {
    if (root == null) return;

    if (depth == result.size()) {
      result.add(root.val);
    }

    if (root.right != null) {
      dfs(root.right, result, depth+1);
    }
    if (root.left != null) {
      dfs(root.left, result, depth+1);
    }
  }

  public List<Integer> rightSideViewDFS(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    dfs(root, result, 0);
    return result;
  }
}
