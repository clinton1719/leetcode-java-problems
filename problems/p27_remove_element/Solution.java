package problems.p27_remove_element;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return right;
    }


    static void main() {
        int[] nums = {3,3};
        int val = 5;
        Solution solution = new Solution();
        System.out.println(solution.removeElement(nums, val));
    }
}
