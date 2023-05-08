package ps;

import java.util.Scanner;

// https://www.youtube.com/watch?v=31Z1tH5frYY&list=PLFgS-xIWwNVU_qgeg7wz_aMCk22YppiC6&index=3
public class FindAverage {

    /**
     * 과목의 개수 N개. (0 <= N <= 1000)
     * 점수 중 최댓값을 M이라 할 때 모든 점수를 점수/M *100으로 변경한다.
     * 이 방법으로 새로운 평균을 구하시오.
     *
     *
     *
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            if (score > max) max = score;
            sum += score;
        }

        FindAverage fa = new FindAverage();
        System.out.println(fa.solution(n, sum, max));
    }

    public double solution(int n, int sum, int max) {
        // 2. 막상 이렇게 바꾸고나니 여기서도 굳이 해야하나? 배열이 필요한가? 생각이 들었음. 외부로 꺼냄. solution method도 필요없을듯
//        int max = Integer.MIN_VALUE;
//        int sum = 0;
//        for (int i : arr) {
//            if (i > max) max = i;
//            sum += i;
//        }


        // 1. 처음에는 아래처럼 작성했었는데, 다시 반복문을 만들어서 i를 더하는 것보다 위에서 더하고 한번에 하는 것이 나았음
//        int sum = 0;
//        for (int i : arr) {
//            sum += ((double) i / (double) max) * 100;
//        }


        // 3. double 형변환 명시를 안해도 .0을 붙히면 알아서 변환된다
//        double result = ((double) sum / (double) max) * 100;
//        return result / n;

        return (sum * 100.0 / max)/n;
    }

}
