package psBook.arrays;

import java.util.Arrays;
import java.util.Collections;

public class solution02 {

    /**
     * p.109
     * 배열의 중복값을 제거하고, 배열의 값을 내림차순으로 정렬하시오
     *
     * 1) 배열의 길이는 2 <= n <= 1,000
     * 2) 각 배열의 값은 -100,000 <= x <= 100,000
     */

    public static void main(String[] args) {

        int[] exam1 = new int[]{4, 2, 2, 1, 3, 4};
        int[] exam2 = new int[]{2, 1, 1, 3, 2, 5, 4};

        int[] solution1 = solution(exam1);
        System.out.println("Arrays.toString(solution1) = " + Arrays.toString(solution1));
        int[] solution2 = solution(exam2);
        System.out.println("Arrays.toString(solution2) = " + Arrays.toString(solution2));
    }

    public static int[] solution(int[] arrays) {
        Integer[] result = Arrays.stream(arrays).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());

        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

}
