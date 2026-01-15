package problems.p189_rotate_array;

public class Solution {
  static void main() {
    int[] nums = {1,2};
    Solution solution = new Solution();
    solution.rotate(nums, 7);
    for (int num: nums) {
      System.out.println(num);
    }
  }

    public static void reverseArray(int[] arr, int start, int end) {
      while(start < end) {
          int temp = arr[start];
          arr[start] = arr[end];
          arr[end] = temp;
          start++;
          end--;
      }
    }

    public void rotate(int[] nums, int k) {
      k %= nums.length;
      reverseArray(nums, 0, nums.length-1);
      reverseArray(nums, 0, k-1);
      reverseArray(nums, k, nums.length-1);
    }
}
