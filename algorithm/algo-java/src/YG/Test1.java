package YG;

public class Test1 {

    public int solution(int[][] office, int k) {
        int answer = -1;

        int possibleN = office.length - k + 1;

        for (int i = 0; i < possibleN; i++) {
            for (int j = 0; j < possibleN; j++) {
                int cnt = checkArea(office, k, i, j);
                if (answer < cnt) {
                    answer = cnt;
                }
            }
        }

        return answer;
    }

    private int checkArea(int[][] office, int k, int x, int y) {
        int result = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (office[x + i][y + j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] office = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}

//                {1,0,0},
//                {0,0,1},
//                {1,0,0},
        };
        int k = 2;

        System.out.println(new Test1().solution(office, k));
    }
}
