package problems.p112_path_sum;

import problems.TreeNode;
import problems.TreeNodeUtility;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    TreeNode p = TreeNodeUtility.buildTree("5,4,8,11,null,13,4,7,2,null,null,null,1");
    System.out.println(solution.hasPathSum(p, 22));
  }

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;

    if (root.left == null && root.right == null) {
      return targetSum == root.val;
    }

    return hasPathSum(root.left, targetSum - root.val) ||
            hasPathSum(root.right, targetSum - root.val);
  }


  public boolean hasPathSum2(TreeNode root, int targetSum) {
    if (root == null) return false;
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<Integer> sum = new LinkedList<>();
    queue.add(root);
    sum.add(root.val);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.remove();
        int currSum = sum.remove();
        if (currSum == targetSum && node.left == null && node.right == null) {
          return true;
        }


        if (node.left != null) {
          queue.add(node.left);
          sum.add(node.left.val + currSum);
        }
        if (node.right != null) {
          queue.add(node.right);
          sum.add(node.right.val + currSum);
        }
      }
    }
    return false;
  }
}
