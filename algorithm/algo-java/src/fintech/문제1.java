package fintech;

import java.util.*;

public class 문제1 {

    public static void main(String[] args) {

        String[] record = {"P 300 6", "P 500 3", "S 100 4", "P 600 2 ", "S 1200 1"};

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        int sumStack = 0;
        int sumQueue = 0;

        for (String s : record) {
            String[] splitStr = s.split(" ");
            String type = splitStr[0];
            int price = Integer.parseInt(splitStr[1]);
            int quantity = Integer.parseInt(splitStr[2]);

            if (type.equals("P")) {
                for (int i = 0; i < quantity; i++) {
                    stack.push(price);
                    queue.add(price);
                }
            } else {
                for (int i = 0; i < quantity; i++) {
                    if (stack.size() > 0){
                        sumStack += stack.pop();
                    }
                    if (queue.size() > 0) {
                        sumQueue += queue.poll();
                    }
                }

            }
        }

        System.out.println(sumStack + "[]" + sumQueue);
    }
}
