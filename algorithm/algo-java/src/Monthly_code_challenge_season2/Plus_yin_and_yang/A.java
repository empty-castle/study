package Monthly_code_challenge_season2.Plus_yin_and_yang;

import java.util.Arrays;

public class A {

    public static void main(String[] args) {

        int signs_len = 3;
        int absolutes_len = 3;
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};
        int answer = 0;
        for (int i = 0; i < signs_len; i++) {
            answer += absolutes[i] * (signs[i]? 1 : -1);
        }
        System.out.println(answer);
    }
}
