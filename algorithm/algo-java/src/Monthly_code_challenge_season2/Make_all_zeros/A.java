package Monthly_code_challenge_season2.Make_all_zeros;

import java.util.ArrayList;

public class A {

    long answer;
    ArrayList<Integer>[] tree;
    long[] long_a;
    boolean[] visited;

    public long solution(int[] a, int[][] edges) {

        answer = 0;
        long_a = new long[a.length];
        tree = new ArrayList[a.length];
        visited = new boolean[a.length];

        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            long_a[i] = a[i];
            tree[i] = new ArrayList<>();
        }

        if (sum != 0) {
            return -1;
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        dfs(0);

        return answer;
    }

    private long dfs(int v) {
        visited[v] = true;
        for (int i = 0; i < tree[v].size(); i++) {
            int next = tree[v].get(i);
            if (!visited[next]) {
                long_a[v] += dfs(next);
            }
        }

        answer += Math.abs(long_a[v]);

        return long_a[v];
    }

    public static void main(String[] args) {
        A A = new A();
        int[] a = new int[]{-5, 0, 2, 1, 2};
        int[][] edges = {
                {0, 1},
                {3, 4},
                {2, 3},
                {0, 3}
        };
        A.solution(a, edges);
    }
}