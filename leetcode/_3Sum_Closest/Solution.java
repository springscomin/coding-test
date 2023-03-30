package leetcode._3Sum_Closest;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int answer = target >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int pi = i + 1;
            int pf = nums.length - 1;

            while(pi < pf) {
                int sum = nums[i] + nums[pi] + nums[pf];
                if (sum == target) return sum;
                if (Math.abs(answer - target) > Math.abs(sum - target)) answer = sum;
                if (sum > target) pf--;
                else pi++;
            }
        }
        return answer;
    }
}
