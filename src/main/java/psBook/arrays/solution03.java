package psBook.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class solution03 {

    /**
     * p.113
     * 정수 배열 numbers에서 서로 다른 인덱스에 있는 2개의 수를 뽑아,
     * 더해 만들 수 있는 모든 수를 배열에 오름차순으로 담아 반환하시오
     *
     * 1) numbers의 길이는 2 <= n <= 100
     * 2) numbers의 모든 수는 0 <= x <= 100
     */

    public static void main(String[] args) {

        int[] exam1 = new int[]{2, 1, 3, 4, 1};
        int[] exam2 = new int[]{5, 0, 2, 7};

        int[] solution1 = solution(exam1);
        System.out.println("Arrays.toString(solution1) = " + Arrays.toString(solution1));
        int[] solution2 = solution(exam2);
        System.out.println("Arrays.toString(solution2) = " + Arrays.toString(solution2));
    }

    public static int[] solution(int[] arrays) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < arrays.length; i++) {
            for (int j = i +1; j < arrays.length; j++) {
                set.add(arrays[i] + arrays[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

}
