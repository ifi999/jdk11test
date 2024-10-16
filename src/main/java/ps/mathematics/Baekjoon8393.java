package ps.mathematics;

import java.util.Scanner;

/**
 * 백준
 * - 8393번 (https://www.acmicpc.net/problem/8393)
 *
 * 문제
 * - n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * - 첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.
 *
 * 출력
 * - 1부터 n까지 합을 출력한다.
 */
public class Baekjoon8393 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int a = sc.nextInt();
        int copyA = a;
        int sum = 0;
        while (copyA > 0) {
            sum += copyA--;
        }
        System.out.println(sum);
    }

}
