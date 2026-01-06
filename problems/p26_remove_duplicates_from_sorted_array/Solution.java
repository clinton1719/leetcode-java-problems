package problems.p26_remove_duplicates_from_sorted_array;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;

        for (int j = 1; j<nums.length; j++) {
            if(nums[i-1] < nums[j]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    static void main() {
        int[] nums = {0,1,2,2};
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(nums));
    }
}
