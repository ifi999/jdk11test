package ps;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42748
public class KthNumberSample {

    /**
     * 배열 array의 i번째 숫자부터 j번째 숫자까지 고르고 정렬. 이후 k번쨰 수 구하기
     */

    public static void main(String[] args) {
        KthNumberSample kns = new KthNumberSample();
        int[] arr = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = kns.solution(arr, commands);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];

        for (int i = 0; i < result.length; i++) {
            int[] command = commands[i];

            int from = command[0] -1; // index 0부터
            int to = command[1];      // 마지막 위치는 포함안되므로
            int k = command[2] -1;    // index 0부터

            int[] tmp = Arrays.copyOfRange(array, from, to);
            Arrays.sort(tmp);
            result[i] = tmp[k];
        }

        return result;
    }
}
