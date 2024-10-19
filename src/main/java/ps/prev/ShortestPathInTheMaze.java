package ps.prev;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/08-11
public class ShortestPathInTheMaze {

    /**
     * BFS
     * dx,dy 정의
     * 돌아온길 못가게 0 -> 1 처리
     */

    //                  12 3  6  9
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int[][] dis;
//    static boolean flag = true;
//    static Queue<Position> queue;

    public static void main(String[] args) {
        ShortestPathInTheMaze sp = new ShortestPathInTheMaze();
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        dis = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        sp.solution(1, 1);

        if (dis[7][7] == 0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }

    public void solution(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        board[x][y] = 1;

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


    // time out 나옴 -> 실패 시 조건을 제대로 보지 않은 문제였음. result의 기본 값이 0이 아니라 -1이었으면 한번에 통과했을 것, board[nx][ny] == 0은 필요 없음
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        board = new int[8][8];
//        for (int i = 1; i <= 7; i++) {
//            for (int j = 1; j <= 7; j++) {
//                board[i][j] = sc.nextInt();
//            }
//        }
//
//        board[1][1] = 1;
//
//        int depth = 0;
//        int result = 0;
//        Position start = new Position(1, 1, depth);
//        queue = new LinkedList();
//        queue.add(start);
//
//        while (!queue.isEmpty()) {
//            Position position = queue.poll();
//            int x = position.x;
//            int y = position.y;
//            int d = position.depth;
//            if (flag) {
//                if (x == 7 && y == 7) {
//                    flag = false;
//                    result = d;
//                    break;
//                }
//                else {
//                    for (int i = 0; i < 4; i++) {
//                        int nx = x +dx[i];
//                        int ny = y +dy[i];
//
//                        if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
//                            board[nx][ny] = 1;
//                            queue.add(new Position(nx, ny, d+1));
//                            // board[nx][ny] = 0; // 필요없음. 다시 되돌아갈 이유가 없기 때문
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(result);
//    }
//
//}
//
//class Position {
//    int x;
//    int y;
//    int depth;
//
//    public Position(int x, int y, int depth) {
//        this.x = x;
//        this.y = y;
//        this.depth = depth;
//    }
//}
