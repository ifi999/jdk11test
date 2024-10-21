package ps.mathematics;

import java.util.Scanner;

/**
 * 백준
 * - 1182번 (https://www.acmicpc.net/problem/1182)
 *
 * 문제
 * - N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * - 첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
 *
 * 출력
 * - 첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
 *
 * 풀이
 * - 완전탐색 : O(2^N)
 */
public class Baekjoon1182 {

    static int COUNT = 0;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int s = sc.nextInt();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 완전탐색 O(2^N)
        bruteForce(s, n, 0, 0, arr);

        // 합이 0인 경우 공집합 제거
        if (s == 0) COUNT--;

        System.out.println(COUNT);
    }

    private static void bruteForce(final int s, final int n, final int depth, final int sum, final int[] arr) {
        // 기본 조건
        if (depth == n) {
            if (sum == s) COUNT++;
            return;
        }

        // 현재 depth 요소를 선택
        bruteForce(s, n, depth + 1, sum + arr[depth], arr);

        // 현재 depth 요소를 선택하지 않음
        bruteForce(s, n, depth + 1, sum, arr);
    }

}
