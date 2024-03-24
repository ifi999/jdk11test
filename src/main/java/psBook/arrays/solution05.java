package psBook.arrays;

import java.util.Arrays;

public class solution05 {

    /**
     * p.120
     * 2차월 행렬 arr1, arr2를 입력받아 arr1에 arr2를 곱한 결과를 반환하시오
     *
     * 1) 행렬 arr1, arr2의 행과 열의 길이는 2 <= n,m <= 100
     * 2) 행렬 arr1, arr2의 값은 -10 <= x <= 20 인 자연수
     * 3) 곱할 수 있는 배열만 주어진다
     */

    public static void main(String[] args) {

        int[][] exam1Arr1 = new int[][]{{1, 4}, {3, 2}, {4, 1}};
        int[][] exam1Arr2 = new int[][]{{3, 3}, {3, 3}};
        int[][] exam2Arr1 = new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] exam2Arr2 = new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        int[][] solution1 = solution(exam1Arr1, exam1Arr2);
        for (int[] ints : solution1) {
            System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
        }
        int[][] solution2 = solution(exam2Arr1, exam2Arr2);
        for (int[] ints : solution2) {
            System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
        }
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1Length1 = arr1.length;
        int arr1Length2 = arr1[0].length;
        int arr2Length1 = arr2.length;
        int arr2Length2 = arr2[0].length;

        if (arr1Length2 != arr2Length1) {
            //
        }

        int[][] result = new int[arr1Length1][arr2Length2];

        for (int i = 0; i < arr1Length1; i++) {
            for (int j = 0; j < arr2Length2; j++) {
                for (int k = 0; k < arr1Length2; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }

}
