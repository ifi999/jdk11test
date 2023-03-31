package ps;

import java.util.stream.IntStream;

// https://school.programmers.co.kr/learn/courses/30/lessons/42840
public class PracticeTestSample {

    /**
     * 답 찍는 사람들이 3명 있음.
     * 1번 : 1,2,3,4,5, 1,2,3,4,5, 1,2,3,4,5 ...
     * 2번 : 2,1, 2,3, 2,4, 2,5, 2,1 ...
     * 3번 : 3,3, 1,1, 2,2, 4,4, 5,5, 3,3 ...
     *
     * 정답 들은 배열 answer이 주어질 때, 가장 많이 맞힌 사람은 누구? 중복인 경우에는 오름차순 정렬로 반환
     *
     * 풀이
     * 시간 복잡도 : 문제 개수를 N이라고 했을 때, 1명당 O(N) 소요
     * 3명이므로 O(NM)
     * N은 최대 10000, M은 3이므로 최대 30,000 -> 1초 기준 충분한 시간 복잡도
     */

    private static final int[][] RULES = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
    };

    public static void main(String[] args) {
        PracticeTestSample pts = new PracticeTestSample();
//        int[] result = pts.solution(new int[]{1, 2, 3, 4, 5});
        int[] result = pts.solution(new int[]{1, 3, 2, 4, 2});
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int[] answers) {
        int[] corrects = new int[3];
        int max = 0;

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];

            // 각 사람별로 정답 개수 세기
            for (int person = 0; person < 3; person++) {
                int picked = getPicked(person, i);
                if (answer == picked) {
//                    corrects[person]++;
//                    // max 갱신
//                    if (corrects[person] > max) {
//                        max = corrects[person];
//                    }

                    // 전위 증가 연산자로 수정
                    if (++corrects[person] > max) {
                        max = corrects[person];
                    }
                }
            }
        }

        // 익명 메서드 사용할 때 외부 변수 참조하는 경우, 불변이어야 함 -> final 키워드 사용
        final int maxCorrects = max;
        return IntStream.range(0, 3)
                .filter(i -> corrects[i] == maxCorrects)
                .map(i -> i+1)
                .toArray();
    }

    // 해당 인덱스의 사람이 해당 문제 번호를 무엇으로 찍었는지
    private int getPicked(int person, int problem) {
        // 해당 인덱스 사람의 정답 배열 가져오기
        int[] rule = RULES[person];

        // 문제 번호가 정답 배열의 몇 번째 것인지
        int index = problem % rule.length;

        // 위에서 구한 인덱스로 정답 배열에서 값 꺼내기
        return rule[index];
    }
}
