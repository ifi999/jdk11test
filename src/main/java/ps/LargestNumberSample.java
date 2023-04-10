package ps;

import java.util.Arrays;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/42746
public class LargestNumberSample {

    /**
     * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만ㄷ르 수 있는 가장 큰 수 반환
     * 예를 들어, 주어진 정수가 {6, 10, 2}라면 가장 큰 수는 6210.
     *
     * numbers의 길이는 1이상 100,000이하
     * numbers의 원소는 0이상 1,000이하
     * 정답이 너무 클 수도 있으니 문자열로 바꾸어 반환
     */

    public static void main(String[] args) {
        LargestNumberSample lns = new LargestNumberSample();
        int[] numbers = {6, 10, 2};
        String result = lns.solution(numbers);
        System.out.println("result = " + result);
    }

    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    int original = Integer.parseInt(s1 + s2);
                    int reversed = Integer.parseInt(s2 + s1);
                    return reversed - original;
                })
                .collect(Collectors.joining())
                .replaceAll("^0+", "0");
    }
}
