package DFS.Target_number;

public class A {

    public static void main(String[] args) {

        /*
        * input
        * */
        int[] input = {1, 1, 1, 1, 1};


        /*
        * 트리의 마지막 노드까지 순차적으로 탐색하는 알고리즘
        * 모든 경우의 수를 구해 원하는 경우가 몇가지가 되는지 탐색하는 알고리즘
        * */

        int answer = dfs(input, 3, 0, 0);
        System.out.println(answer);
    }

    private static int dfs(int[] input, int target, int n, int sum) {
        if (n == input.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(input, target, n + 1, sum + input[n]) + dfs(input, target, n + 1, sum - input[n]);
    }
}
