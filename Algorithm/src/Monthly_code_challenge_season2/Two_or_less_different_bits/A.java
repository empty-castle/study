package Monthly_code_challenge_season2.Two_or_less_different_bits;

import java.util.Arrays;

public class A {

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            char[] number_bit = Long.toBinaryString(numbers[i]).toCharArray();
            for (int j = number_bit.length - 1; j >= 0; j--) {
                if (number_bit[j] == '0') {
                    number_bit[j] = '1';
                    if (j + 1 != number_bit.length) {
                        number_bit[j + 1] = '0';
                    }
                    answer[i] = Long.parseLong(String.copyValueOf(number_bit), 2);
                    break;
                }
            }
            if (answer[i] == 0) {
                number_bit[0] = '0';
                answer[i] = Long.parseLong("1" + String.copyValueOf(number_bit), 2);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        A A = new A();
        long[] numbers = {2, 7, 5};

        for (long l : A.solution(numbers)) {
            System.out.println(l);
        }
    }
}
