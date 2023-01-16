package programmers.level2.n2_배열_자르기;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(3, 2, 5);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        int[] answer = new int[(int)(right - left + 1)];
        for (int i = 0; i < size; i++) {
            int row = (int) (left/ n);
            int col = (int) (left % n);
            answer[i] = Math.max(row, col) + 1;
            left++;
        }
        return answer;
    }
}
