package YG;

import java.util.HashMap;
import java.util.Map;

public class Test3 {

    public int solution(int[] p) {
        int answer = 0;

        HashMap<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < p.length; i++) {
            int number = p[i];
            int numberCnt = numbers.getOrDefault(number, 0);
            numbers.put(number, numberCnt + 1);
        }

        while (true) {
            int cnt = checkIncrementalInterval(numbers);
            if (cnt == -1) {
                return answer;
            }
            answer += cnt;
        }
    }

    private int checkIncrementalInterval(HashMap<Integer, Integer> numbers) {
        int cnt = 0;
        for (Map.Entry<Integer, Integer> number : numbers.entrySet()) {
            int value = number.getValue();
            if (value == 0) {
                continue;
            }
            numbers.put(number.getKey(), value - 1);
            cnt++;
        }
        return cnt - 1;
    }

    public static void main(String[] args) {

        int[] p =
                {20,10,10,20};
//                {3,2,1,4,5};
//                {103, 101, 103, 103, 101, 102, 100, 100, 101, 104};

        System.out.println(new Test3().solution(p));
    }
}
