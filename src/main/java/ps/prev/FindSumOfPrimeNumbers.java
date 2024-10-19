package ps.prev;

import java.util.*;

// n까지 소수의 합 구하기
public class FindSumOfPrimeNumbers {

    public static void main(String[] args) {

        System.out.println(solution(5));

    }

    public static int solution(int n) {

        // 에라토스테네스의 체 사용

        int sum = 0;

        boolean[] isPrime = new boolean[n +1];

        Arrays.fill(isPrime, true);



        isPrime[0] = false;

        isPrime[1 ] = false;



        for (int i = 2; i *i <= n; i++) {

            if (isPrime[i]) {

                for (int j = i *i; j <= n; j += i) {

                    isPrime[j] = false;

                }

            }

        }



        for (int i = 2; i <= n; i++) {

            if (isPrime[i]) sum +=i;

        }

        return sum;

    }

}
