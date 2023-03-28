package ps;

public class RecursiveSample {

    /**
     * 0 이상의 두 정수 n, m이 주어졌을 때 n^m 구하기
     *
     * 1.상태 정의하기
     *   - (n,m) 으로 정의
     * 2.종료 조건 정하기
     *   - (n,0) = 1, (0,m) = 1, (1,m) = 1
     *     -> 계산 필요 x
     * 3.점화식 세우기
     *   - n^m = n * n^(m01)
     *     -> (n,m) = n * (n,m-1)
     */

    public static void main(String[] args) {
        RecursiveSample rs = new RecursiveSample();
        int result = rs.solution(2, 5);
        System.out.println("result = " + result);
    }

    public int solution(int n, int m) {
        if (m == 0 || n == 0 || n == 1) return 1;

        return n * solution(n, m-1);
    }

}
