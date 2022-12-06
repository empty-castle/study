package DFS.Travel_route;

public class A {

    private static String route = "a";
    private static boolean[] usedTickets;

    public static void main(String[] args) {

        /*
        * input
        * */
        String[][] tickets = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };

        String[][] tickets2 = {
//                {"ICN", "SFO"},
//                {"ICN", "ATL"},
//                {"SFO", "ATL"},
//                {"ATL", "ICN"},
//                {"ATL", "SFO"}
                {"ICN", "AAA"},
                {"ICN", "BBB"},
                {"BBB", "ICN"},
        };

        /*
        *
        * 시작점과 목표점이 존재한다면 BFS 가 맞다. 깊이 우선 탐색은 일단 전부 탐색하니까
        * 하지만 시작점만 있고 목표점이 없이 가능한 경우의 수 중 원하는 경우를 찾는 식의 문제인 경우엔 DFS 가 맞다
        * 시작점이 있고 가능한 모든 경로의 최단 경로를 찾는건 디익스트라 알고리즘
        *
        * */

        usedTickets = new boolean[tickets2.length];

        dfs(tickets2, "ICN", "ICN", 0);
        // 출력
        for (int i = 0; i < route.length(); i += 3) {
            System.out.println(route.substring(i, i + 3));
        }

    }

    private static void dfs(String[][] tickets, String start, String path, int dept) {
        if (dept == tickets.length) {
            // 각 경우마다 알파벳 순으로 정렬하여 저장
            if (route.compareTo(path) > 0) {
                route = path;
            }
        }
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !usedTickets[i]) {
                usedTickets[i] = true; // 탐색 중인 경우의 수 안에선 티켓의 재사용을 막는다.
                dfs(tickets, tickets[i][1], path + tickets[i][1], dept + 1);
                usedTickets[i] = false; // 탐색이 끝나면 티켓을 사용할 수 있게끔 만들어 계속해서 탐색하게 한다.
            }
        }
    }
}
