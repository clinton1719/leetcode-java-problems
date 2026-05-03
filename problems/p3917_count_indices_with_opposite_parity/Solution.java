package problems.p3917_count_indices_with_opposite_parity;

public class Solution {

  static void main() {
    new Solution().countOppositeParity(new int[] {1, 2, 3, 4});
  }

  public int[] countOppositeParity(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];

    int evenCount = 0;
    int oddCount = 0;

    for (int i = n - 1; i >= 0; i--) {
      if (nums[i] % 2 == 0) {
        answer[i] = oddCount;
        evenCount++;
      } else {
        answer[i] = evenCount;
        oddCount++;
      }
    }

    return answer;
  }
}
