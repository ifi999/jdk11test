package psBook.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class solution06 {

    /**
     * p.123
     * 전체 스테이지 개수가 N, 게임을 이용하는 사용자가 현재 멈춰 있는 스테이지의 번호가 담긴 배열 stages
     * 이 때 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 반환하시오
     * 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어의 수
     *
     * 1) 스테이지 개수는 1 <= N <= 500
     * 2) stages의 길이는 1 <= length <= 200,000
     * 3) stages의 값은 1 <= x <= N +1의 자연수
     *  3-1) 각 자연수는 사용자가 현재 도전 중인 스테이지 번호를 나타낸다
     *  3-2) 단, N +1은 마지막 스테이지, 즉 N까지 클리어한 사용자를 나타낸다
     * 4) 만약 실패율이 같은 스테이지가 있다면, 작은 번호의 스테이지가 먼저 오면 된다
     * 5) 스테이지에 도달한 유저가 없는 경우, 해당 스테이지의 실패율은 0으로 정의
     */

    public static void main(String[] args) {
        int N1 = 5;
        int[] stages1 = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
        int[] result1 = solution(N1, stages1);
        System.out.println(Arrays.toString(result1));

        int N2 = 4;
        int[] stages2 = new int[]{4, 4, 4, 4, 4};
        int[] result2 = solution(N2, stages2);
        System.out.println(Arrays.toString(result2));
    }

    public static int[] solution(int N, int[] stages) {
        int[] challengers = new int[N +2];
        for (int i = 0; i < stages.length; i++) {
            challengers[stages[i]]++;
        }

        Map<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        for (int i = 1; i <= N; i++) {
            if (challengers[i] == 0) {
                fails.put(i, 0.0);
            }
            else {
                fails.put(i, challengers[i] / total);
                total -= challengers[i];
            }
        }

        return fails.entrySet().stream()
                .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(HashMap.Entry::getKey)
                .toArray();
    }

}
