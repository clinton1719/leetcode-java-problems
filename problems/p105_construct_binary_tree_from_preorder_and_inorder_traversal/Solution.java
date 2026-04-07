package problems.p105_construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.*;
import problems.TreeNode;

public class Solution {
  private Map<Integer, Integer> inorderMap;
  private int preorderIndex = 0;

  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7}));
  }

  private TreeNode build(int[] preorder, int inStart, int inEnd) {
    if (inStart > inEnd) return null;

    int rootVal = preorder[preorderIndex++];
    TreeNode root = new TreeNode(rootVal);

    int index = inorderMap.get(rootVal);

    root.left = build(preorder, inStart, index - 1);
    root.right = build(preorder, index + 1, inEnd);

    return root;

  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    inorderMap = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }

    return build(preorder, 0, inorder.length - 1);

  }
}
