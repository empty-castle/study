package Monthly_code_challenge_season2.Number_and_addition_of_factors;

import java.util.HashSet;
import java.util.Set;

public class A {

    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            Set<Integer> set = new HashSet<>();
            int divisor = 1;
            int end = right;
            while (divisor < end) {
                if (i % divisor == 0) {
                    end = i / divisor;
                    set.add(divisor);
                    set.add(end);
                }
                divisor++;
            }
            System.out.println(set);
            answer += (set.size() % 2 == 0 ? i : -i);
        }

        return answer;
    }

    public static void main(String[] args) {

        int left = 13;
        int right = 17;

        A A = new A();
        System.out.println(A.solution(left, right));
    }
}
