package problems.p106_construct_binary_tree_from_inorder_and_postorder_traversal;

import java.util.*;
import problems.TreeNode;

public class Solution {
  private Map<Integer, Integer> inorderMap;
  private int postorderIndex;

  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.buildTree(new int[] {9, 3, 15, 20, 7}, new int[] {9, 15, 7, 20, 3}));
  }

  private TreeNode build(int[] postorder, int inStart, int inEnd) {
    if (inStart > inEnd) return null;

    int value = postorder[postorderIndex--];
    TreeNode root = new TreeNode(value);

    int index = inorderMap.get(value);

    root.right = build(postorder, index + 1, inEnd);
    root.left = build(postorder, inStart, index - 1);

    return root;
  }

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    inorderMap = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }

    postorderIndex = postorder.length - 1;

    return build(postorder, 0, inorder.length - 1);
  }
}
