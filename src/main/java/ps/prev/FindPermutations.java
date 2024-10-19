package ps.prev;

// 순열구하기2
public class FindPermutations {

    public static void main(String[] args) {

        // nPr = n! / (n-r)!

        int n  = 5;

        int r = 3;

        System.out.println(solution(n, r));

    }

    private static long solution(int n, int r) {

        return factorial(n) /factorial(n -r);

    }

    private static long factorial(int n) {

        long res = 1;

        for (int i = 1; i <= n; i++) {

            res *= i;

        }

        return res;

    }

}
