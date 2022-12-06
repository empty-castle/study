package Graph.Farthest_node;

import java.util.ArrayList;
import java.util.List;

public class A {

    public static void main(String[] args) {

        /*
        * input
        * */
        int n = 6;
        int[][] edge = {{3, 6}, {2, 4}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {5, 2}};

        ArrayList<Integer>[] line = new ArrayList[n]; // 간선의 정보가 담긴다.
        List<Integer> startingPointList = new ArrayList<>(); // 시작점이 될 노드들
        int[] distance = new int[n];
        int max = 0; // 가장 먼 거리
        int answer = 0;

        // 간선을 테이블화 한다.
        for (int[] ints : edge) {
            // 배열의 위치는 0 부터 시작하니 1 을 빼준다.
            int leftNum = ints[0] - 1;
            int rightNum = ints[1] - 1;

            if (line[leftNum] == null) line[leftNum] = new ArrayList<>();
            if (line[rightNum] == null) line[rightNum] = new ArrayList<>();
            // 양방향 간선
            line[leftNum].add(rightNum);
            line[rightNum].add(leftNum);
        }
        // 간선을 따라가며 1 번 노드로부터의 거리를 구한다.
        startingPointList.add(0);
        while (!startingPointList.isEmpty()) {
            int startingPoint = startingPointList.get(0);
            startingPointList.remove(0);
            while (!line[startingPoint].isEmpty()) {
                int endPoint = line[startingPoint].get(0);
                line[startingPoint].remove(0);
                startingPointList.add(endPoint);
                // distance[endPoint] 가 0 이면 처음 거리를 계산한 경우라고 생각.
                // && endPoint 가 1 번 노드를 가르키는 0 인 경우엔 거리를 계산하지 않는다.
                if (distance[endPoint] == 0 && endPoint != 0) {
                    distance[endPoint] = distance[startingPoint] + 1;
                    max = distance[endPoint];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (distance[i] == max) answer++;
        }
        System.out.println(answer);
    }
}
