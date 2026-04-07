package problems.p151_reverse_words_in_a_string;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.reverseWords("the sky is blue"));
  }

  public String reverseWords(String s) {
    char[] arr = s.trim().toCharArray();
    int n = arr.length;
    int left = 0, right = n - 1;

    while (left < right) {
      char temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }

    left = 0;
    right = 0;
    StringBuilder result = new StringBuilder();
    while (left < n) {
      while (right < n && arr[right] != ' ') {
        right++;
      }
      int reverse = right - 1;

      while (reverse >= left) {
        result.append(arr[reverse--]);
      }
      result.append(' ');

      while (right < n && arr[right] == ' ') {
        right++;
      }
      left = right;
    }
    result.deleteCharAt(result.length()-1);

    return result.toString();
  }

  public String reverseWords2(String s) {
    String[] arr = s.trim().split(" ");
    StringBuilder result = new StringBuilder();

    for (int i = arr.length - 1; i > 0; i--) {
      if (!arr[i].isBlank()) {
        result.append(arr[i]).append(" ");
      }
    }
    result.append(arr[0]);

    return result.toString();
  }
}
