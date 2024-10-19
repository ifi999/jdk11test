package ps.prev;

import java.util.Scanner;

// https://www.youtube.com/watch?v=mkamgN5UiKU&list=PLFgS-xIWwNVU_qgeg7wz_aMCk22YppiC6&index=6
public class DNASecretNumber {

    /**
     *  슬라이딩 윈도우 : 포인터로 범위를 지정한 다음, 범위를 유지한 채로 이동
     *
     *
     */

    static int[] required;
    static int[] counted;
    static int checkSecret;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        required = new int[4];
        checkSecret = 0;
        // A, C, G, T
        for (int i = 0; i < 4; i++) {
            required[i] = sc.nextInt();
            if (required[i] == 0) {
                checkSecret++;
            }
        }

        int lt = 0;
        int rt = m-1;
        int result = 0;
        // A, C, G, T
        counted = new int[4];

        // 부분문자열 처음 받을 때 세팅
        for (int i = 0; i < m; i++) {
            Add(arr[i]);
        }

        if (checkSecret == 4) result++;
        System.out.println("?? : " + result);

        for (int i = m; i < n; i++) {
            int j = i-m;
            Add(arr[i]);
            Remove(arr[j]);
            if (checkSecret == 4) result++;
            System.out.println(i + " : " + result);
        }

        System.out.println(result);
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A' :
                if (counted[0] == required[0]) checkSecret--;
                counted[0]--;
                break;
            case 'C' :
                if (counted[1] == required[1]) checkSecret--;
                counted[1]--;
                break;
            case 'G' :
                if (counted[2] == required[2]) checkSecret--;
                counted[2]--;
                break;
            case 'T' :
                if (counted[3] == required[3]) checkSecret--;
                counted[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A' :
                if (counted[0] == required[0]) checkSecret++;
                counted[0]++;
                break;
            case 'C' :
                if (counted[1] == required[1]) checkSecret++;
                counted[1]++;
                break;
            case 'G' :
                if (counted[2] == required[2]) checkSecret++;
                counted[2]++;
                break;
            case 'T' :
                if (counted[3] == required[3]) checkSecret++;
                counted[3]++;
                break;
        }
    }

}
