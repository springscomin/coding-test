package programmers.level2.숫자_카드_나누기;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int aGCD = arrayA[0];
        int bGCD = arrayB[0];
        for (int i = 1; i < arrayA.length; i++) {
            aGCD = getGCD(aGCD, arrayA[i]);
            bGCD = getGCD(bGCD, arrayB[i]);
        }
        boolean flag = false;
        for (int a : arrayA) if (a % bGCD == 0) flag = true;
        if (!flag) answer = Math.max(answer, bGCD);

        flag = false;
        for (int b : arrayB) if (b % aGCD == 0) flag = true;
        if (!flag) answer = Math.max(answer, aGCD);

        return answer;
    }

    public int getGCD(int n1, int n2) {
        if (n1 >= n2) return calGCD(n2, n1);
        return calGCD(n1, n2);
    }

    public int calGCD(int n1, int n2) {
        if (n2 % n1 == 0) return n1;
        return calGCD(n2 % n1, n1);
    }
}
