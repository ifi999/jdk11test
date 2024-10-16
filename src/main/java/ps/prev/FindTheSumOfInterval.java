package ps.prev;

import java.util.Scanner;

// https://www.youtube.com/watch?v=JSfXW7UJ04Y&list=PLFgS-xIWwNVU_qgeg7wz_aMCk22YppiC6&index=3
public class FindTheSumOfInterval {

    /**
     *  수 N개가 주어졌을 때 i번째 수에서 j번째 수까지의 합을 구하시오.
     *
     *  1. N : 수의 개수 (1 <= N <= 100,000)
     *  2. M : 합을 구해야하는 횟수 (1 <= M <= 100,000)
     *
     *  생각 못한 점
     *  -> 1. 합 배열 만들기
     *  --> 2 ~ 4구간 합은 4까지 합 - 1까지 합을 하면 얻을 수 있다
     *  -> 2. 받는 데이터가 많을 때는 BufferedReader 사용하는 것이 속도에 이점 있다고 함
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        int[] sumArr = new int[n+1];
        for (int i = 1; i <= n; i++) {
//            arr[i] = sc.nextInt();
            sumArr[i] = sumArr[i-1] + sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(sumArr[b]-sumArr[a-1]);
        }

//        FindTheSumOfInterval ft = new FindTheSumOfInterval();
//        for (int i = 0; i < m; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            System.out.println(ft.solution(arr, a, b));
//        }
    }

    public int solution(int[] arr, int a, int b) {
        int result = 0;
        for (int i = a-1; i < b; i++) {
            result += arr[i];
        }
        return result;
    }
}
