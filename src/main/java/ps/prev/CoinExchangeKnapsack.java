package ps.prev;

import java.util.Arrays;
import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/10-05
public class CoinExchangeKnapsack {

    /**
     *  DP, Knapsack 알고리듬
     */

    static int n, m;
    static int[] dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();
        dy = new int[m+1];

        CoinExchangeKnapsack ce = new CoinExchangeKnapsack();
        System.out.println(ce.solution(arr));
    }

    public int solution(int[] coin) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j-coin[i]] +1);
            }
        }

        return dy[m];
    }

}
