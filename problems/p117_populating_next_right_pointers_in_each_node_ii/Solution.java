package problems.p117_populating_next_right_pointers_in_each_node_ii;

import java.util.LinkedList;
import java.util.Queue;
import org.w3c.dom.Node;

public class Solution {
  static void main() {
    Solution solution = new Solution();
  }

  public Node connectBFS(Node root) {
    Queue<Node> queue = new LinkedList<>();
    if (root != null) {
      queue.offer(root);
    }

    while (!queue.isEmpty()) {
      int n = queue.size();
      Node head = new Node(0);
      Node current = head;

      for (int i = 0; i < n; i++) {
        Node node = queue.remove();

        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }

        current.next = node;
        current = node;
      }
      current.next = null;
      head.next = null;
    }

    return root;
  }

//  public Node connect(Node root) {
//     dfs(root.left, root.right);
//     return root;
//  }

//  public void dfs(Node left, Node right) {
//
//  }

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
