package theory.floyd_warshall;

public class A {

    public static void main(String[] args) {
        int INF = 10000; // 가장 큰 숫자
        int[][] table = {
                {0, 1, 2, 7},
                {9, 0, INF, INF},
                {INF, 5, 0, 6},
                {8, INF, 4, 0}
        };

        int tableLen = table.length;
        // i 거쳐가는 노드
        for (int i = 0; i < tableLen; i++) {
            // j 출발 노드
            for (int j = 0; j < tableLen; j++) {
                // k 도착 노드
                for (int k = 0; k < tableLen; k++) {
                    if (table[j][k] > table[j][i] + table[i][k]) {
                        table[j][k] = table[j][i] + table[i][k];
                    }
                }
            }
        }
        // 출력
        for (int[] ints : table) {
            for (int j = 0; j < tableLen; j++) {
                System.out.printf("%3d ", ints[j]);
            }
            System.out.println("\n");
        }
    }
}
