package ps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/09-03
public class WeddingReception {

    /**
     * 피로연 장소를 빌려서 3일간 쉬지 않고 하려고 한다.
     * 피로연에 참석하는 친구들 N명의 참석하는 시간 정보는 알고 있다.
     * 시간 정보는 개개인이 몇 시에 도착해서 몇 시에 떠날 지에 대한 정보들이다.
     * 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구해서 그 인원을 수용할 수 있는 장소를 빌리려고 한다.
     * 만약 13, 15라면 13시에는 존재하고 15시 정각에는 존재하지 않는다고 가정한다.
     *
     * 1. 5 <= N <= 100,000
     * 2. 첫날 0시를 0, 마지막날 밤 자정을 72로 하는 타임라인. 음이 아닌 정수로 표현.
     *
     * 생각 못했던 점
     * -> 시작 시간, 끝나는 시간만 생각했었는데, '상태'값으로 시간에 대한 상태를 구분할 수 있다는 점
     * --> ExpectedTime class의 속성이 달라짐
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<ExpectedTime> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new ExpectedTime(start, 's'));
            list.add(new ExpectedTime(end, 'e'));
        }

        WeddingReception wr = new WeddingReception();
        System.out.println(wr.solution(list, n));
    }

    public int solution(List<ExpectedTime> list, int n) {
        int result = Integer.MIN_VALUE;
        int cnt = 0;
        Collections.sort(list);

        for (ExpectedTime e : list) {
            if (e.state == 's') cnt++;
            else cnt--;
            result = Math.max(result, cnt);
        }

        return result;
    }

//    public int solution(List<ExpectedTime> list, int n) {
//        int result = 1;
//        int endTime = -1;
//
//        int prevStart = -1;
//        int prevEnd = -1;
//        if(!list.isEmpty()) {
//            prevStart = list.get(0).startTime;
//            prevEnd = list.get(0).endTime;
//        }
//
//        for(ExpectedTime e : list) {
//            if (e.startTime > endTime) {
//                if(prevStart < endTime && prevEnd > endTime) {
//                    endTime = prevEnd;
//                }
//                else {
//                    endTime = e.endTime;
//                }
//            }
//            else if (e.startTime < endTime) {
//                result++;
//                prevStart = e.startTime;
//                prevEnd = e.endTime;
//            }
//
//        }
//        return result;
//    }

}

class ExpectedTime implements Comparable<ExpectedTime> {
    int startTime;
//    int endTime;
    char state;

    public ExpectedTime(int startTime, char state) {
        this.startTime = startTime;
        this.state = state;
    }

    @Override
    public int compareTo(ExpectedTime e) {
        if (this.startTime == e.startTime) return this.state - e.state;
        return this.startTime - e.startTime;
    }

    //    public ExpectedTime(int startTime, int endTime) {
//        this.startTime = startTime;
//        this.endTime = endTime;
//    }

//    @Override
//    public int compareTo(ExpectedTime e) {
//        if (this.startTime == e.startTime) return e.endTime - this.endTime;
//        return this.startTime - e.startTime;
//    }
}
