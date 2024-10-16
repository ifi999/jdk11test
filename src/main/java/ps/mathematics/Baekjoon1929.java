package ps.mathematics;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준
 * - 1929번 (https://www.acmicpc.net/problem/1929)
 *
 * 문제
 * - M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * - 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
 *
 * 출력
 * - 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 *
 * 풀이
 * - 에라토스테네스의 체
 * - 시간복잡도
 *  - 에라토스테네스의 체 : O(Nlog(logN))
 *  - 출력 : O(n - m)
 */
public class Baekjoon1929 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int m = sc.nextInt();
        final int n = sc.nextInt();

        final boolean[] primes = sieve(n);

        for (int i = m; i <= n; i++) {
            if (primes[i]) System.out.println(i);
        }

    }

    public static boolean[] sieve(final int n) {
        final boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true); // 모두 소수라고 가정
        prime[0] = false; // 0은 소수가 아님
        prime[1] = false; // 1은 소수가 아님

        // 에라토스테네스의 체
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!prime[i]) continue; // 소수가 아니라면 넘김

            // i의 배수는 소수가 아님
            for (int j = i * i; j <= n; j = j + i) {
                prime[j] = false;
            }
        }

        return prime;
    }

}
