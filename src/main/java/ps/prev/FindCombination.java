package ps.prev;

import java.util.Scanner;

// https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=73404
public class FindCombination {

    /**
     * 1부터 N까지 번호가 적힌 구슬이 있다.
     * 이 중 M개를 뽑는 방법의 수를 출력하시오.
     *
     * 1. 3 <= N <= 10
     * 2. 2 <= M <= N
     */

//    static int[] arr, tmp, ch;
    static int[] combi;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        combi = new int[m];
//        arr = new int[n];
//        ch = new int[n];
//        tmp = new int[m];
//        for (int i = 0; i < n; i++) {
//            arr[i] = i+1;
//        }

        FindCombination fc = new FindCombination();
        fc.solution(0, 1);
    }

    // '1 2'와 '2 1'은 같은데 제거 못했었음.
//    public void solution(int depth) {
//        if (depth == m) {
//            for (int i : tmp) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
//        else {
//            for (int i = 0; i < n; i++) {
//                if (ch[i] == 0) {
//                    ch[i] = 1;
//                    tmp[depth] = arr[i];
//                    solution(depth +1);
//                    ch[i] = 0;
//                }
//            }
//        }
//    }

    // ***조합은 아래 식을 외워두면 편함
    public void solution(int depth, int target) {
        if (depth == m) {
            for (int i : combi) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        else {
            for (int i = target; i <= n; i++) {
                combi[depth] = i;
                solution(depth +1, i+1);
            }
        }
    }

}
