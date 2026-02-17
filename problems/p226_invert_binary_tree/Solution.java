package problems.p226_invert_binary_tree;

import problems.TreeNode;
import problems.TreeNodeUtility;

import java.util.LinkedList;
import java.util.Queue;

import static problems.TreeNodeUtility.printLevelOrder;


public class Solution {
  static void main() {
    Solution solution = new Solution();
    TreeNode p = TreeNodeUtility.buildTree("4,2,7,1,3,6,9");
    printLevelOrder(solution.invertTree(p));
  }

  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    invertTree(root.left);
    invertTree(root.right);

    return root;
  }

  public TreeNode invertTree2(TreeNode root) {
    if (root == null) return null;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      TreeNode temp = node.left;
      node.left = node.right;
      node.right = temp;

      if (node.left != null) queue.add(node.left);
      if (node.right != null) queue.add(node.right);
    }

    return root;
  }

}
