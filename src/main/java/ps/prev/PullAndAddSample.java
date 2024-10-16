package ps.prev;

import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/68644
public class PullAndAddSample {

    /**
     * 정수 배열 numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 만들 수 있는 모든 수를
     * 배열에 오름차순으로 담아 반환
     *
     * numbers의 길이는 2이상 100이하
     * numbers의 모든 수는 0이상 100이하
     */

    public static void main(String[] args) {
        PullAndAddSample pa = new PullAndAddSample();
//        int[] arr = new int[]{2,1,3,4,1};
        int[] arr = new int[]{5,0,2,7};
        int[] result = pa.solution(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int[] numbers) {
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i +1; j < numbers.length; j++) {
                result.add(numbers[i] + numbers[j]);
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }

}
