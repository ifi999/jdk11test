package ps;

import java.util.Scanner;

// https://www.youtube.com/watch?v=0uhy851SDng&list=PLFgS-xIWwNVU_qgeg7wz_aMCk22YppiC6
public class FindTheSumOfNumbers {

    /**
     *  char : '1' - 48 -> 1
     *  *** 문자형 숫자 - 48 = 숫자
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char[] arr = str.toCharArray();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += (arr[i] -48);
//            sum += arr[i] -'0';
        }

        System.out.println(sum);
    }

}
