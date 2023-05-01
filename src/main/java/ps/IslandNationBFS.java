package ps;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/08-13
public class IslandNationBFS {

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
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        IslandNationBFS in = new IslandNationBFS();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    count++;
                    queue.offer(new Point(i, j));
                    in.BFS();
                }
            }
        }

        System.out.println(count);
    }

    public void BFS() {
        // 보통 여기에 queue.offer 하는듯? 큰 차이는 없을 것 같은데??
        while (!queue.isEmpty()) {
            Point tmp = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = tmp.x +dx[i];
                int ny = tmp.y +dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }
}

