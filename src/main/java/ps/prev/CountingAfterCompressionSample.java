package ps.prev;

// https://school.programmers.co.kr/learn/courses/30/lessons/68936
public class CountingAfterCompressionSample {

    /**
     * 0,1로 이루어진 2^n * 2^n 크기의 2차원 정수 배열 arr.
     * 이 arr을 쿼드 트리와 같은 방식으로 압축하고자 한다.
     * 압축 진행 후, 배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아서 반환
     *
     * 1.상태
     *   - (offsetX, offsetY, size)
     * 2.종료 조건
     *   - 모든 원소가 0일 때 -> {0:1, 1:0} --> 0이 1개, 1이 0개
     *     모든 원소가 1일 때 -> {0:0, 1:1} --> 0이 0개, 1이 1개
     * 3.점화식
     *   - (offsetX, offsetY, size) = (offsetX,         offsetY,            size/2)         - 좌상
     *                              + (offsetX +size/2, offsetY,            size +size/2)   - 우상
     *                              + (offsetX,         offsetY +size/2,    size +size/2)   - 좌하
     *                              + (offsetX +size/2, offsetY +size/2,    size +size/2)   - 우하
     */

    public static void main(String[] args) {
        CountingAfterCompressionSample ca = new CountingAfterCompressionSample();
//        int[] result = ca.solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}});
        int[] result = ca.solution(new int[][]{{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}});
        System.out.println("result = " + result[0]);
        System.out.println("result = " + result[1]);
    }

    public int[] solution(int[][] arr) {
        // 0,0 부터 시작해서, arr 길이만큼의 크기로 시작
        Count count = count(0, 0, arr.length, arr);

        return new int[] {count.zero, count.one};
    }

    private Count count(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size/2;
        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {
                // 돌다가 offsetX, offsetY 기준 값과 다르면, 원소가 섞여 있다는 것
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    // 원소가 섞여 있는 경우 반환
                    return count(offsetX, offsetY, h, arr)
                            .add(count(offsetX +h, offsetY, h, arr))
                            .add(count(offsetX, offsetY +h, h, arr))
                            .add(count(offsetX +h, offsetY +h, h, arr));
                }
            }
        }

        // 모든 원소가 같은 값인 경우
        // 위에서 다른 것이 없었으므로, 모든 값이 1인 경우
        if (arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }

        // 모든 값이 0인 경우
        return new Count(1, 0);
    }
}

// 남아있는 0,1 개수 나타낼 클래스
class Count {
    public final int zero;
    public final int one;

    public Count(int zero, int one) {
        this.zero = zero;
        this.one = one;
    }

    public Count add(Count other) {
        return new Count(zero + other.zero, one + other.one);
    }
}
