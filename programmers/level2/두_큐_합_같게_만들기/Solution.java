package programmers.level2.두_큐_합_같게_만들기;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum = 0;
        int idx = 0;
        int[] arr = new int[queue1.length + queue2.length];
        for (int n : queue1) {
            arr[idx++] += n;
            sum += n;
        }
        for (int n : queue2) {
            arr[idx++] += n;
            sum += n;
        }
        if (sum % 2 != 0) return -1;
        sum /= 2;

        int start = 0;
        int last = queue1.length;
        long s = 0;
        for (int i = start; i < last; i++) s += arr[i];

        int answer = 0;
        while (start <= last && last < arr.length) {
            if (sum == s) return answer;
            else if (s > sum) s -= arr[start++];
            else s += arr[last++];
            answer++;
        }
        return -1;
    }
}
