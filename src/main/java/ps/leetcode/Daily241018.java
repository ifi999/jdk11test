package ps.leetcode;

import java.util.Scanner;

/**
 * leetcode
 * - 670. 최대 스왑 (https://leetcode.com/problems/maximum-swap)
 *
 * 문제
 * - 정수가 주어집니다 num. 최대 두 자릿수를 한 번만 바꿔서 최대값을 얻을 수 있습니다.
 * 얻을 수 있는 최대 값을 반환합니다 .
 *
 * 제약사항
 * - 0 <= num <= 10^8
 *
 * 풀이
 * - 순차적으로 탐색해서 교환 : O(N)
 *
 */
public class Daily241018 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int result = maximumSwap(n);
        System.out.println(result);
    }

    public static int maximumSwap(final int n) {
        final char[] numbers = Integer.toString(n).toCharArray(); // 숫자를 순회할 수 있도록 변환
        final int[] lastIndex = new int[10]; // 숫자 0 ~ 9까지 위치 배열

        for (int i = 0; i < numbers.length; i++) {
            lastIndex[numbers[i] - '0'] = i; // 숫자의 위치 기록
        }

        // 왼쪽부터 탐색
        for (int i = 0; i < numbers.length; i++) {
            // 현재 숫자보다 더 큰 숫자가 뒤에서 나오면 교환
            for (int j = 9; j > numbers[i] - '0'; j--) {
                if (lastIndex[j] > i) {
                    char tmp = numbers[i];
                    numbers[i] = numbers[lastIndex[j]];
                    numbers[lastIndex[j]] = tmp;

                    return Integer.parseInt(new String(numbers));
                }
            }
        }

        return n;
    }

}
