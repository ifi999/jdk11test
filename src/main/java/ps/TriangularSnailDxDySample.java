package ps;

public class TriangularSnailDxDySample {

    /**
     * 2차원 배열에서는 방향을 이용하는 문제가 많이 등장한다.
     * 이런 문제는 대부분 방향만 다를 뿐 각 방향에서 수행하는 동작은 같다.
     * 그런데 각 방향마다 구현을 다르게 한다면 실수했을 때 디버깅 하기 힘들 뿐만 아니라,
     * 구현 방법을 바꾸어야할 때 모든 방향의 코드를 수정해야 한다.
     *
     * 이러한 불편함을 최소화하고자 dx, dy를 사용하는 방법을 알아야한다.
     *
     *      상   하   좌   우
     * dx   0   0   -1   1
     * dy  -1   1    0   0
     *
     * 이번 문제에서 필요한 방향은
     *      하   우   좌상
     * dx   0    1   -1
     * dy   1    0   -1
     */

    public static void main(String[] args) {
        TriangularSnailDxDySample tsdd = new TriangularSnailDxDySample();
        int[] result = tsdd.solution(4);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int x = 0;
        int y = 0;
        int count = 1;
        int d = 0;

        while (true) {
            arr[y][x] = count++;

            int nx = x + dx[d];
            int ny = y + dx[d];

            if (nx == n || ny == n || nx == -1 || ny == -1 || arr[ny][nx] != 0) {
                // d 값 변화
                // 아래 : 0, 우측 : 1, 좌상 : 2
                d = (d +1) % 3;
                nx = x +dx[d];
                ny = y + dx[d];

                // 방향 전환된 nx, ny값 마저 막힌다면 break
                if (nx == n || ny == n || nx == -1 || ny == -1 || arr[ny][nx] != 0) {
                    break;
                }

                // x,y 값을 방향 전환된 값으로 세팅
                x = nx;
                y = ny;
            }
        }

        int[] result = new int[count -1];
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[tmp++] = arr[i][j];
            }
        }

        return result;
    }
}
