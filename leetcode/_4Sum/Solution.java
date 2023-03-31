package leetcode._4Sum;

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                long s = nums[i] + nums[j];
                int l = j + 1;
                int r = nums.length - 1;
                while(l < r) {
                    long sum = s + nums[l] + nums[r];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        set.add(list);
                        while (l + 1 < nums.length && nums[l] == nums[++l]) ;
                        while (r - 1 >= 0 && nums[r] == nums[--r]) ;
                    } else if (sum < target) l++;
                    else r--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
