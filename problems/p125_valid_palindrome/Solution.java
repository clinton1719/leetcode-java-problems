package problems.p125_valid_palindrome;

public class Solution {
  static final int lowNum = 48, highNum = 57, lowAlpha = 97, highAlpha = 122;

  private static boolean isAlphaNumeric(int value1) {
    return ((value1 >= lowNum && value1 <= highNum) || (value1 >= lowAlpha && value1 <= highAlpha));
  }

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama") ? "true" : "false");
  }

  public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    s = s.toLowerCase();

    while (left < right) {

      while (left < right && !isAlphaNumeric(s.charAt(left))) left++;
      while (left < right && !isAlphaNumeric(s.charAt(right))) right--;

      if (s.charAt(left) != s.charAt(right)) return false;

      left++;
      right--;
    }

    return true;
  }
}
