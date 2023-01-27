package programmers.level3.순위;

import java.util.*;

//시간 초과
class Solution {
    HashMap<Integer, Info> map = new HashMap<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, new int[][]{{1, 2}, {3, 4}, {2, 3}}) == 4);
        System.out.println(solution.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}) == 2);
        System.out.println(solution.solution(7, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}, {5, 6}, {6, 7}}) == 4);
        System.out.println(solution.solution(6, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}}) == 6);
        System.out.println(solution.solution(5, new int[][]{{1, 4}, {4, 2}, {2, 5}, {5, 3}}) == 5);
        System.out.println(solution.solution(5, new int[][]{{3, 5}, {4, 2}, {4, 5}, {5, 1}, {5, 2}}) == 1);
        System.out.println(solution.solution(3, new int[][]{{1, 2}, {1, 3}}) == 1);
        System.out.println(solution.solution(6, new int[][]{{1, 6}, {2, 6}, {3, 6}, {4, 6}}) == 0);
        System.out.println(solution.solution(8, new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}) == 0);
        System.out.println(solution.solution(9, new int[][]{{1, 2}, {1, 3}, {1, 4}, {1, 5}, {6, 1}, {7, 1}, {8, 1}, {9, 1}}) == 1);
        System.out.println(solution.solution(6, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {2, 4}, {2, 6}}) == 6);
        System.out.println(solution.solution(4, new int[][]{{4, 3}, {4, 2}, {3, 2}, {3, 1}, {4, 1}, {2, 1}}) == 4);
        System.out.println(solution.solution(3, new int[][]{{3, 2}, {3, 1}}) == 1);
        System.out.println(solution.solution(4, new int[][]{{1, 2}, {1, 3}, {3, 4}}) == 1);
    }

    public int solution(int n, int[][] results) {
        for (int i = 1; i <= n; i++) {
            map.put(i, new Info(i));
        }
        for (int[] result : results) {
            Info bigInfo = map.get(result[0]);
            bigInfo.updateSmall(map.get(result[1]));
        }

        for (Info value : map.values()) {
            dfsDown(value, value.down);
            dfsUp(value, value.up);
        }
        int answer = 0;
        for (Info value : map.values()) {
            if (value.up.size() + value.down.size() + 1 == n) answer++;
        }
        return answer;
    }

    private void dfsDown(Info value, Set<Integer> down) {
        List<Integer> downs = new ArrayList<>(value.down);
        downs.forEach(v -> {
            down.add(v);
            dfsDown(map.get(v), down);
        });
    }
    private void dfsUp(Info value, Set<Integer> up) {
        List<Integer> ups = new ArrayList<>(value.up);
        ups.forEach(v -> {
            up.add(v);
            dfsUp(map.get(v), up);
        });
    }

    class Info {
        int num;
        Set<Integer> up = new HashSet<>();
        Set<Integer> down = new HashSet<>();

        Info(int num) {
            this.num = num;
        }

        public void updateSmall(Info i) {
            this.down.add(i.num);
            i.up.add(this.num);
        }
    }
}
