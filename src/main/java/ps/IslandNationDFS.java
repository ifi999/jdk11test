package ps;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/08-13
public class IslandNationDFS {

    /**
     * N*N 섬나라의 지도가 주어진다.
     * 각 섬은 1로 표시되어 상화좌우, 대각선으로 연결되어 있고, 0은 바다다.
     * 섬나라에 몇 개의 섬이 있는지 구하시오.
     *
     * 1. 3 <= N <= 20
     */

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n;
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        IslandNationDFS in = new IslandNationDFS();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    count++;
                    in.DFS(i, j);
                }
            }
        }

        System.out.println(count);
    }

    public void DFS(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x +dx[i];
            int ny = y +dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }
}
