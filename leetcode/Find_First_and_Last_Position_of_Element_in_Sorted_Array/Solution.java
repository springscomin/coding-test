package leetcode.Find_First_and_Last_Position_of_Element_in_Sorted_Array;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int pi = 0, pf = nums.length - 1;
        int ai = -1, af = -1;

        while (pi <= pf) {
            int mid = (pi + pf) / 2;
            if (nums[mid] == target) {
                ai = mid;
                while(ai - 1 >= 0 && nums[ai] == nums[ai - 1]) ai--;
                af = mid;
                while(af + 1 < nums.length && nums[af] == nums[af + 1]) af++;
                break;
            } else if (nums[mid] > target) pf = mid - 1;
            else pi = mid + 1;
        }
        return new int[]{ai, af};
    }
}
