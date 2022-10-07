package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/17687

import java.util.ArrayList;
import java.util.List;

public class NNumberGame {

    public static void main(String[] args) {

        // 진법
        int n = 16;
        // 미리 구할 숫자의 갯수
        int t = 16;
        // 게임 인원
        int m = 2;
        // 튜브 순서
        int p = 2;

        List<String> numbers = new ArrayList<>();
        for (int i = 0; ;i++) {
            char[] conversionNumber = conversion(i, n);
            for (char s : conversionNumber) {
                numbers.add(String.valueOf(s).toUpperCase());
            }
            if (numbers.size() > t * m) {
                break;
            }
        }

        List<String> answer = new ArrayList<>();
        int index = p - 1;
        while (t > 0) {
            answer.add(numbers.get(index));
            index += m;
            t--;
        }

        System.out.println(String.join("", answer));
    }

    static private char[] conversion(int number, int n) {
        return Integer.toString(number, n).toCharArray();
    }
}
