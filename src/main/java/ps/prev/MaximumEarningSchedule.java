package ps.prev;

import java.util.*;

// https://cote.inflearn.com/contest/10/problem/09-04
public class MaximumEarningSchedule {

    /**
     *  N개의 기업에서 강연 요청이 있다.
     *  각 기업은 D일 안에 와서 강연을 해주면 M만큼의 강연료를 주기로 했다.
     *  각 기업이 요청한 D와 M을 바탕으로 가장 많은 돈을 벌 수 있도록 스케쥴을 짜야한다.
     *  단, 강연의 특성상 하루에 하나의 기업에서만 강연을 할 수 있다.
     *
     *
     *  1. 1 <= N <= 10,000
     *  2. 1 <= M <= 10,000
     *  3. 1 <= D <= 10,000
     *
     *  잘못 생각했던 점
     *  -> D, M의 설명을 제대로 이해하지 못해서 잘못 품. 기한이 없는 것처럼 풀어버림
     *  --> max day를 지정할 수 있었음
     *  -> 처음부터 Queue에 다 때려넣음
     *  --> 마지막 날부터 역으로 차근차근 넣어서 꺼내야 했음
     */

    static int n, maxDay;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        maxDay = 0;
        List<Schedule> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int pay = sc.nextInt();
            int day = sc.nextInt();
            maxDay = Math.max(maxDay, day);
            list.add(new Schedule(pay, day));
        }

        MaximumEarningSchedule mes = new MaximumEarningSchedule();
        System.out.println(mes.solution(list, maxDay));
    }

    public int solution(List<Schedule> list, int maxDay) {
        int earnings = 0;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(list);

        int j = 0;
        for (int i = maxDay; i >= 1; i--) {
            for ( ; j < n; j++) {
                if (list.get(j).day < i) break;
                queue.offer(list.get(j).pay);
            }
            if (!queue.isEmpty()) {
                earnings += queue.poll();
            }
        }

//        while (!queue.isEmpty()) {
//            Schedule schedule = queue.poll();
//            int pay = schedule.pay;
//            int day = schedule.day;
//            if (maxDay >= day) {
//                earnings += pay;
//                maxDay--;
//            }
//        }

        return earnings;
    }

}

class Schedule implements Comparable<Schedule> {
    int pay;
    int day;

    public Schedule(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }

    @Override
    public int compareTo(Schedule o) {
        if (o.day == this.day) return o.pay - this.pay;
        return o.day - this.day;
    }
}
