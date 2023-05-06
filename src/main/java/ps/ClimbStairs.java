package ps;

import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/10-01
public class ClimbStairs {

    /**
     *  복잡도로 따지면 너무 큰 문제 -> 문제를 잘게 쪼개서 생각 : Dynamic
     *  앞에서 구한 값들을 기억해두고, 확장해서 구하는 값에 적용
     *
     *  1 : 1
     *  2 : 2
     *  3 : 2 + 1 = 3
     *  4 : 3 + 2 = 5
     *  5 : 5 + 3 = 8
     *  ...
     *
     */

    // dy : dynamic
    static int[] dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n+1];

        ClimbStairs cs = new ClimbStairs();
        cs.solution(n);
        System.out.println(dy[n]);
    }

    public int solution(int n) {
        if (n == 1 || n == 2) return n;

        return dy[n] = solution(n-1) + solution(n-2);
    }

    // 영상 문제풀이 방법
    // 내가 푼 것과 다른점 : 나는 위에서 아래로 내려오는거고 이건 아래서 위로 올라오는 방식이네 뭐가 더 빠를까
    // --> 스택 쌓이는 것 없이 아래서부터 올라가는 것이 나을 것 같음
//    public int solution(int n) {
//        dy[1] = 1;
//        dy[2] = 2;
//
//        for (int i = 3; i <= n; i++) {
//            dy[i] = dy[i-2] + dy[i-1];
//        }
//
//        return dy[n];
//    }

}
