package ps.prev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/09-01
public class Wrestler {

    /**
     * 2개의 성분을 비교해야한다.
     * 그런데 5 <= N <= 30,000 이어서 2중 for문으로 하면 시간이 부족할 것 같다.
     * 그럴 경우 그리디를 고려해보는 듯 하다.
     *
     * 여기서 비교해야할 성분은 키, 몸무게가 있다.
     * 우선 키를 정렬하여 가장 큰 값인 것을 추출한다.
     * 이 경우에는 자신보다 큰 사람이 없으므로 무조건 선발이 된다.
     * 그리고나서 2번째 값부터는 키가 아닌 기존 최고 몸무게와 비교를 들어간다.
     * 기존 몸무게보다 크다면 선발이고, 적다면 키가 당연히 작으니 모든게 부족하므로 탈락이다.
     *
     * 해야할 것
     * 1. 키 -> 몸무게 순 정렬 (내림차순)
     * 2. 키 가장 큰 사람 선발
     * 3. 그다음 순번 돌면서 몸무게 비교하여 선발
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();
            list.add(new Point(height, weight));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.x == o2.x) {
                return o2.y - o1.y;
            }
            return o2.x - o1.x;
        });

        int maxWeight = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (list.get(i).y > maxWeight) {
                result++;
                maxWeight = list.get(i).y;
            }
        }

        System.out.println(result);
    }
}

// 여기서는 기존 Point class를 가져와서 대충대충 x,y값으로 하였는데 따로 만드는 연습하기.
class Body implements Comparable<Body> {
    public int height, weight;

    public Body(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Body body) {
        return body.height - this.height;
    }
}
