package problems.p3959_check_good_integer;


public class Solution {

  static void main() {
    new Solution().checkGoodInteger(1000);
  }

  public boolean checkGoodInteger(int n) {
    int digitSum = 0;
    int squareSum = 0;

    while(n != 0) {
      int digit = n % 10;

      digitSum += digit;
      squareSum += digit*digit;

      n = n / 10;
    }

    return squareSum - digitSum >= 50;
  }
  
}
