package steppay;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
*
* 메모리, 시간 초과
*
* 가장 짧은 시간을 기준으로 계산을 시작해야?
*
* */

public class step3 {

    public static void main(String[] args) {

        int answer = 0;

        int[] play_list = {2,3,1,4};
        int listen_time = 3;

        int sum_play_list_time = Arrays.stream(play_list).sum();

        if (sum_play_list_time <= listen_time) {
            System.out.println(play_list.length);
            // return
        }

        int[] play_list_time = new int[sum_play_list_time];
        int plt_index = 0;
        for (int i = 0; i < play_list.length; i++) {
            for (int j = 0; j < play_list[i]; j++) {
                play_list_time[plt_index] = i;
                plt_index++;
            }
        }

        int listen_start_point = 0;
        int listen_end_point = listen_time;
        while (listen_start_point < play_list_time.length) {
            Set<Integer> answerSet = new HashSet<>();
            for (int i = listen_start_point; i < listen_end_point; i++) {
                int index = i;
                if (i > play_list_time.length - 1) {
                    index = i - play_list_time.length;
                }
                answerSet.add(play_list_time[index]);
            }
            listen_start_point++;
            listen_end_point++;
            if (answer < answerSet.size()) {
                answer = answerSet.size();
            }
        }

        System.out.println(answer);

    }
}
