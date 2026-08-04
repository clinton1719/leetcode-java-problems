package problems.p207_course_schedule;

import java.util.*;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.canFinish(2, new int[][] {new int[] {1, 0}, new int[] {0, 1}}));
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>(numCourses);

    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }

    int[] indegrees = new int[numCourses];

    for (int[] item : prerequisites) {
      int course = item[0];
      int prerequisite = item[1];

      graph.get(prerequisite).add(course);
      indegrees[course]++;
    }

    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < indegrees.length; i++) {
      if (indegrees[i] == 0) {
        queue.offer(i);
      }
    }

    int completed = 0;

    while (!queue.isEmpty()) {
      int course = queue.poll();
      completed++;

      for (int dependent : graph.get(course)) {
        indegrees[dependent]--;

        if (indegrees[dependent] == 0) {
          queue.offer(dependent);
        }
      }
    }

    return completed == numCourses;
  }
}
