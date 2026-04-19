package problems.p3905_multi_source_flood_fill;

import java.util.*;

public class Solution {
  int[] rowDir = new int[] {-1, 1, 0, 0};
  int[] colDir = new int[] {0, 0, -1, 1};

  static void main() {
    Solution solution = new Solution();
    solution.colorGrid(3, 3, new int[][] {new int[] {0, 0, 1}, new int[] {2, 2, 2}});
  }

  public int[][] colorGrid(int n, int m, int[][] sources) {
    int[][] result = new int[n][m];
    Queue<int[]> queue = new LinkedList<>();

    for (int[] arr : sources) {
      result[arr[0]][arr[1]] = arr[2];
      queue.offer(new int[] {arr[0], arr[1]});
    }

    while (!queue.isEmpty()) {
      int length = queue.size();
      Map<Integer, Integer> largestColorMap = new HashMap<>();

      for (int i = 0; i < length; i++) {
        int[] index = queue.poll();
        if (index == null) {
          continue;
        }
        int coloredValue = result[index[0]][index[1]];

        for (int j = 0; j < 4; j++) {
          int newRow = index[0] + rowDir[j];
          int newCol = index[1] + colDir[j];

          if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) {
            continue;
          }

          if (result[newRow][newCol] == 0) {
            int newIndex = (newRow * m) + newCol;
            if (largestColorMap.getOrDefault(newIndex, 0) < coloredValue) {
              largestColorMap.put(newIndex, coloredValue);
            }
          }
        }
      }

      for (Map.Entry<Integer, Integer> entry : largestColorMap.entrySet()) {
        int row = entry.getKey() / m;
        int col = entry.getKey() % m;
        result[row][col] = entry.getValue();
        queue.offer(new int[] {row, col});
      }
    }

    return result;
  }
}
