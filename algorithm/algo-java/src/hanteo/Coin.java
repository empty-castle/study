package hanteo;

public class Coin {

    static int result = 0;

    public static int solution(int sum, int[] coins) {

        for (int i = 0; i < coins.length; i++) {
            findCombination(sum, coins, i, coins[i]);
        }
        return result;
    }

    private static void findCombination(int sum, int[] coins, int startIndex, int currentSum) {
        if (currentSum == sum) {
            result++;
            return;
        }
        for (int i = startIndex; i < coins.length; i++) {
            int nextSum = currentSum + coins[i];
            if (nextSum == sum) {
                result++;
            }
            if (nextSum < sum) {
                findCombination(sum, coins, i, nextSum);
            }
        }
    }

    public static void main(String[] args) {

//        int sum = 4;
//        int[] coins = {1,2,3};

        int sum = 10;
        int[] coins = {2,5,3,6};

        System.out.println(solution(sum, coins));
    }
}
