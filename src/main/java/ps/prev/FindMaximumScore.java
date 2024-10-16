package ps.prev;

import java.util.*;

// https://cote.inflearn.com/contest/10/problem/08-03
public class FindMaximumScore {

    /**
     * N개의 문제가 주어진다.
     * 각 문제는 점수와 푸는데 걸리는 시간이 주어진다.
     * 제한시간 M 안에 N개의 문제 중 최대 점수를 얻어야 한다.
     *
     * 부분집합을 사용하여 제한 시간 내에 푸는 문제 조합을 구하고
     * 그 중에서 최대값 가져오면 될 듯
     * -> DFS
     */

    static int max = Integer.MIN_VALUE;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] scoreArr = new int[n];
        int[] timeArr = new int[n];
        for (int i = 0; i < n; i++) {
            scoreArr[i] = sc.nextInt();
            timeArr[i] = sc.nextInt();
        }

        FindMaximumScore fms = new FindMaximumScore();
        fms.DFS(0, 0, 0, scoreArr, timeArr);
        System.out.println(max);
    }

    // depth, 합계, 점수 배열, 시간 배열
    public void DFS(int depth, int scoreSum, int timeSum, int[] scoreArr, int[] timeArr) {
        if (timeSum > m) return;
        if (depth == n) {
            max = Math.max(max, scoreSum);
        }
        else {
            DFS(depth +1, scoreSum +scoreArr[depth], timeSum +timeArr[depth], scoreArr, timeArr);
            DFS(depth +1, scoreSum, timeSum, scoreArr, timeArr);
        }
    }

}
