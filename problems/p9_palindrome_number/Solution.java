package problems.p9_palindrome_number;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.isPalindrome(121));
  }

  public boolean isPalindrome(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }

    int reversedHalf = 0;

    while (x > reversedHalf) {
      reversedHalf = reversedHalf * 10 + (x % 10);
      x /= 10;
    }

    return x == reversedHalf || x == reversedHalf / 10;
  }
}
