package BFS.WordConversion;

import java.util.*;

public class A {

    private static class Node {
        String cur;
        int cnt;

        public Node(String cur, int cnt) {
            this.cur = cur;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {

        /*
        * input
        * */
        String[] input = {
                "hot",
                "dot",
                "lot",
                "log",
                "cog"
        };

        String[] input2 = {
                "hot",
                "dot",
                "dog",
                "lot",
                "log"
        };
        String begin = "hit";
        String target = "cog";

        // bfs
        boolean[] visited = new boolean[input.length]; // 방문한 노드를 확인
        Queue<Node> q = new LinkedList<>(); // 방문할 노드를 기억
        int answer = 0;
        q.add(new Node(begin, 0)); // 시작지점 설정
        // 더이상 방문할 노드가 없을때까지
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.cur.equals(target)) {
                answer= node.cnt;
                break;
            }
            for (int i = 0; i < input.length; i++) {
                if (!visited[i] && chkRule(node.cur, input[i])) {
                    visited[i] = true;
                    q.add(new Node(input[i], node.cnt + 1));
                }
            }
        }
        System.out.println(answer);
    }

    // 두개의 단어를 비교해서 한글자만 다른 경우 true 를 리턴
    private static boolean chkRule(String begin, String next) {
        int cnt = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != next.charAt(i)) {
                if (++cnt > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

