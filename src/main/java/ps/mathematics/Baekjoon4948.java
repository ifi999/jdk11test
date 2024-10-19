package ps.mathematics;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준
 * - 4948번 (https://www.acmicpc.net/problem/4948)
 *
 * 문제
 * - 베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
 * 이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.
 * 예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)
 * 자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * - 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하는 한 줄로 이루어져 있다.
 * 입력의 마지막에는 0이 주어진다.
 *
 * 풀이
 * - 소수
 * - 에라토스테네스의 체 : O(Nlog(logN))
 * - 출력 : O(N)
 */
public class Baekjoon4948 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        while (num > 0) {
            final boolean[] primes = sieve(num * 2);
            int result = 0;

            // n 보다 크고 2n 이하인 소수 카운팅
            for (int i = num + 1; i <= num * 2; i++) {
                if (primes[i]) result++;
            }

            System.out.println(result);
            num = sc.nextInt();
        }
    }

    public static boolean[] sieve(final int n) {
        final boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true); // 모두 소수라고 가정
        primes[0] = false; // 0은 소수가 아님
        primes[1] = false; // 1은 소수가 아님

        // 에라토스테네스의 체
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!primes[i]) continue;

            for (int j = i * i; j <= n; j = j + i) {
                primes[j] = false;
            }
        }

        return primes;
    }

}
