package leetcode._3Sum;

import java.util.*;

class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> set = new HashSet<>();

        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (nums[i] == -2) {
                System.out.println();
            }
            map.put(nums[i], map.get(nums[i]) - 1);
            for (int j = i + 1; j < nums.length; j++) {
                map.put(nums[j], map.get(nums[j]) - 1);
                if (nums[i] + nums[j] <= 0) {
                    int remain = -nums[i] - nums[j];
                    if (map.getOrDefault(remain, 0) > 0) {
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(remain);
                        Collections.sort(triplet);
                        set.add(triplet);
                    }
                }
                map.put(nums[j], map.get(nums[j]) + 1);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        return new ArrayList<>(set);
    }



    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumSorted(i + 1, nums.length - 1, nums, 0 - nums[i]);
            }
        }
        return res;
    }

    void twoSumSorted(int i, int j, int nums[], int target) {
        int a1 = nums[i - 1];
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                List<Integer> list = new ArrayList();
                list.add(a1);
                list.add(nums[i]);
                list.add(nums[j]);
                res.add(list);
                while (i < j && nums[i] == nums[i + 1]) i++;
                while (i < j && nums[j] == nums[j - 1]) j--;
                i++;
                j--;
            }
        }
    }
}
