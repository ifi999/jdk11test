package ps.mathematics;

import java.util.Scanner;

/**
 * 백준
 * - 2609번 (https://www.acmicpc.net/problem/2609)
 *
 * 문제
 * - 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * - 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
 *
 * 출력
 * - 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
 *
 * 풀이
 * - 유클리드 호제법 : O(log(min(a,b)))
 */
public class Baekjoon2609 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int m = sc.nextInt();

        final int gcd = gcd(n,m);
        final int lcd = n * m / gcd;

        System.out.println(gcd);
        System.out.println(lcd);
    }

    private static int gcd(int n, int m) {
        while (m != 0) {
            int tmp = n % m;
            n = m;
            m = tmp;
        }

        return n;
    }

}
