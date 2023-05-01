package ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/08-14
public class PizzaDeliveryDistance {

    /**
     *  N*N 크기의 도시 지도가 있다.
     *  정수 0은 빈칸, 1은 집, 2는 피자집이다.
     *  도시의 피자 집 중에서 M개만 남기고 싶다.
     *  피자집 M개마다 도시의 피자배달거리 최소가 되는 집합을 구하고자 한다.
     *  최소가 된 집합에서의 최소 피자배달거리는?
     */

    static int n, m, len;
    static int min = Integer.MAX_VALUE;
    //    static int[][] board; // 굳이 필요 없음
    static List<Point> homePositions, pizzaPositions;
    static int[] combi;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

//        board = new int[n][n];
        combi = new int[m];
        homePositions = new ArrayList<>();
        pizzaPositions = new ArrayList<>();
//        len = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                board[i][j] = sc.nextInt();
                int tmp = sc.nextInt();
                if (tmp == 1) homePositions.add(new Point(i, j));
                else if (tmp == 2) pizzaPositions.add(new Point(i, j));
            }
        }

        // lenCm 을 구해야하는 것
        len = pizzaPositions.size();
        PizzaDeliveryDistance pdd = new PizzaDeliveryDistance();
        pdd.solution(0, 0);

        System.out.println(min);
    }

    public void solution(int depth, int target) {
        if (depth == m) {
            int sum = 0;
            for (Point h : homePositions) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x-pizzaPositions.get(i).x)+Math.abs(h.y-pizzaPositions.get(i).y));
                }
                sum += dis;
            }
            min = Math.min(min, sum);
        }
        else {
            for (int i = target; i < len; i++) {
                combi[depth] = i;
                solution(depth +1, i +1);
            }
        }
    }

    // 잘못 만들어서 답이 나오지 않음.
    // depth == m 부분에서 비교해야할 변수들을 한단계 위에서 선언하고 비교했어야했음.
    // tmpSum, tmp 위치들..
//    public void solution(int depth, int target) {
//        // 피자집 리스트에서 M개 뽑을 때까지 돌리고,
//        // M개를 뽑는다면 집 리스트와 함께 돌려서 최소 거리 구하기
//
//        if (depth == m) {
//            int tmpMin = Integer.MAX_VALUE;
//            for (int i : combi) {
//                int tmpSum = 0;
//                Point pizzaPosition = pizzaPositions.get(i);
//                for (Point homePosition : homePositions) {
//                    int tmp = Math.abs(pizzaPosition.x - homePosition.x) + Math.abs(pizzaPosition.y - homePosition.y);
//                    tmpMin = Math.min(tmpMin, tmp);
//                    tmpSum += tmp;
//                }
//
//                if (len > tmpSum) {
//                    len = tmpSum;
//                    min = tmpMin;
//                }
//            }
//        }
//        else {
//            for (int i = target; i < n; i++) {
//                combi[depth] = i;
//                solution(depth+1, i+1);
//            }
//        }
//    }

}
