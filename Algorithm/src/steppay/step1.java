package steppay;

import java.util.Arrays;

/*
*
* 통과
*
* */

public class step1 {

    public static void main(String[] args) {

        int answer = 0;
        int[] goods = {3,8,6};
        int[] boxes = {5,6,4};

        Arrays.sort(goods);
        Arrays.sort(boxes);

        int checkedGoods = goods.length - 1;
        for (int i = boxes.length - 1; i >= 0; i--) {
            while (checkedGoods > -1) {
                if (goods[checkedGoods] > boxes[i]) {
                    checkedGoods--;
                    continue;
                }
                checkedGoods--;
                answer++;
                break;
            }
        }

        System.out.println(answer);
    }
}
