package leetcode.Container_With_Most_Water;

class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int frontIdx = 0;
        int endIdx = height.length - 1;
        while (frontIdx < endIdx) {
            int contain = (endIdx - frontIdx) * Math.min(height[frontIdx], height[endIdx]);
            if (contain > answer) answer = contain;
            if (height[frontIdx] > height[endIdx]) endIdx--;
            else frontIdx++;
        }
        return answer;
    }
}
