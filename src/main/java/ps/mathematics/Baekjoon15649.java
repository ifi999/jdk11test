package ps.mathematics;

import java.util.Scanner;

/**
 * 백준
 * - 15649번 (https://www.acmicpc.net/problem/15649)
 *
 * 문제
 * - 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 *
 * 입력
 * - 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 *
 * 풀이
 * - 백트래킹
 */
public class Baekjoon15649 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int m = sc.nextInt();

        // 방문 체크
        final boolean[] visited = new boolean[n + 1];
        // 수열 저장
        final int[] sequence = new int[m];

        // 백트래킹
        backtracking(n, m, 0, sequence, visited);
    }

    public static void backtracking(final int n, final int m, final int depth, final int[] sequence, final boolean[] visited) {
        // 종료 조건
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }

        // 1부터 N까지 순차적
        for (int i = 1; i <= n; i++) {
            // 방문하지 않은 곳만
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = i;
                backtracking(n, m, depth + 1, sequence, visited);
                visited[i] = false;
            }
        }
    }

}
