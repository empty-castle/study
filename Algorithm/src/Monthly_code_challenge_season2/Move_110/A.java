package Monthly_code_challenge_season2.Move_110;

import java.util.Stack;

public class A {

    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            char[] s_arr = s[i].toCharArray();
            Stack<Character> bucket = new Stack<>();
            int cnt = 0;

            for (int j = 0; j < s_arr.length; j++) {
                if (s_arr[j] == '0') {
                    int index = bucket.size() - 1;
                    if (index >= 1 && bucket.get(index - 1) == '1' && bucket.get(index) == '1') {
                        cnt++;
                        bucket.pop();
                        bucket.pop();
                        continue;
                    }
                }
                bucket.push(s_arr[j]);
            }

            for (int j = 0; j < cnt; j++) {
                int index = 0;
                if (bucket.contains('0')) {
                    index = bucket.lastIndexOf('0') + 1;
                } else {
                    index = bucket.indexOf('1');
                }
                bucket.add(index, '0');
                bucket.add(index, '1');
                bucket.add(index, '1');
            }

            StringBuffer sb = new StringBuffer();
            for (Character character : bucket) {
                sb.append(character);
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    public static void main(String[] args) {
        A A = new A();
        String[] s = {"1011110","01110","101101111010"};
        for (String s1 : A.solution(s)) {
            System.out.println(s1);
        }
    }
}
