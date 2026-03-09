package problems.p200_number_of_islands;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

  Set<Integer> set = new HashSet<>();

  static void main() {
    Solution solution = new Solution();
    char[] arr1 = new char[] {'1', '1', '0', '0', '0'};
    char[] arr2 = new char[] {'1', '1', '0', '0', '0'};
    char[] arr3 = new char[] {'0', '0', '1', '0', '0'};
    char[] arr4 = new char[] {'0', '0', '0', '1', '1'};
    char[][] arr5 = new char[][] {arr1, arr2, arr3, arr4};
    System.out.println(solution.numIslands(arr5));
  }

  private static void markIslands(char[][] grid, int x, int y) {
    if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) return;

    if (grid[x][y] != '1') return;

    grid[x][y] = 2;

    markIslands(grid, x - 1, y);
    markIslands(grid, x + 1, y);
    markIslands(grid, x, y - 1);
    markIslands(grid, x, y + 1);
  }

  public int numIslands(char[][] grid) {
    int islands = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          islands++;
          markIslands(grid, i, j);
        }
      }
    }

    return islands;
  }

  // BFS
  public int numIslands2(char[][] grid) {
    int islands = 0;
    int rows = grid.length;
    int cols = grid[0].length;
    Set<String> visited = new HashSet<>();

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == '1' && !visited.contains(r + "," + c)) {
          islands++;
          bfs(grid, r, c, visited, directions, rows, cols);
        }
      }
    }

    return islands;
  }

  private void bfs(
      char[][] grid, int r, int c, Set<String> visited, int[][] directions, int rows, int cols) {
    Queue<int[]> q = new LinkedList<>();
    visited.add(r + "," + c);
    q.add(new int[] {r, c});

    while (!q.isEmpty()) {
      int[] point = q.poll();
      int row = point[0], col = point[1];

      for (int[] direction : directions) {
        int nr = row + direction[0], nc = col + direction[1];
        if (nr >= 0
            && nr < rows
            && nc >= 0
            && nc < cols
            && grid[nr][nc] == '1'
            && !visited.contains(nr + "," + nc)) {
          q.add(new int[] {nr, nc});
          visited.add(nr + "," + nc);
        }
      }
    }
  }
}
