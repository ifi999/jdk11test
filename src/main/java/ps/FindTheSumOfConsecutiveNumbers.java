package ps;

import java.util.Scanner;

// https://www.youtube.com/watch?v=ZovjkF2DzIs&list=PLFgS-xIWwNVU_qgeg7wz_aMCk22YppiC6&index=4
public class FindTheSumOfConsecutiveNumbers {

    /**
     *  자연수 N은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. (1 <= N <= 10,000,000)
     *  N을 몇 개의 연속된 자연수의 합으로 나타내는 가짓수를 구하시오.
     *
     *  10,000,000 -> O(nlogn)도 안됨
     *
     *  lt = 0, rt = 1, n = 15
     *
     *  1 2 3 4 5 6 7 8 9 10 ...
     *  o o o o o                 (0, 5, 15)
     *        o o o               (4, 6, 15)
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int lt = 0, rt = 1;
//        int sum = 0;
//        int result = 0;
//        while (lt < rt) {
//            if (sum == n) {
//                result++;
//                if (lt == 0) lt = 1;
//                sum -= lt;
//                lt++;
//            }
//            else if (sum > n) {
//                sum -= lt;
//                lt++;
//            }
//            else {
//                sum += rt;
//                rt++;
//            }
//        }

        // 영상 풀이 내용
        int result = 1;
        int lt = 1;
        int rt = 1;
        int sum = 1;
        // while 조건이 좀 더 안정적인듯
        while (lt != n) {
            if (sum == n) {
                result++;
                lt++;
                sum += lt;
            }
            else if (sum > n) {
                sum -= rt;
                rt++;
            }
            else {
                lt++;
                sum += lt;
            }
        }

        System.out.println(result);
    }
}
