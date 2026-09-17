package problems.p433_minimum_genetic_mutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.minMutation(
            "AACCGGTT", "AAACGGTA", new String[] {"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
  }

  public int minMutation(String startGene, String endGene, String[] bank) {
    Queue<String> queue = new LinkedList<>();
    queue.offer(startGene);

    Set<String> visited = new HashSet<>();
    visited.add(startGene);

    int mutations = 0;

    while (!queue.isEmpty()) {
      int n = queue.size();

      for (int i = 0; i < n; i++) {
        String currentGene = queue.poll();

        if (currentGene.equals(endGene)) {
          return mutations;
        }

        for (String neighbour : bank) {
          int allowedMutations = 1;

          for (int j = 0; j < 8 && allowedMutations >= 0; j++) {
            if (neighbour.charAt(j) != currentGene.charAt(j)) {
              allowedMutations--;
            }
          }

          if (allowedMutations == 0 && !visited.contains(neighbour)) {
            queue.offer(neighbour);
            visited.add(neighbour);
          }
        }
      }

      mutations++;
    }

    return -1;
  }
}
