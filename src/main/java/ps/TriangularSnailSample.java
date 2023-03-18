package ps;

public class TriangularSnailSample {
    // 크기 n*n인 2차원 배열 생성
    // 방향 진행이 막힐 때까지 숫자 채우기
    // 반환 후 int[]로 변경

    public static void main(String[] args) {
        TriangularSnailSample ts = new TriangularSnailSample();
        int[] result = ts.solution(4);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int count = 1;
        int x = 0;
        int y = 0;

        while (true) {
            // 1. 아래로 내려가기
            while (true) {
                arr[y][x] = count++;
                if (y +1 == n || arr[y +1][x] != 0) break;
                y++;
            }
            // 다음이 오른쪽 이동인데 마지막 칸이거나, 이미 적혀있다면 break
            if (x +1 == n || arr[y][x +1] != 0) break;
            x++;

            // 2. 아래가 끝이면 오른쪽 가기
            while (true) {
                arr[y][x] = count++;
                if (x +1 == n || arr[y][x +1] != 0) break;
                x++;
            }
            // 다음이 대각선 이동인데 그 곳이 이미 적혀있다면 break
            if (arr[y -1][x -1] != 0) break;
            x--;
            y--;

            // 3. 오른쪽이 끝이면 대각선 위로 가기
            while (true) {
                arr[y][x] = count++;
                if (arr[y -1][x -1] != 0) break;
                x--;
                y--;
            }
            // 다시 아래로 이동이니 불가능하다면 break
            if (y +1 == n || arr[y +1][x] != 0) break;
            y++;
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
