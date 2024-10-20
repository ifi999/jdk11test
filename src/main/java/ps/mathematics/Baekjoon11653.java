package ps.mathematics;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준
 * - 11653번 (https://www.acmicpc.net/problem/11653)
 *
 * 문제
 * - 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
 *
 * 입력
 * - 첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.
 *
 * 출력
 * - N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.
 *
 * 풀이
 * - 에라토스테네스의 체 : O(Nlog(logN))
 * - 소인수분해 : O(sqrt(N))
 *
 */
public class Baekjoon11653 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final boolean[] primes = sieve(n);

        int tmp = n;
        for (int i = 2; i < n; i++ ) {
            if (primes[i]) {
                while (tmp % i == 0) {
                    System.out.println(i);
                    tmp /= i;
                }
            }
        }

        // n이 소수인 경우 마지막으로 그 자체를 출력
        if (tmp > 1) {
            System.out.println(tmp);
        }

    }

    public static boolean[] sieve(final int n) {
        final boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true); // 모두 소수라고 가정
        primes[0] = false; // 0은 소수가 아님
        primes[1] = false; // 1은 소수가 아님

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!primes[i]) continue; // 소수가 아니면 패스

            for (int j = i * i; j <= n; j = j + i) {
                primes[j] = false;
            }
        }

        return primes;
    }

}
