package Graph.Ranking;

public class A {

    public static void main(String[] args) {

        /*
        * input
        * */
        int n = 5;
        int[][] results = {{4, 3}, {2, 4}, {3, 2}, {1, 2}, {2, 5}};
        int answer = 0;

        // input 을 테이블로 전환
        boolean[][] table = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            // true 이겻다
            table[results[i][0] - 1][results[i][1] - 1] = true;
        }
        // 플로이드 워셜 알고리즘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j != k && table[j][i] && table[i][k]) {
                        table[j][k] = true;
                    }
                }
            }
        }
        //
        for (int i = 0; i < n; i++) {
            boolean pass = true;
            for (int j = 0; j < n; j++) {
                if (i != j && !(table[i][j] || table[j][i])) {
                    pass = false;
                    break;
                }
            }
            if (pass) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
