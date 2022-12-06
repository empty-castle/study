package YG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {

    public int[] solution(int n, int m, String[] records) {
        List<Integer> answer = new ArrayList<>();

        int currentTicketNum = 0;
        HashMap<Integer, Integer> tickets = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            String time = record[0];
            String type = record[1];
            if (type.equals("enter")) {
                tickets.put(currentTicketNum, Integer.parseInt(time));
                currentTicketNum++;
            } else {
                String num = record[2];
                tickets.remove(Integer.parseInt(num));
            }
        }

        int workTime = m;
        for (Map.Entry<Integer, Integer> ticket : tickets.entrySet()) {
            if (workTime > n) {
                break;
            }
            int ticketNum = ticket.getKey();
            int time = ticket.getValue();

            if (time <= workTime ) {
                answer.add(ticketNum);
                workTime += m;
                continue;
            }

            int remain = time % m;
            if (remain == 0) {
                workTime = time;
            } else {
                workTime = time + m - remain;
                if (workTime > n) {
                    break;
                }
            }
            answer.add(ticketNum);
            workTime += m;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        int n = 10000000;

        int m = 5;

        String[] records = {
//                "1 enter",
//                "5 enter",
//                "8 cancel 0",
//                "22 enter",
//                "24 cancel 2",
//                "27 enter",

                "2 enter",
                "4 enter",
                "12 enter",
                "14 cancel 2",
                "99999 enter",
                "10000000 enter",
        };


        for (int i : new Test2().solution(n, m, records)) {
            System.out.println(i);
        }
    }
}
