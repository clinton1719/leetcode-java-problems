package problems.p3932_count_k_th_roots_in_a_range;

public class Solution {

  static void main() {
    new Solution().countKthRoots(1, 9, 3);
  }

  public int countKthRoots(int l, int r, int k) {
    int lRoot = (int) Math.ceil(Math.pow(l, 1.0 / k) - 1e-10);
    int rRoot = (int) Math.floor(Math.pow(r, 1.0 / k) + 1e-10);

    return Math.max(0, rRoot - lRoot + 1);
  }
}
