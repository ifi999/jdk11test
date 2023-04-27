package ps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=73399
public class FindDuplicatePermutation {

    /**
     * 1~N까지 번호가 적힌 구슬이 있다.
     * 중복을 허락하여 M번 뽑아 일렬로 나열하시오.
     * 출력 순서는 사전순으로 오름차순으로 출력
     *
     * ex) N = 5, M = 3
     * 1,2,3,4,5
     * 1,2,3,4,5
     * 1,2,3,4,5
     * -> [1,1,1], [1,1,2], [1,1,3] ...
     * 그런데 [2,1,1]을 정렬하면 [1,1,2]가 된다. 이 경우를 제외해야 할듯?
     *
     * 어떻게 제외할 수 있을까?
     * Set에 담아서? -> x
     * 그냥 배열에 -> o
     */

    // 구슬 최대 번호
    static int n;
    // M번
    static int m;
    static int[] pm;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        FindDuplicatePermutation fdp = new FindDuplicatePermutation();
        fdp.DFS(0);
    }

    public void DFS(int depth) {
        if(m == depth) {
            for(int i : pm) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        else {
            for (int i = 1; i <= n; i++) {
                pm[depth] = i;
                DFS(depth +1);
            }
        }
    }

}
