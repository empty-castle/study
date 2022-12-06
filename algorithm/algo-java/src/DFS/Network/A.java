package DFS.Network;

public class A {

    public static void main(String[] args) {

        /*
        * input
        * */
        int[][] input = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int[][] input2= {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };

        int n = 3;

        int answer = 0;
        boolean[] chk = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!chk[i]) {
                dfs(input2, i, chk);
                answer++;
            }
        }
        System.out.println(answer);

        /*
        *
        * DFS vs BFS
        *
        * 깊이 우선 탐색은 모든 노드를 순회할때 좋다.
        *
        * 너비 우선 탐색은 최단거리를 찾을때 좋다.
        *
        * 하지만 탐색을 진행하는 중에 가중치에 대한 관리를 해줘야 한다면 깊이 우선 탐색이 좋다.
        * 속도는 느릴지 몰라도 코드 구현이 간단.
        *
        * */

    }

    private static void dfs(int[][] input, int start, boolean[] chk) {
        chk[start] = true;
        for (int i = 0; i < input.length; i++) {
            if (!chk[i] && input[start][i] == 1) {
                dfs(input, i, chk);
            }
        }
    }
}
