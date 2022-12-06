package Graph.Number_of_islands;

public class A {

    private static String[][] map;
    private static int X;
    private static int Y;

    public static void main(String[] args) {
        /*
        * input
        * */
        String[] input = new String[]{
                "1 1",
                "0",
                "2 2",
                "0 1",
                "1 0",
                "3 2",
                "1 1 1",
                "1 1 1",
                "5 4",
                "1 0 1 0 0",
                "1 0 0 0 0",
                "1 0 1 0 1",
                "1 0 0 1 0",
                "5 4",
                "1 1 1 0 1",
                "1 0 1 0 1",
                "1 0 1 0 1",
                "1 0 1 1 1",
                "5 5",
                "1 0 1 0 1",
                "0 0 0 0 0",
                "1 0 1 0 1",
                "0 0 0 0 0",
                "1 0 1 0 1",
                "0 0"
        };
        // x(width) y(height) 정리
        int firstLine = 0;
        while (true) {
            String[] xy = input[firstLine].split(" ");
            X = Integer.valueOf(xy[1]);
            Y = Integer.valueOf(xy[0]);
            int answer = 0;
            // x, y 가 모두 0 이면 테스트 종료
            if (X == 0 && Y == 0) {
                System.out.println("끝!");
                return;
            }
            map = new String[X][Y]; // 지도 변환
            // 주어진 map 을 이용하기 좋게 변환
            int lineNum = 0;
            for (int i = firstLine + 1; i <= firstLine + X; i++) {
                String[] line = input[i].split(" ");
                int lineLen = line.length;
                for (int j = 0; j < lineLen; j++) {
                    map[lineNum][j] = line[j];
                }
                lineNum++;
            }
            // island search
            for (int i = 0; i < X; i++) {
                for (int j = 0; j < Y; j++) {
                    if (map[i][j].equals("1")) {
                        SearchAround(i, j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
            firstLine = firstLine + X + 1;
        }
    }

    private static void SearchAround(int x, int y) {
        map[x][y] = "0";
        // 주변 8칸에 대한 좌표 이동
        int[] aroundX = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int[] aroundY = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        int aroundLen = aroundX.length;
        for (int i = 0; i < aroundLen; i++) {
            int nextLocX = x + aroundX[i];
            int nextLocY = y + aroundY[i];
            if (X <= nextLocX || Y <= nextLocY || nextLocX == -1 || nextLocY == -1 ) {
                continue;
            }
            if (map[nextLocX][nextLocY].equals("1")) {
                SearchAround(nextLocX, nextLocY);
            }
        }
    }
}
