package problems.p202_happy_number;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  Set<Integer> set = new HashSet<>();

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.isHappy(2));
  }

  public boolean isHappy(int n) {
    int slow = n;
    int fast = findSum(n);

    while (fast != 1 && slow != fast) {
      slow = findSum(slow);
      fast = findSum(findSum(fast));
    }

    return fast == 1;
  }

  private int findSum(int n) {
    int sum = 0;

    while (n != 0) {
      int digit = n % 10;
      sum += digit * digit;
      n = n / 10;
    }

    return sum;
  }

  public boolean isHappy2(int n) {
    if (set.contains(n)) return false;

    int sum = findSum(n);
    if (sum == 1) return true;
    set.add(n);

    return isHappy2(sum);
  }
}
