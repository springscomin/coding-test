package programmers.level1.최소직사각형;

class Solution {
    public int solution(int[][] sizes) {
        int[] big = new int[sizes.length];
        int[] small = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            int[] size = sizes[i];
            int x = size[0];
            int y = size[1];
            big[i] = Math.max(x,y);
            small[i] = Math.min(x,y);
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < sizes.length; i++){
            x = Math.max(big[i], x);
            y = Math.max(small[i], y);
        }
        return x * y;
    }
}
