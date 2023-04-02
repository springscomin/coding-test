package leetcode._4Sum_II;

import java.util.*;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> sumMap1 = new HashMap<>();
        HashMap<Integer, Integer> sumMap2 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                sumMap1.put(sum, sumMap1.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < nums3.length; i++){
            for (int j = 0; j < nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                sumMap2.put(sum, sumMap2.getOrDefault(sum, 0) + 1);
            }
        }

        int answer = 0;
        for (int sum : sumMap1.keySet()) {
            answer += sumMap1.get(sum) * sumMap2.getOrDefault(-sum, 0);
        }
        return answer;
    }
}
