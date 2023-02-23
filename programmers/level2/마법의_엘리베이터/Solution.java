package programmers.level2.마법의_엘리베이터;

class Solution {
    public int solution(int storey) {
        return cal(storey, 0);
    }

    public int cal(int number, int answer) {
        if (number == 0) return answer;
        int share = number / 10;
        int remaining = number % 10;

        if (remaining == 5 && share % 10 >= 5) return cal(share + 1, answer + remaining);
        if (remaining > 5) return cal(share + 1, answer + 10 - remaining);
        return cal(share, answer + remaining);
    }
}
