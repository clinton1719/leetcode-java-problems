package problems.p138_copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public Node copyRandomList(Node head) {
    Map<Node, Node> map = new HashMap<>();
    Node currentNode = head;

    while (currentNode != null) {
      map.put(currentNode, new Node(currentNode.val));
      currentNode = currentNode.next;
    }

    currentNode = head;

    while (currentNode != null) {
      Node newNode = map.get(currentNode);
      newNode.next = map.get(currentNode.next);
      newNode.random = map.get(currentNode.random);
      currentNode = currentNode.next;
    }

    currentNode = head;

    return map.get(currentNode);
  }

  static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}
