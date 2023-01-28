package programmers.level2.스킬트리;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("CBD", new String[]{"C", "D", "CB", "BDA"}));
    }
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skill_tree : skill_trees) {
            int[] index = new int[skill.length()];
            for (int i = 0; i < skill.length(); i++) {
                index[i] = skill_tree.indexOf(skill.charAt(i));
            }
            int lastIdx = -1;
            for (int i = skill.length() - 1; i >= 0; i--){
                if (index[i] != -1) {
                    lastIdx = i;
                    break;
                }
            }
            boolean can = true;
            for (int i = lastIdx - 1; i >= 0; i--){
                if (index[i] == -1 || index[lastIdx] < index[i]) {
                    can = false;
                    break;
                }
                lastIdx = i;
            }
            if (can) answer++;
        }
        return answer;
    }
}
