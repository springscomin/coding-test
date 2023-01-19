package programmers.level4.올바른_괄호의_개수;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3));
        System.out.println(solution.solution(4));
        System.out.println(solution.solution(5));
    }
    int[][] memo;

    public int solution(int n) {
        memo = new int[n + 1][n + 1];
        return sol(n, n);
    }

    public int sol(int a, int b) {
        if (a < b) return memo[a][b];
        if (memo[a][b] != 0) return memo[a][b];
        if (a == 1 || b == 0) return memo[a][b] = 1;
        int answer = 0;
        for (int i = 0; i <= b; i++) answer += sol(a - 1, i);
        return answer;
    }
}
//         내가 생각한 풀이 방법
//         닫는 괄호의 위치를 정하는 방식을 사용.

//           ###  풀이에서 사용한 memo는   memo[닫는 괄호가 들어갈 수 있는 위치의 개수][넣어야할 닫는 괄호 개수] 로 정의 ###
//         ex) 괄호가 3쌍
//         여는 괄호 ( v ( v ( v
//         v의 위치에 닫는 괄호 3개가 들어가야함.
//         즉 v 3칸안에 닫는 괄호가 3개가 들어가야함. memo[3][3]
//         3번째 위치에 닫는 괄호가 3개 2개 1개, 0개가 들어갈 수 있음. -> 그렇다면 나머지 2칸에 들어가야 하는 닫는 괄호의 개수는 각각 0, 1, 2, 3이 됨.

//         ### 3번째 위치에 닫는 괄호가 3개 들어갈 경우 -> 나머지 2칸( 1, 2 위치)에 닫는 괄호가 0개 들어감 -> 경우의 수 1개  memo[2][0] = 1
//         3번째 위치에 닫는 괄호가 2개 들어갈 경우 -> 나머지 2칸( 1, 2 위치)에 닫는 괄호가 1개 들어감 -> memo[2][1] = ?
//         3번째 위치에 닫는 괄호가 1개 들어갈 경우 -> 나머지 2칸( 1, 2 위치)에 닫는 괄호가 2개 들어감 -> memo[2][2] = ?
//         ### 3번째 위치에 닫는 괄호가 0개 들어갈 경우 -> 나머지 2칸( 1, 2 위치)에 닫는 괄호가 3개 들어가야하지만 올바른 괄호쌍이 만들어질 수 없음. ex) (()))(, ())()( ..
//                          memo[2][3] = 0   즉, 닫는 괄호가 들어갈 수 있는 위치의 개수보다 넣어야할 닫는 괄호 개수가 더 많은 경우  올바른 괄호쌍 만들어질 수 없음.
//                          a < b -> memo[a][b] = 0
//         => memo[3][3] = (memo[2][0] = 1) + memo[2][1] + memo[2][2] + (memo[2][3] = 0)
//
//         memo[2][2] 도 위와 같은 방식으로 2번째 위치에는 닫는 괄호 2개, 1개, 0개가 들어갈 수 있음. -> 남은 한칸에 들어가야할 괄호의 개수는 각각 0, 1, 2개가 됨.
//         memo[2][2] = memo[1][0]  + memo[1][1] + (memo[1][2] = 0)
//                        남은 칸수가 1개인 경우 1가지 경우 밖에 없음.
//                        memo[1][0] = 0, memo[1][1] = 0

//         memo[2][1] = memo[1][0] + memo[1][1]

//        ex2)
//        memo[4][4] = (memo[3][0] = 1) + memo[3][1] + memo[3][2] + memo[3][3] + (memo[3][4] = 0)
//                        memo[3][1] = (memo[2][0] = 1)  +  memo[2][1]
//                                    memo[2][1] = (memo[1][0] = 1) + (memo[1][1] = 1) = 2
//                        memo[3][2] = (memo[2][0] = 1)  + memo[2][1] + memo[2][2]
//                                    memo[2][1] = 2 은 위에서 구함
//                                    memo[2][2] = (memo[1][0] = 1) + (memo[1][1] = 1) + (memo[1][0] = 0) = 2
//                        memo[3]3] = (memo[2][0] = 1)  + memo[2][1] + memo[2][2] + (memo[2][3] = 0)
//                                    memo[2][1] = 2, memo[2][2] = 2 은 위에서 구함
