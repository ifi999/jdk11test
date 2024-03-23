package psBook.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution04 {

    /**
     * p.116
     * 1번 문제부터 마지막 문제까지의 정답이 순서대로 저장된 배열 answers가 주어졌을 때,
     * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 반환하시오
     *
     * 1) 문제는 최대 10,000개로 구성되어 있음
     * 2) 문제의 정답은 1, 2, 3, 4, 5 중에 하나
     * 3) 가장 높은 점수를 받은 사람이 여럿이라면 반환하는 값을 오름차순으로 정렬
     */

    public static void main(String[] args) {

        int[] exam1 = new int[]{1, 2, 3, 4, 5};
        int[] exam2 = new int[]{1, 3, 2, 4, 2};

        int[] solution1 = solution(exam1);
        System.out.println("Arrays.toString(solution1) = " + Arrays.toString(solution1));
        int[] solution2 = solution(exam2);
        System.out.println("Arrays.toString(solution2) = " + Arrays.toString(solution2));
    }

    public static int[] solution(int[] arrays) {
        int[] person1 = new int[]{1, 2, 3, 4, 5};
        int[] person2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];

        for (int i = 0; i < arrays.length; i++) {
            if (person1[i % person1.length] == arrays[i]) scores[0]++;
            if (person2[i % person2.length] == arrays[i]) scores[1]++;
            if (person3[i % person3.length] == arrays[i]) scores[2]++;
        }

        int max = Arrays.stream(scores).max().getAsInt();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) result.add(i +1);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
