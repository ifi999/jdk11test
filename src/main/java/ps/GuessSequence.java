package ps;

import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/08-08
public class GuessSequence {

    /**
     * 가장 윗줄에 1부터 N까지의 숫자가 1개씩 적혀 있다.
     * 둘째 줄부터 파스칼의 삼각형처럼 위의 2개를 더한 값이 저장된다.
     * N과 가장 밑에 있는 숫자가 주어졌을 때, 가장 윗줄에 있는 숫자를 구하시오.
     *
     * 1. 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력
     * 2. 1 <= N <= 10
     * 3. N은 가장 윗줄에 있는 숫자의 개수, F는 가장 밑에 줄에 있는 수 (1,000,000 이하)
     */

    static int[] b, ch, p;
    static int n, f;
    boolean flag = false;
    int[][] dy = new int[35][35];

    public int combi(int n, int r) {
        if(r == 0 || r == n ) return 1;

        if(dy[n][r] == 0) {
            dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
        }

        return dy[n][r];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n+1]; // 1부터 N까지이므로

        GuessSequence gs = new GuessSequence();
        for (int i = 0; i < n; i++) {
            b[i] = gs.combi(n-1, i);
        }
        gs.solution(0, 0);
    }

    public void solution(int depth, int sum) {
        if (flag) return;
        if (depth == n) {
            if (sum == f) {
                for(int i : p) {
                    System.out.print(i + " ");
                    // flag 만들지 않으면 모든 경우의수 출력
                    flag = true;
                }
                System.out.println();
            }
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[depth] = i;
                    solution(depth +1, sum +(p[depth] *b[depth]));
                    ch[i] = 0;
                }
            }
        }
    }

    // 잘못된 발상이었음
//    public void solution(int depth, int n, int f) {
//        if (depth == n) {
//            int sum = Arrays.stream(tmp).sum();
//            if (sum == f) {
//                for(int i : tmp) {
//                    System.out.print(i + " ");
//                }
//                System.out.println();
//            }
//        }
//        else {
//            for (int i = 0; i < n; i++) {
//                if (ch[i] == 0) {
//                    ch[i] = 1;
//                    tmp[i] = arr[i];
//                    solution(depth +1, n, f);
//                    ch[i] = 0;
//                }
//            }
//        }
//    }

}
