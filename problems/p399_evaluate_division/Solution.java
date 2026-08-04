package problems.p399_evaluate_division;

import java.util.*;

public class Solution {

  static void main() {
    Solution solution = new Solution();

    double[] answer =
        solution.calcEquation(
            List.of(List.of("a", "b"), List.of("b", "c")),
            new double[] {2.0, 3.0},
            List.of(
                List.of("a", "c"),
                List.of("b", "a"),
                List.of("a", "e"),
                List.of("a", "a"),
                List.of("x", "x")));

    for (double d : answer) {
      System.out.println(d);
    }
  }

  public double[] calcEquation(
      List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, List<Edge>> graph = new HashMap<>();

    // build the graph
    for (int i = 0; i < equations.size(); i++) {
      String numerator = equations.get(i).get(0);
      String denominator = equations.get(i).get(1);

      graph.putIfAbsent(numerator, new ArrayList<>());
      graph.putIfAbsent(denominator, new ArrayList<>());

      graph.get(numerator).add(new Edge(denominator, values[i]));
      graph.get(denominator).add(new Edge(numerator, 1 / values[i]));
    }

    double[] answer = new double[queries.size()];

    for (int i = 0; i < queries.size(); i++) {
      String numerator = queries.get(i).get(0);
      String denominator = queries.get(i).get(1);

      if (!graph.containsKey(numerator) || !graph.containsKey(denominator)) {
        answer[i] = -1;
      } else {
        answer[i] = dfs(numerator, denominator, 1.0, new HashSet<>(), graph);
      }
    }

    return answer;
  }

  private double dfs(
      String current,
      String target,
      double product,
      HashSet<String> visited,
      Map<String, List<Edge>> graph) {
    if (current.equals(target)) {
      return product;
    }

    visited.add(current);

    for (Edge next : graph.get(current)) {
      if (!visited.contains(next.node)) {
        double ans = dfs(next.node, target, product * next.weight, visited, graph);

        if (ans != -1) return ans;
      }
    }

    return -1;
  }

  static class Edge {
    String node;
    double weight;

    public Edge(String node, double weight) {
      this.node = node;
      this.weight = weight;
    }
  }
}
