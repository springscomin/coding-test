package programmers.level3.섬_연결하기;

import java.util.*;

public class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<Edge> edges = new ArrayList<>();

        for (int[] cost : costs) {
            List<Integer> vertexs = new ArrayList<>();
            vertexs.add(cost[0]);
            vertexs.add(cost[1]);
            edges.add(new Edge(vertexs, cost[2]));
        }
        Collections.sort(edges);

        Set<Integer> set = new HashSet<>();
        set.add(edges.get(0).vertexs.get(0));
        while (!edges.isEmpty()) {
            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                int duplicate = edge.getDuplicate(set);
                if (duplicate == 1) {
                    set.addAll(edge.vertexs);
                    answer += edge.weight;
                    edges.remove(edge);
                    break;
                } else if (duplicate == 2) {
                    edges.remove(edge);
                    i--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.solution(5, new int[][]{{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}}));
        System.out.println(solution.solution(7, new int[][]{{2, 3, 7}, {3, 6, 13}, {3, 5, 23}, {5, 6, 25}, {0, 1, 29}, {1, 5, 34}, {1, 2, 35}, {4, 5, 53}, {0, 4, 75}}));
    }
}

class Edge implements Comparable<Edge> {
    List<Integer> vertexs;
    int weight;

    Edge(List<Integer> vertexs, int weight) {
        this.vertexs = vertexs;
        this.weight = weight;
    }

    public int getDuplicate(Set<Integer> set) {
        int count = 0;
        for (Integer vertex : vertexs) {
            if (set.contains(vertex)) count++;
        }
        return count;
    }

    public void addVertexToSet(Set<Integer> set) {
        set.addAll(vertexs);
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
