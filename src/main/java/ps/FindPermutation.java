package ps;

import java.util.Scanner;

// https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=73401
public class FindPermutation {

    /**
     * 10 이하의 N개의 자연수가 주어진다.
     * 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력하시오.
     *
     * 1. 3 <= N <= 10
     * 2. 2 <= M <= N
     * 
     * *** 중복 순열이 아님
     */

    static int n,m;
    static int[] numbers, arr, ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        arr = new int[m];
        ch = new int[n];

        FindPermutation fp = new FindPermutation();
        fp.solution(0);
    }

    // 3 3, 6 6, 9 9 같은 중복 경우 어떻게 제거할 지 모르겠음 -> int[] ch을 만들어서 체크를 함
    public void solution(int depth) {
        if (depth == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    arr[depth] = numbers[i];
                    solution(depth +1);
                    ch[i] = 0;
                }
            }
        }
    }

}
