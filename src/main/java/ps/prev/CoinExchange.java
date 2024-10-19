package ps.prev;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/08-05
public class CoinExchange {

    /**
     * 여러 단위의 동전이 주어진다.
     * 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
     * 각 단위의 동전은 무한정 쓸 수 있다.
     *
     * 가장 적은 수의 동전 -> 큰 수부터 하면 좋겠음
     */

    static int min = Integer.MAX_VALUE;
    static int n;
    static int m;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Integer[] coinArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            coinArr[i] = sc.nextInt();
        }
        // 큰 수부터 하기 위함
        Arrays.sort(coinArr, Collections.reverseOrder());
        m = sc.nextInt();

        CoinExchange ce = new CoinExchange();
        ce.solution(0, 0, coinArr);
        System.out.println(min);
    }

    // 4,5번 케이스에서 시간 초과 --> 1,2,5가 아니라 5,2,1. 큰 것부터 적용할 필요 있었음
//    public void solution(int depth, int sum) {
//        // 합계가 금액보다 크면 안됨
//        if (sum > m) return;
//        if (cnt != 0 && cnt < depth) return;
//        // 합계가 금액이랑 같을 때만 갱신 -> 근데 이 경우에 배열은 어떻게 저장하지?
//        if (sum == m) {
//            if(min > sum) {
//                min = sum;
//                cnt = depth;
//            }
//        }
//        else {
//            if (depth != n) {
//                for (int i = 0; i < n; i++) {
//                    solution(depth +1, sum +coinArr[i]);
////                    solution(depth +1, sum);
//                }
//            }
//        }
//    }

    public void solution(int depth, int sum, Integer[] coinArr) {
        if (depth > min) return;
        if (sum > m) return;
        if (sum == m) {
            min = Math.min(min, depth);
        }
        else {
            for (int i = 0; i < n; i++) {
                solution(depth +1, sum +coinArr[i], coinArr);
            }
        }
    }

}
