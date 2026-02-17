package problems.p100_same_tree;

import java.util.*;
import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    TreeNode p = TreeNodeUtility.buildTree("1,2,3");
    TreeNode q = TreeNodeUtility.buildTree("1,null,2");
    System.out.println(solution.isSameTree(p, q));
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    if (p.val != q.val) return false;

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
