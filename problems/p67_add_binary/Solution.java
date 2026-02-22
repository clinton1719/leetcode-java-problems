package problems.p67_add_binary;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.addBinary("11", "1"));
  }

  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int i = a.length()-1;
    int j = b.length()-1;
    int carry = 0;
    int sum;

    while (i >= 0 || j >= 0) {
      sum = carry;
      if (i >= 0) {
        sum += a.charAt(i) - '0';
      }
      if (j >= 0) {
        sum += b.charAt(j) - '0';
      }
      sb.append(sum % 2);
      carry = sum / 2;

      i--;
      j--;
    }

    if (carry != 0) sb.append(carry);

    return sb.reverse().toString();
  }
}
