package leetcode.Search_in_Rotated_Sorted_Array;

class Solution {
    public int search(int[] nums, int target) {
        int pi = 0;
        int pf = nums.length - 1;

        while(pi <= pf) {
            int pm = (pi + pf) / 2;
            if (nums[pm] == target) return pm;
            if (nums[pm] > target) {
                if (nums[pm] > nums[pf] && nums[pi] > target) pi = pm + 1;
                else pf = pm - 1;
            } else {
                if (nums[pi] > nums[pm] && target > nums[pf]) pf = pm - 1;
                else pi = pm + 1;
            }
        }
        return -1;
    }
}
