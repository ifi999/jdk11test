package ps;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42747
public class HIndexSample {

    /**
     * H-Index는 과학자의 생산성과 영향력을 나타내는 지표다.
     * 그것을 나타내는 값인 h를 구하려고 한다.
     * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면
     * h의 최댓값이 이 과학자의 H-Index이다.
     *
     * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 주어질 때, 이 과학자의 H-Index를 반환하시오
     *
     * n은 1이상 1,000이하
     * 논물별 인용 횟수는 0이상 10,000이하
     *
     * 최댓값을 구해야 하므로 가장 큰 값부터 조건을 만족하는지 검사
     * 정렬해서 배열 인덱스 값 기준 검사하면 될듯
     */

    public static void main(String[] args) {

    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length; i >= i; i--) {
            if (isValid(citations, i)) return i;
        }

        return 0;
    }

    private boolean isValid(int[] citations, int i) {
        int index = citations.length -i;

        return citations[index] >= i;
    }

}
