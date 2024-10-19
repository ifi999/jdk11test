package ps.prev;

import java.util.Arrays;
import java.util.Scanner;

// https://www.youtube.com/watch?v=BA8zkffKc88&list=PLFgS-xIWwNVU_qgeg7wz_aMCk22YppiC6&index=5
public class SomeonesCommand {

    /**
     *  2개의 숫자를 합쳐서 고유한 숫자를 만든다.
     *  2개의 숫자의 범위는 1 <= N <= 15,000
     *  고유한 숫자의 범위는 1 <= M <= 10,000,000
     *
     *  좀 더 생각했어야하는 점
     *  N의 최대 범위가 15,000 -> O(nlogn) 가능
     *  --> 일반적인 정렬 알고리즘 시간 복잡도 = O(nlogn)이므로 정렬 사용 가능.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                if (arr[i] + arr[j] == m) {
//                    count++;
//                    break;
//                }
//            }
//        }

        Arrays.sort(arr);
        int lt = 0;
        int rt = n-1;
        while (lt < rt) {
            int tmp = arr[lt] + arr[rt];
            if (tmp == m) {
                count ++;
                lt++;
                rt--;
            }
            else if (tmp < m) {
                lt++;
            }
            else  {
                rt--;
            }
        }


        System.out.println(count);
    }

}
