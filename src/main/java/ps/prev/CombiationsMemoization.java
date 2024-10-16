package ps.prev;

import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/08-07
public class CombiationsMemoization {

    /**
     * nCr 을 n!/(n-r)!r! 의 공식을 사용하지 않고,
     * nCr = n-1Cr-1 + n-1Cr 형식의 재귀를 사용하여 구하시오.
     *
     * 1. 3 <= n <= 33
     * 2. 0 <= r <= n
     * 3. r = 0 혹은 r == n 일 시 재귀 종료
     */

    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        arr = new int[n+1][r+1];

        CombiationsMemoization cm = new CombiationsMemoization();
        int result = cm.solution(n, r);
        System.out.println(result);
    }

    public int solution(int n, int r) {
        if (n == r || r == 0) return 1;

        if (arr[n][r] == 0) {
            arr[n][r] = solution(n-1, r-1) + solution(n-1, r);
        }

        return arr[n][r];
    }
}
