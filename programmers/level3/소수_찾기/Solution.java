package programmers.level3.소수_찾기;

import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("011"));
    }
    char[] nums;
    boolean[] check;
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        nums = numbers.toCharArray();
        check = new boolean[nums.length];
        dfs(0, "");
        set.remove(0);
        set.remove(1);
        int answer = set.size();
        for (int i : set) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }


    public void dfs(int index, String val){
        if (index == nums.length){
            set.add(Integer.parseInt(val));
        } else {
            for (int i = 0; i < nums.length; i++){
                if (!check[i]) {
                    check[i] = true;
                    dfs(index + 1, val + nums[i]);
                    check[i] = false;
                } else {
                    dfs(index + 1, val);
                }

            }
        }
    }
}
