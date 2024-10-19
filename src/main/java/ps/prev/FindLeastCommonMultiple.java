package ps.prev;

// 최소 공배수의 합
public class FindLeastCommonMultiple {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        System.out.println(solution(arr));

    }

    private static int solution(int[] arr) {

        int sum = 0;



        int len = arr.length;

        for (int i = 0; i < len; i++) {

            for (int j = i +1; j < len; j++) {

                sum += lcm(arr[i], arr[j]);

            }

        }



        return sum;

    }



    // 최소공배수

    private static int lcm(int n, int m) {

        return (n *m) /gcd(n, m);

    }



    // 최대공약수

    private static int gcd(int n, int m) {

        while (m != 0) {

            int tmp = n %m;

            n = m;

            m = tmp;

        }



        return n;

    }



}
