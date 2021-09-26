package dijkstra.Algospot;

import java.util.Comparator;
import java.util.PriorityQueue;

public class A {

    private static class Loc {
        int x, y, cnt;

        Loc(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")" + "[" + cnt + "]";
        }
    }

    public static void main(String[] args) {

        /*
        * input
        * */
        String[] input = {
//                "3 3",
//                "011",
//                "111",
//                "110"

                "4 2",
                "0001",
                "1000"

//                "6 6",
//                "001111",
//                "010000",
//                "001111",
//                "110001",
//                "011010",
//                "100010"
        };

        int INF = Integer.MAX_VALUE; // 무한 값
        String[] NM = input[0].split(" ");
        int N = Integer.valueOf(NM[1]);
        int M = Integer.valueOf(NM[0]);
        // 상하좌우
        int[] X = {1, 0, -1, 0};
        int[] Y = {0, 1, 0, -1};
        // 입력값을 N * M 형태의 이차원 배열로 재구성
        int[][] maze = new int[N][M];
        for (int i = 1; i < input.length; i++) {
            String[] rooms = input[i].split("");
            for (int j = 0; j < M; j++) {
                maze[i - 1][j] = Integer.valueOf(rooms[j]);
            }
        }
        // 거리값 배열 초기화
        int[][] dist = new int[N][M];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                dist[i][j] = INF;
            }
        }
        dist[0][0] = 0;
        // 시작점 설정
        PriorityQueue<Loc> pq = new PriorityQueue<>(Comparator.comparingInt(loc -> loc.cnt));
        pq.offer(new Loc(0,0, dist[0][0]));
        // 다익스트라 알고리즘
        while (!pq.isEmpty()) {
            Loc curLoc = pq.poll();
            if (curLoc != null) {
                for (int i = 0; i < 4; i++) {
                    int nX = curLoc.x + X[i];
                    int nY = curLoc.y + Y[i];
                    // index out 검증
                    if (nX >= N || 0 > nX || nY >= M || 0 > nY) {
                        continue;
                    }
                    if (dist[nX][nY] > curLoc.cnt + maze[nX][nY]) {
                        dist[nX][nY] = curLoc.cnt + maze[nX][nY];
                        pq.offer(new Loc(nX, nY, dist[nX][nY]));
                    }
                }
            }
        }
        // 백준은 결과가 String 이어야 된다. ㅠㅠ
        System.out.println(String.valueOf(dist[N - 1][M - 1]));
    }
}
