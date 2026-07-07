package problems.p236_lowest_common_ancestor_of_a_binary_tree;

import java.util.*;
import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  static void main() {
    int[] nums = {1, 2};
    Solution solution = new Solution();
    TreeNode root = TreeNodeUtility.buildTree("3,5,1,6,2,0,8,null,null,7,4");
    System.out.println(solution.lowestCommonAncestor(root, root.left, root.right));
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;

    if (root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) {
      return root;
    } else if (left != null) {
      return left;
    } else {
      return right;
    }
  }
}
