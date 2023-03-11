package programmers.level1._3진법_뒤집기;

class Solution {
    public int solution(int n) {
        String three = changeToThree(n);
        int answer = 0;
        int temp = 1;
        for (String number : three.split("")) {
            int times = Integer.parseInt(number);
            answer += temp * times;
            temp *= 3;
        }

        return answer;
    }
    public String changeToThree(int n) {
        String s = "";
        while (n != 0){
            s = n % 3 + s;
            n /= 3;
        }
        return s;
    }
}
