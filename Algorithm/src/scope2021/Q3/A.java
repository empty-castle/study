package scope2021.Q3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A {

    public static void main(String[] args) {

        /*
        * INPUT
        * */
        int N = 4;
        String[] input = new String[]{
                "1110",
                "1110",
                "0110",
                "0000"
        };

        /*
        * 공간 정보 중 배치가 가능한 곳의 정보만 list 에 담는다
        * */
        List<String> vect = new ArrayList<>();
        int inputLen = input.length;
        for (int i = 0; i < inputLen; i++) {
            String[] line = input[i].split("");
            for (int j = 0; j < inputLen; j++) {
                if (line[j].equals("1")) {
                    vect.add(i + "," + j);
                }
            }
        }

        /*
        * 배치가 가능한 포인트를 기준으로 size 0 부터 가능한 size 까지 검사한다.
        * */
        Map<String, Integer> map = new HashMap<>();
        int vectLen = vect.size();
        for (int i = 0; i < vectLen; i++) {
            String[] pointXY = vect.get(i).split(",");
            int X = Integer.valueOf(pointXY[0]);
            int Y = Integer.valueOf(pointXY[1]);
            boolean res = true;
            for (int j = 1; ; j++) {
                if (X + j > vectLen) {
                    break;
                }
                for (int k = 0; k < j; k++) {
                    for (int l = 0; l < j; l++) {
                        if (!vect.contains( (X + k) + "," + (Y + l) )) {
                            res = false;
                            break;
                        }
                    }
                    if (!res) break;
                }
                if (!res) {
                    break;
                }
                map.put(j + "", map.getOrDefault(j + "", 0) + 1);
            }
        }
        System.out.println(map);
    }
}
