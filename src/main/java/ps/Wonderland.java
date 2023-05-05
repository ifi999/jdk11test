package ps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/09-07
public class Wonderland {

    /**
     * 트리 : 회로가 존재 x
     * 그래프 : 회로가 존재 o
     */

    static int[] unf;
//    static int []dis;
    static int sum = 0;

    public static int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(CityRoad cr) {
        int ff = Find(cr.from);
        int ft = Find(cr.to);
        if (ff != ft) {
            unf[ff] = ft;
//            dis[ff] = Math.min(dis[ff], cr.cost);
            sum += cr.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        unf = new int[v+1];
//        dis = new int[v+1];
//        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 1; i <= v; i++) unf[i] = i;

        ArrayList<CityRoad> list = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            list.add(new CityRoad(from, to, cost));
            // 바로 Union하는 것이 아니라, 최소비용부터 구하기위해 정렬을 해야함
//            Union(new CityRoad(from, to, cost));
        }

        Collections.sort(list);

        for (CityRoad c : list) {
            Union(c);
        }

        // 풀이에서는 sum을 static 변수로 만드는 것이 여기서 지역 변수로 만들었음
        // 아래와 같이 for문 돌리는 이유 : 1000개의 간선 중에 20~30개쯤에서 트리가 완성되어버리면 쓸데없이 도는 일이 생김
        //                          그럴 경우에 전체 간선 개수는 v-1개 이므로 카운팅해서 멈추기 위함인듯?
        /**
         * int sum = 0;
         * for (CityRoad c : list) {
         *      int ff = Find(c.from);
         *      int ft = Find(c.TO);
         *      if (ff != ft) {
         *          sum += c.cost;
         *          Union(c.from, c.to);
         *      }
         * }
         */

        System.out.println(sum);
    }

}

// 최소 비용 구하는 문제 -> 그리디 해볼만 한듯
// from, to로 네이밍을 했는데 이건 그래프라기보다는 트리라서 from, to가 부적절한듯
// 설명에는 v1, v2라고 네이밍 함
class CityRoad implements Comparable<CityRoad> {
    int from;
    int to;
    int cost;

    public CityRoad(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(CityRoad o) {
        return this.cost - o.cost;
    }
}