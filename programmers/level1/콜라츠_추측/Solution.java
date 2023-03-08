package programmers.level1.콜라츠_추측;

class Solution {
    public int solution(int num) {
        long n = num;
        for (int i = 0; i <= 500; i++) {
            if (n == 1) return i;
            if (n % 2 == 0) n /= 2;
            else {
                n = 3 * n + 1;
            }
        }
        return -1;
    }
}
