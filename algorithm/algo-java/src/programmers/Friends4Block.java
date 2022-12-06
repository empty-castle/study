package programmers;

import java.util.ArrayList;
import java.util.List;

public class Friends4Block {

    static String[][] map;

    public static void main(String[] args) {

        int answer = 0;

        int m = 6;
        int n = 6;

        map = new String[m][n];

        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        List<int[]> deletedBlocks = new ArrayList<>();

        // board => map
        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].split("");
        }

        boolean gameEnd = false;

        while (!gameEnd) {
            // board 에서 지울 block 찾기
            for (int i = 0; i < map.length - 1; i++) {
                for (int j = 0; j < map[i].length - 1; j++) {
                    if (map[i][j] == null) {
                        continue;
                    }
                    deletedBlocks.addAll(checkSquare(i, j));
                }
            }

            if (!deletedBlocks.isEmpty()) {
                for (int[] deletedBlock : deletedBlocks) {
                    System.out.println(deletedBlock[0] + "" + deletedBlock[1]);
                }

                // board 에서 black 지우고 기록하기
                for (int[] deletedBlock : deletedBlocks) {
                    if (map[deletedBlock[0]][deletedBlock[1]] != null) {
                        answer++;
                    }
                    map[deletedBlock[0]][deletedBlock[1]] = null;
                }
                deletedBlocks.clear();
                rearrangement(m, n);
            } else {
                gameEnd = true;
            }
        }

        System.out.println("answer::" + answer);
    }

    static List<int[]> checkSquare(int x, int y) {

        boolean isSquare = true;
        List<int[]> square = new ArrayList<>();
        square.add(new int[]{x, y});

        int[] nextX = {0, 1, 1};
        int[] nextY = {1, 0, 1};
        String keyword = map[x][y];
        int len = nextX.length;
        for (int i = 0; i < len; i++) {
            if (map[x + nextX[i]][y + nextY[i]] == null || !map[x + nextX[i]][y + nextY[i]].equals(keyword)) {
                isSquare = false;
                break;
            }
            square.add(new int[]{x + nextX[i], y + nextY[i]});
        }

        if (!isSquare) {
            square.clear();
        }
        return square;
    }

    static void rearrangement(int m, int n) {
        for (int j = 0; j < n; j++) {
            int nullCnt = 0;
            for (int i = m - 1; i >= 0; i--) {
                if (map[i][j] == null) {
                    nullCnt++;
                    continue;
                }
                if (nullCnt > 0) {
                    map[i + nullCnt][j] = map[i][j];
                    map[i][j] = null;
                }
            }
        }
    }
}
