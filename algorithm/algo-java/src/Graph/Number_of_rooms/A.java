package Graph.Number_of_rooms;

import java.util.HashSet;
import java.util.Set;

public class A {

    public static void main(String[] args) {

        /*
        * input
        * */
        int[] arrows = new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};

        int answer = 0;
        Set<String> lineSet = new HashSet<>();
        Set<String> pointSet = new HashSet<>();

        int x = 0;
        int y = 0;

        pointSet.add(x + "|" + y);
        int arrowsLen = arrows.length;
        for (int i = 0; i < arrowsLen; i++) {
            /*
            *
            * j for 문을 추가하여 두 번 점을 찍는 이유
            *
            *  ㅡㅡㅡㅡㅡㅡ
            * ㅣ＼     / ㅣ
            * ㅣ  ＼ /   ㅣ
            * ㅣ  /  ＼  ㅣ
            * ㅣ/      ＼ㅣ
            *  ㅡㅡㅡㅡㅡㅡ
            *
            *  교차점이 생기는 경우를 보완하기 위해 중간에 가상의 점을 찍는다
            *
            * */
            for (int j = 0; j < 2; j++) {
                int vect = arrows[i];
                String start = x + "|" + y;
                // input 의 값에 따라 xy 좌표 이동
                if (vect <= 1 || vect == 7) y++;
                if (1 <= vect && vect <= 3) x++;
                if (3 <= vect && vect <= 5) y--;
                if (5 <= vect && vect <= 7) x--;

                String point = x + "|" + y; // 목표점
                String normalLine = start + "|" + point; // 시작점과 목표점을 이어 선을 만든다.
                String backLine = point + "|" + start; // 반대의 경우도 생각하여 만든다.
                // 목표점이 이미 한번 지나갔던 점이고
                if (pointSet.contains(point)) {
                    // 시작점과 목표점을 이은 선이 아직 그어지지 않은 선이라면 방 개수를 추가한다.
                    // 이미 그어진 선이라면 중복으로 그려지는 선이기 때문에 방 개수가 늘어나지 않는다.
                    if (!lineSet.contains(normalLine)) {
                        answer++;
                    }
                }

                pointSet.add(point); // 목표점을 추가
                lineSet.add(normalLine); // 시작점과 목표점을 이은 선을 추가
                lineSet.add(backLine); // 그 반대의 선도 추가
            }
        }

        System.out.println(answer);
    }
}
