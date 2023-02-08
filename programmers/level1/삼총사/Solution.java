package programmers.level1.삼총사;

import java.util.Arrays;

class Solution {
    int[] arr = new int[3];
    int[] nums;
    int answer = 0;

    public int solution(int[] number) {
        nums = number;
        dfs(0, 0, 0);
        return answer;
    }

    public void dfs(int idx, int count, int sum) {
        if (count == 3) {
            print();
            if (sum == 0) answer++;
        } else {
            for (int i = idx; i < nums.length; i++) {
                arr[count] = nums[i];
                dfs(i + 1, count + 1, sum + nums[i]);
            }
        }
    }

    private void print() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 3, 4, 5}));
    }
}
