package ps.mathematics;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준
 * - 9020번 (https://www.acmicpc.net/problem/9020)
 *
 * 문제
 * - 1보다 큰 자연수 중에서  1과 자기 자신을 제외한 약수가 없는 자연수를 소수라고 한다. 예를 들어, 5는 1과 5를 제외한 약수가 없기 때문에 소수이다. 하지만, 6은 6 = 2 × 3 이기 때문에 소수가 아니다.
 * 골드바흐의 추측은 유명한 정수론의 미해결 문제로, 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다는 것이다. 이러한 수를 골드바흐 수라고 한다. 또, 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다. 예를 들면, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7이다. 10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다.
 * 2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오. 만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다.
 *
 * 입력
 * - 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고 짝수 n이 주어진다.
 *
 * 출력
 * - 각 테스트 케이스에 대해서 주어진 n의 골드바흐 파티션을 출력한다. 출력하는 소수는 작은 것부터 먼저 출력하며, 공백으로 구분한다.
 *
 * 제한
 * - 4 ≤ n ≤ 10,000
 *
 * 풀이
 * - 에라토스테네스의 체 : Nlog(logN)
 * - 소수 배열 반 순회 : log(N//)
 */
public class Baekjoon9020 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 제한 값인 10000까지 에라토스테네스의 체 판별
        final boolean[] primes = sieve(10000);

        while (n-- > 0) {
            final int target = sc.nextInt();

            // 두 소수의 차이가 최소가 되는 골드바흐 파티션 찾기
            int first = 0, second = 0;
            for (int i = target / 2; i >= 2; i--) {
                if (primes[i] && primes[target - i]) {
                    first = i;
                    second = target - i;
                    break;
                }
            }
            System.out.println(first + " " + second);
        }

    }

    public static boolean[] sieve(final int n) {
        final boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true); // 모두 소수라고 가정
        primes[0] = false; // 0은 소수가 아님
        primes[1] = false; // 1은 소수가 아님

        // 에라토스테네스의 체
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!primes[i]) continue; // 소수가 아니면 패스

            for (int j = i * i; j <= n; j = j + i) {
                primes[j] = false;
            }
        }

        return primes;
    }

}
