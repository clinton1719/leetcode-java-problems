package problems.p242_valid_anagram;

public class Solution {
  static void main() {
    int[] nums = {1, 2};
    Solution solution = new Solution();
    System.out.println(solution.isAnagram("rat", "car"));
  }

  public boolean isAnagram(String s, String t) {
    int[] sArr = new int[26];
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
      sArr[s.charAt(i) - 'a']++;
      count++;
    }

    for (int i = 0; i < t.length(); i++) {
      sArr[t.charAt(i) - 'a']--;

      if (sArr[t.charAt(i) - 'a'] < 0) {
        return false;
      }

      count--;
    }

    return count == 0;
  }
}
