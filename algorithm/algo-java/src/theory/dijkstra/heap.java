package theory.dijkstra;


import java.util.PriorityQueue;

@SuppressWarnings("Duplicates")
public class heap {

    private static class Node implements Comparable<Node> {
        int i, d, p;

        Node(int i, int d, int p) {
            this.i = i;
            this.d = d;
            this.p = p;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.d, o.d);
        }

        @Override
        public String toString() {
            return i + "";
        }
    }

    public static void main(String[] args) {

        int INF = Integer.MAX_VALUE;
        int[][] table = new int[][]{
                {0, INF, 5, 3, INF},
                {3, 0, INF, INF, INF},
                {INF, INF, 0, 2, INF},
                {INF, 1, 1, 0, INF},
                {INF, 4, INF, 2, 0}
        };
        // 시작점 설정
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = table[4];
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] != 0 && dist[i] != Integer.MAX_VALUE) {
                pq.add(new Node(i, dist[i], 4));
            }
        }
        // 다익스트라 알고리즘
        while (!pq.isEmpty()) {
            Node shortDistNode = pq.poll(); // 현재 거리가 계산된 노드 중 최단거리
            if (shortDistNode != null) {
                int[] line = table[shortDistNode.i];
                for (int i = 0; i < line.length; i++) {
                    // Integer.MAX_VALUE 에 값을 더하면 음수가 되어 식이 고장난다.
                    // INF 인데 굳이 더해서 계산할 필요없다
                    if (shortDistNode.d == Integer.MAX_VALUE || line[i] == Integer.MAX_VALUE ) {
                        continue;
                    }
                    if (dist[i] > shortDistNode.d + line[i]) {
                        dist[i] = shortDistNode.d + line[i];
                        // 더 작아지는 경우에만 다음 계산 시작
                        // 이 부분이 none heap 방법과 가장 다른 부분 ( vs shortestNode )
                        pq.add(new Node(i, shortDistNode.d + line[i], shortDistNode.i));
                    }
                }
            }
        }
        // 출력
        for (int i : dist) {
            System.out.print(i + "|");
        }
    }
}
