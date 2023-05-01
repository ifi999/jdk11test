package ps;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/08-12
public class TomatoFarm {

    /**
     *  가로 M, 세로 N 상자가 있다.
     *  상자에 보관된 토마토 중에는 잘 익은 것과 아직 익지 않은 토마토들이 있다.
     *  토마토는 인접한 상하좌우의 토마토에 영향을 끼친다.
     *  익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 이 영향을 받아 익게 된다.
     *  혼자 저절로 익는 경우는 없다고 가정한다.
     *  창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지에 대한 최소 일수는?
     *
     *  1. 2<= M,N <= 1,000
     *  2. 정수 1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토가 들어있지 않은 칸
     *
     *  --> BFS
     *  1. 그런데 1의 위치를 처음에 어떻게 전부 제공하지?
     *     -> 처음에 입력받을 때 1인 곳의 위치를 찍어두나?
     *     --> 그냥 바로 Queue에 넣기
     *  2. 카운팅은 어떻게 하지?
     *     -> dis[][]
     */

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;
    static int n, m;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        board = new int[n][m];
        dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        TomatoFarm tf = new TomatoFarm();
        tf.BFS();
        int result = tf.check();

        System.out.println(result);
    }

    public int check() {
        for (int[] ints : board) {
            for (int i : ints) {
                if (i == 0) return -1;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int[] di : dis) {
            for (int i : di) {
//                if (i > max) max = i;
                max = Math.max(max, i);
            }
        }

        return max;
    }

    public void BFS() {
        while(!queue.isEmpty()) {
            Point tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] +1;
                }
            }
        }
    }

}

