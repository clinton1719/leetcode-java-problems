package problems.p133_clone_graph;

import java.util.*;

public class Solution {

  public Node cloneGraph(Node node) {
    if (node == null) return null;

    Map<Node, Node> map = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();

    queue.offer(node);
    map.put(node, new Node(node.val));

    while (!queue.isEmpty()) {
      Node oldNode = queue.poll();

      for (Node neighbor : oldNode.neighbors) {
        if (!map.containsKey(neighbor)) {
          map.put(neighbor, new Node(neighbor.val));
          queue.offer(neighbor);
        }
        map.get(oldNode).neighbors.add(map.get(neighbor));
      }
    }

    return map.get(node);
  }

  static class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}
