package ps.mathematics;

import java.util.*;

/**
 * 백준
 * - 1929번 (https://www.acmicpc.net/problem/1929)
 *
 * 문제
 * - 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * - 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 *
 * 출력
 * - 소수
 * - 주어진 수들 중 소수의 개수를 출력한다.
 */
public class Baekjoon1978 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        if (n < 1 || n > 100) {
            return;
        }

        final Set<Integer> numbers = new HashSet<>();
        int max = 0;

        for (int i = 0; i < n; i++) {
            final int num = sc.nextInt();
            if (num < 1 || num > 1000) return;
            if (num > max) max = num;
            numbers.add(num);
        }

        final boolean[] primes = sieve(max);

        int count = 0;
        for (Integer number : numbers) {
            if (primes[number]) count++;
        }
        System.out.println(count);
    }

    public static boolean[] sieve(final int n) {
        final boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true); // 모두 소수라고 가정
        primes[0] = false; // 0은 소수가 아님
        primes[1] = false; // 1은 소수가 아님

        // 에라토스테네스의 체
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!primes[i]) continue; // 소수가 아니면 패스

            // i의 배수는 소수가 아님
            for (int j = i * i; j <= n; j = j + i) {
                primes[j] = false;
            }
        }

        return primes;
    }

}
