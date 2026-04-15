package problems.p117_populating_next_right_pointers_in_each_node_ii;

public class Solution {
  static void main() {
    Solution solution = new Solution();
  }

  public Node connectDFS(Node root) {
    if (root == null) return null;

    if (root.left != null) {
      if (root.right != null) {
        root.left.next = root.right;
      } else {
        root.left.next = findNext(root);
      }
    }
    if (root.right != null) {
      root.right.next = findNext(root);
    }

    connectDFS(root.right);
    connectDFS(root.left);

    return root;
  }

  public Node findNext(Node root) {
    while (root.next != null) {
      root = root.next;
      if (root.left != null) return root.left;
      if (root.right != null) return root.right;
    }
    return null;
  }

  public Node connect(Node root) {
    Node curr = root; // current level start

    while (curr != null) {
      Node head = null; // next level start
      Node prev = null; // previous node in next level

      while (curr != null) {
        // process left child
        if (curr.left != null) {
          if (prev != null) {
            prev.next = curr.left;
          } else {
            head = curr.left;
          }
          prev = curr.left;
        }

        // process right child
        if (curr.right != null) {
          if (prev != null) {
            prev.next = curr.right;
          } else {
            head = curr.right;
          }
          prev = curr.right;
        }

        curr = curr.next; // move in current level
      }

      curr = head; // move to next level
    }

    return root;
  }

  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }
}
