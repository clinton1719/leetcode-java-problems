package problems.p114_flatten_binary_tree_to_linked_list;

import problems.TreeNode;
import problems.TreeNodeUtility;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    TreeNode t = TreeNodeUtility.buildTree("1,2,5,3,4,null,6");
    solution.flatten(t);
  }

  public void flatten(TreeNode root) {
    TreeNode current = root;

    while (current != null) {
      if (current.left != null) {
        TreeNode prev = current.left;

        while (prev.right != null) {
          prev = prev.right;
        }

        prev.right = current.right;
        current.right = current.left;
        current.left = null;
      }
      current = current.right;
    }
  }
}
