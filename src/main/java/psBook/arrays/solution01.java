package psBook.arrays;

import java.util.Arrays;
import java.util.Collections;

public class solution01 {

    /**
     * p.105
     * 정수 배열을 정렬해서 반환하시오
     *
     * 1) 정수 배열 길이 2 <= n <= 100,000
     * 2) 각 데이터 값은 -100,000 <= x <= 100,000
     */

    public static void main(String[] args) {

        int[] exam1 = new int[]{1, -5, 2, 4, 3};
        int[] exam2 = new int[]{2, 1, 1, 3, 2, 5, 4};
        int[] exam3 = new int[]{6, 1, 7};
        int[] solution1 = solution(exam1);
        System.out.println("Arrays.toString(solution1) = " + Arrays.toString(solution1));
        int[] solution2 = solution(exam2);
        System.out.println("Arrays.toString(solution2) = " + Arrays.toString(solution2));
        int[] solution3 = solution(exam3);
        System.out.println("Arrays.toString(solution3) = " + Arrays.toString(solution3));
    }

    public static int[] solution(int[] arrays) {
//        return Arrays.stream(arrays).sorted().toArray();
        Arrays.sort(arrays);
        return arrays;
    }

}
