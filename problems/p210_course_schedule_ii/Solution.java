package problems.p210_course_schedule_ii;

import java.util.*;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    solution.findOrder(2, new int[][] {new int[] {1, 0}});
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
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

    int[] answer = new int[numCourses];
    int index = 0;

    while (!queue.isEmpty()) {
      int zero_indegree_course = queue.poll();
      answer[index++] = zero_indegree_course;

      for (int course : graph.get(zero_indegree_course)) {
        indegrees[course]--;

        if (indegrees[course] == 0) {
          queue.add(course);
        }
      }
    }

    return (index != numCourses) ? new int[] {} : answer;
  }
}
