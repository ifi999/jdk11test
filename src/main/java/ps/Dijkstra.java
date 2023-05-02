package ps;

import java.util.*;

// https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=73415
public class Dijkstra {

    /**
     * dis[] 필요. 간선의 가중치 값이 음수면 안됨. 무조건 0 이상.
     * dis[]의 초기값은 Integer.MAX_VALUE
     * dis[시작점]의 초기값은 0.
     * dis[]를 순환하는데, 순환하면서 가장 작은 값으로 가서 이동한다. 이동된 인덱스는 체크해서 다음 번에 오지 않도록 만든다.
     * 이렇게하면 n * O(n)이 될 수도 있지만, n * log(n)으로 만들 수도 있다.
     * -> PriorityQueue.
     */

    static int n,m;
    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점 개수
        m = sc.nextInt(); // 간점 개수

        graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }

        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        Dijkstra d = new Dijkstra();
        d.solution(1);

        for (int i = 2; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }

    }

    public void solution(int v) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(v, 0));
        dis[v] = 0;
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int currentVex = edge.vex;
            int currentCost = edge.cost;
            // 이동하고 나서 비교해야하는데 잘못 생각했었음
//            if (dis[currentVex] > currentCost) dis[currentVex] = currentCost;
            // 애초에 더 나쁜 값인데 for문을 갈 이유가 없음
            if (dis[currentVex] < currentCost) continue;
            ArrayList<Edge> list = graph.get(currentVex);
            for (Edge e : list) {
                if (dis[e.vex] > currentCost +e.cost) {
                    dis[e.vex] = currentCost +e.cost;
                    queue.offer(e);
                }
            }
        }
    }

}

// 적은 비용부터 정렬
class Edge implements Comparable<Edge> {
    int vex;
    int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}