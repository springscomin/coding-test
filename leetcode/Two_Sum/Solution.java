package leetcode.Two_Sum;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int element = nums[j];
                if (remain == element) return new int[]{i, j};
            }
        }
        return null;
    }
}
