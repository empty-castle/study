package steppay;

/*
*
* 실패
*
* 사각형을 셈할때 중복되지 않게 어떻게 계산?
*   Square Model 을 생성해서 비교?
*   단순히 2차원 배열로 생각해서는 안될 문제
* */

import java.util.HashSet;
import java.util.Set;

public class step2 {

    static int[] node = {500, 500};
    static int[][] map = new int[1000][1000];
    static int answer = 0;
    static Set<int[]> crossPoint = new HashSet<>();

    public static void main(String[] args) {

        String[] moves = {"U", "R", "D", "L", "U", "R", "D", "L"};
        mark();

        for (int i = 0; i < moves.length; i++) {
            moveNode(moves[i]);
            mark();
        }
        checkSquare(node);
        System.out.println(answer);
    }

    private static void moveNode(String move) {
        switch (move) {
            case "U":
                node[0]--;
                break;
            case "R":
                node[1]++;
                break;
            case "D":
                node[0]++;
                break;
            case "L":
                node[1]--;
                break;
        }
    }

    private static void mark() {
        map[node[0]][node[1]] = 1;
    }

    private static void checkSquare(int[] node) {

        /*
        *
        * [-1 -1] [-1 0] [-1 1]
        *
        * [0 -1] [0 0]  [0 1]
        *
        * [1 -1] [1 0]  [1 1]
        *
        * */

        if (map[node[0]][node[1]] == 1) {
            int[] aroundX = new int[]{-1, 1, 1, -1};
            int[] aroundY = new int[]{1, 1, -1, -1};
            int len = aroundY.length;

            for (int i = 0; i < len; i++) {
                int nextX = node[0] + aroundX[i];
                int nextY = node[1] + aroundY[i];
                if (map[nextX][nextY] == 1 && map[nextX][node[1]] == 1 && map[node[0]][nextX] == 1) {
                    answer++;
                }
            }
        }
    }
}
