package problems.p427_construct_quad_tree;

public class Solution {
  // space optimization
  private final Node falseLeaf = new Node(false, true);
  private final Node trueLeaf = new Node(true, true);

  static void main() {
    Solution solution = new Solution();
    solution.construct(new int[][] {new int[] {0, 1}, new int[] {1, 0}});
  }

  public Node construct(int[][] grid) {
    return dfs(grid, 0, 0, grid.length);
  }

  private Node dfs(int[][] grid, int row, int col, int n) {
    boolean isLeaf = true;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[row][col] != grid[i + row][j + col]) {
          isLeaf = false;
          break;
        }
      }
    }

    if (isLeaf) {
      return new Node(grid[row][col] == 1, true);
    }

    int newN = n / 2;
    Node topLeft = dfs(grid, row, col, newN);
    Node topRight = dfs(grid, row, col + newN, newN);
    Node bottomLeft = dfs(grid, row + newN, col, newN);
    Node bottomRight = dfs(grid, row + newN, col + newN, newN);

    return new Node(grid[row][col] == 1, false, topLeft, topRight, bottomLeft, bottomRight);
  }

  private Node dfsOptimized(int[][] grid, int row, int col, int n) {
    if (n == 1) {
      return new Node(grid[row][col] == 1, true);
    }

    int mid = n / 2;
    Node topLeft = dfs(grid, row, col, mid);
    Node topRight = dfs(grid, row, col + mid, mid);
    Node bottomLeft = dfs(grid, row + mid, col, mid);
    Node bottomRight = dfs(grid, row + mid, col + mid, mid);

    if (topLeft.isLeaf
        && topRight.isLeaf
        && bottomLeft.isLeaf
        && bottomRight.isLeaf
        && topLeft.val == topRight.val
        && topRight.val == bottomLeft.val
        && bottomLeft.val == bottomRight.val) {
      return new Node(grid[row][col] == 1, true);
    }
    return new Node(grid[row][col] == 1, false, topLeft, topRight, bottomLeft, bottomRight);
  }

  private Node dfsSpaceOptimized(int[][] grid, int row, int col, int n) {
    if (n == 1) {
      return grid[row][col] == 1 ? trueLeaf : falseLeaf;
    }

    int mid = n / 2;
    Node topLeft = dfs(grid, row, col, mid);
    Node topRight = dfs(grid, row, col + mid, mid);
    Node bottomLeft = dfs(grid, row + mid, col, mid);
    Node bottomRight = dfs(grid, row + mid, col + mid, mid);

    if (topLeft.isLeaf
        && topRight.isLeaf
        && bottomLeft.isLeaf
        && bottomRight.isLeaf
        && topLeft.val == topRight.val
        && topRight.val == bottomLeft.val
        && bottomLeft.val == bottomRight.val) {
      return topLeft;
    }
    return new Node(grid[row][col] == 1, false, topLeft, topRight, bottomLeft, bottomRight);
  }

  class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
      this.val = false;
      this.isLeaf = false;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(
        boolean val,
        boolean isLeaf,
        Node topLeft,
        Node topRight,
        Node bottomLeft,
        Node bottomRight) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = topLeft;
      this.topRight = topRight;
      this.bottomLeft = bottomLeft;
      this.bottomRight = bottomRight;
    }
  }
}
