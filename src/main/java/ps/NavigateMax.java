package ps;

import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/08-10
public class NavigateMax {

    /**
     *  DFS.
     *  왔던 길을 되돌아가지 못하게 0 -> 1 처리 필요
     *  dx, dy 정의
     *
     */

    //                  12  3  6  9  (시)
    static int[] dx = { -1, 0, 1, 0};
    static int[] dy =  { 0, 1, 0, -1};
    static int[][] board = new int[8][8];
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        board[1][1] = 1;
        NavigateMax nm = new NavigateMax();
        nm.solution(1, 1);
        System.out.println(result);
    }

    public void solution(int x, int y) {
        if (x == 7 && y == 7) result++;
        else {
            // 방향 전환
            for (int i = 0; i < 4; i++) {
                int nx = x +dx[i];
                int ny = y +dy[i];

                // 범위 + 다음 칸을 방문한 적 없는지
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    solution(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }
}
