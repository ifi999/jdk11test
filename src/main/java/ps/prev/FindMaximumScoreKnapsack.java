package ps.prev;

import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/10-06
public class FindMaximumScoreKnapsack {

    /**
     * 단 한 문제,종류일 때(유한개)는 배열을 뒤에서부터 채우기
     * (CoinExchangeknapsack처럼 무한개라면 앞에서 부터)
     */

    static int n, m;
    static int[] dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        dy = new int[m+1];

        for (int i = 0; i < n; i++) {
            int ps = sc.nextInt();
            int pt = sc.nextInt();

            for (int j = m; j >= pt; j--) {
                dy[j] = Math.max(dy[j], dy[j-pt] +ps);
            }
        }

        System.out.println(dy[m]);
    }
}
