package problems.p3896_minimum_operations_to_transform_array_into_alternating_prime;


public class Solution {

  public int minOperations(int[] nums) {
    int ops = 0;

    for (int i = 0; i < nums.length; i++) {
      int val = nums[i];

      if (i % 2 == 0) {
        // want prime
        if (!isPrime(val)) {
          int target = nextPrime(val);
          ops += target - val;
        }
      } else {
        // want prime
        if (isPrime(val)) {
          int target = nextNonPrime(val);
          ops += target - val;
        }
      }
    }

    return ops;
  }

  private static boolean isPrime(int n) {
    if (n < 2)
      return false;

    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0)
        return false;
    }

    return true;
  }

  private static int nextPrime(int n) {
    while (!isPrime(n))
      n++;
    return n;
  }

  private static int nextNonPrime(int n) {
    while (isPrime(n))
      n++;
    return n;
  }
}
