package ps;

// https://school.programmers.co.kr/learn/courses/30/lessons/12949
public class MultiplicationOfMatrixSample {

    /**
     * 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수 만들기
     */

    public static void main(String[] args) {
        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        // 목표 결과 [[22, 22, 11], [36, 28, 18], [29, 20, 14]]

        MultiplicationOfMatrixSample mo = new MultiplicationOfMatrixSample();
        int[][] result = mo.solution(arr1, arr2);
        for (int[] ints : result) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < arr1[i].length; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }

}
