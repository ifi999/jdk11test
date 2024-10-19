package ps.prev;

import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/10-03
public class MaximumPartialIncrement {

    /**
     *
     */

    static int[] dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        MaximumPartialIncrement mpi = new MaximumPartialIncrement();
        System.out.println(mpi.solution(arr));
    }

    public int solution(int[] arr) {
        int result = 0;
        dy = new int[arr.length];
        dy[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] < arr[i] && dy[j] > max) max = dy[j];
            }
            dy[i] = max +1;
            result = Math.max(result, dy[i]);
        }

        return result;
    }

}
