package floyd_warshall.Delivery;

public class A {

    private static class Route {
        int w;
        String path;

        Route(int cost, String path) {
            this.w = cost;
            this.path = path;
        }

        @Override
        public String toString() {
//            return w + "";
            return path + " ";
        }
    }

    public static void main(String[] args) {

        /*
        * input
        * */
        String[] input = {
                "6 10",
                "1 2 2",
                "1 3 1",
                "2 4 5",
                "2 5 3",
                "2 6 7",
                "3 4 4",
                "3 5 6",
                "3 6 7",
                "4 6 4",
                "5 6 2"
        };

        String[] NM = input[0].split(" ");
        int N = Integer.valueOf(NM[0]);
        // input 재구성
        Route[][] map = new Route[N][N];
        for (int i = 1; i < input.length; i++) {
            String[] line = input[i].split(" ");
            int x = Integer.valueOf(line[0]);
            int y = Integer.valueOf(line[1]);
            int w = Integer.valueOf(line[2]);
            map[x - 1][y - 1] = new Route(w, y + "");
            map[y - 1][x - 1] = new Route(w, x + "");
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i == j) {
                    map[i][j] = new Route(0, "-");
                } else if (map[i][j] == null) {
                    map[i][j] = new Route(Integer.MAX_VALUE, "-");
                }
            }
        }
        // 플로이드
        int mapLen = map.length;
        for (int i = 0; i < mapLen; i++) {
            for (int j = 0; j < mapLen; j++) {
                for (int k = 0; k < mapLen; k++) {
                    if (map[j][i].w == Integer.MAX_VALUE || map[i][k].w == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (map[j][k].w > map[j][i].w + map[i][k].w) {
                        map[j][k] = new Route(map[j][i].w + map[i][k].w, map[j][i].path);
                    }
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (Route[] ints : map) {
            for (Route anInt : ints) {
                answer.append(anInt);
            }
            answer.append("\n");
        }
        System.out.println(answer.toString());

    }
}
