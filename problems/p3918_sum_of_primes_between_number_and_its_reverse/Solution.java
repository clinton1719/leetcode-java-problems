package problems.p3918_sum_of_primes_between_number_and_its_reverse;

import java.util.Arrays;

public class Solution {

  static void main() {
    new Solution().sumOfPrimesInRange(23);
  }

  public int sumOfPrimesInRange(int n) {
    int reversed = 0;
    int original = n;
    while (n != 0) {
      reversed = reversed * 10 + (n % 10);
      n /= 10;
    }

    int start = Math.min(original, reversed);
    int end = Math.max(original, reversed);

    if (end < 2) return 0;

    boolean[] isPrime = new boolean[end + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;

    for (int i = 2; i * i <= end; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= end; j += i) {
          isPrime[j] = false;
        }
      }
    }

    int sum = 0;
    for (int i = start; i <= end; i++) {
      if (isPrime[i]) sum += i;
    }

    return sum;
  }
}
