package theory.dijkstra;

@SuppressWarnings("Duplicates")
public class none_heap {

    public static void main(String[] args) {

        int INF = 9999999;
        int[][] table = new int[][]{
                {0, INF, 5, 3, INF},
                {3, 0, INF, INF, INF},
                {INF, INF, 0, 2, INF},
                {INF, 1, 1, 0, INF},
                {INF, 4, INF, 2, 0}
        };
        // 시작점 설정
        int[] dist = table[4]; // 시작점 노드 5
        int[] visitNode = new int[table.length]; // 1 방문한 노드 0 방문하지 않은 노드
        visitNode[4] = 1;
        // 시작점을 기준으로 최단거리 노드 찾기
        int shortNode = shortestNode(dist, visitNode);
        // 시작점에서 최단 거리 노드를 통해 다른 노드로 가는 비용을 검사
        while (visitNode[shortNode] == 0) {
            visitNode[shortNode] = 1;
            int[] shortNodeDist = table[shortNode];
            for (int i = 0; i < shortNodeDist.length; i++) {
                if ( dist[i] > dist[shortNode] + shortNodeDist[i] ) {
                    dist[i] = dist[shortNode] + shortNodeDist[i];
                }
            }
            shortNode = shortestNode(dist, visitNode);
        }
        // 출력
        for (int i1 : dist) {
            System.out.println(i1);
        }
    }

    private static int shortestNode(int[] dist, int[] visitNode) {
        int shortNode = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] != 0 && visitNode[i] == 0 && dist[shortNode] > dist[i]) {
                shortNode = i;
            }
        }
        return shortNode;
    }
}
