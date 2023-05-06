package ps;

import java.util.*;

// https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=73418&tab=curriculum
public class WonderlandPriorityQueue {

    /**
     *  잘못했던 점
     *  -> List의 각 인덱스에 맞는 곳에서 뻗어나가는 것만 취급했음 = 단방향
     *  --> '8 9 15'라는 값이 문제풀이에서는 9->8 도 되어야하는데 8->9로만 되게 만들어서 원하는 값을 얻지 못함
     *  ---> 원인 : 8 -> 9만 넣어줬었음. 9 -> 8도 넣어주면서 해결
     */

    static int[] ch;
    static List<List<CityEdge>> list;
    static PriorityQueue<CityEdge> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        ch = new int[v+1];
        list = new ArrayList<>();
        for (int i = 0; i <= v; i++) list.add(new ArrayList<>());
        queue = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            int city = sc.nextInt();
            int target = sc.nextInt();
            int cost = sc.nextInt();
            // 단방향뿐만 아니라
            list.get(city).add(new CityEdge(target, cost));
            // 반대 방향에도 넣어주면 되는 것이었음
            list.get(target).add(new CityEdge(city, cost));
        }

        WonderlandPriorityQueue wpq = new WonderlandPriorityQueue();
        System.out.println(wpq.solution(new CityEdge(1, 0)));

    }

    public int solution(CityEdge ce) {
        queue.offer(ce);
        int sum = 0;

        while (!queue.isEmpty()) {
            CityEdge poll = queue.poll();
            if (ch[poll.target] == 0) {
                ch[poll.target] = 1;
                sum += poll.cost;
                List<CityEdge> cityEdges = list.get(poll.target);
                for (CityEdge c : cityEdges) {
                    queue.offer(c);
                }
            }
        }

        return sum;
    }

}

class CityEdge implements Comparable<CityEdge> {
    int target;
    int cost;

    public CityEdge(int target, int cost) {
        this.target = target;
        this.cost = cost;
    }

    @Override
    public int compareTo(CityEdge o) {
        return this.cost - o.cost;
    }
}
