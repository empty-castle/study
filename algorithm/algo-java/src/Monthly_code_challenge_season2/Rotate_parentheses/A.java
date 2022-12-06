package Monthly_code_challenge_season2.Rotate_parentheses;

import java.util.Stack;

public class A {

    public static void main(String[] args) {

        String s = "[](){}";

        // 사용하기 좋게 배열로
        String[] S = s.split("");

        int answer = s.length();
        int start = 0; // 시작점

        for (int i = 0; i < s.length(); i++) {
            Stack<String> stack = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                // 시작점부터 마지막 문자열까지
                int next = start + j;
                if (next >= s.length()) {
                    next -= s.length();
                }
//                System.out.print(S[next]);
                // 괄호의 방향을 확인
                if (chkRotate(S[next])) {
                    // 여는 괄호라면 스택에 추가
                    stack.push(S[next]);
                } else {
                    // 닫는 괄호라면 스택에서 꺼내 매칭
                    if (stack.isEmpty() || !match(stack.pop(), S[next])) {
                        // 스택이 비어있거나 맞물리지 않는다면 중단
                        answer--;
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) {
                answer--;
            }
            start++;
//            System.out.println();
        }
        System.out.println("answer: " + (Math.max(answer, 0)));
    }
    // 여는 괄호 true, 닫는 괄호 false
    static private boolean chkRotate(String s) {
        return switch (s) {
            case "[", "{", "(" -> true;
            default -> false;
        };
    }
    // 두 괄호가 맞물리는지 확인
    static private boolean match(String open, String close) {
        return switch (open) {
            case "[" -> close.equals("]");
            case "{" -> close.equals("}");
            case "(" -> close.equals(")");
            default -> throw new IllegalStateException("Unexpected value: " + open);
        };
    }
}
