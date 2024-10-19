package ps.prev;

import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/08-02
public class PuppyRide {

    /**
     * n마리의 강아지, 각 강아지 무게 w kg
     * 트럭에는 c kg 넘게 태울 수 없음
     * 트럭에 태울 수 있는 가장 무거운 무게는?
     *
     * 각 강아지를 태운다/안태운다 (부분집합)
     * -> DFS
     *
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        PuppyRide pr = new PuppyRide();
        pr.DFS(0, 0, arr);
        System.out.println(max);
    }

    static int max = Integer.MIN_VALUE;
    static int n;
    static int c;

    // Depth, sum, arr
    public void DFS(int depth, int sum, int[] arr) {
        if (sum > c) return;
        if (depth == n) {
            // 마지막까지 도달했다면
            max = Math.max(max, sum);
        }
        else {
            // 태운 것
            DFS(depth +1, sum +arr[depth], arr);
            // 안태운 것
            DFS(depth +1, sum, arr);
        }
    }

}
