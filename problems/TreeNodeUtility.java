package problems;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeUtility {
  public static TreeNode buildTree(String input) {
    if (input == null || input.trim().isEmpty()) {
      return null;
    }

    // Clean and split the input
    String[] values = input.replaceAll("\\s+", "").split(",");

    if (values.length == 0 || values[0].equals("null")) {
      return null;
    }

    // Create root
    TreeNode root = new TreeNode(Integer.parseInt(values[0]));

    // Use queue to build tree level by level
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int i = 1; // start from second element

    while (!queue.isEmpty() && i < values.length) {
      TreeNode current = queue.poll();

      // Left child
      if (i < values.length && !values[i].equals("null")) {
        current.left = new TreeNode(Integer.parseInt(values[i]));
        queue.offer(current.left);
      }
      i++;

      // Right child
      if (i < values.length && !values[i].equals("null")) {
        current.right = new TreeNode(Integer.parseInt(values[i]));
        queue.offer(current.right);
      }
      i++;
    }

    return root;
  }
}
