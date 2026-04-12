package problems.p3898_find_the_degree_of_each_vertex;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    solution.findDegrees(
        new int[][] {new int[] {0, 1, 1}, new int[] {1, 0, 1}, new int[] {1, 1, 0}});
  }

  public int[] findDegrees(int[][] matrix) {
    int n = matrix.length;
    int[] ans = new int[n];

    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (i != j && matrix[i][j] == 1) count++;
      }
      ans[i] = count;
    }

    return ans;
  }
}
