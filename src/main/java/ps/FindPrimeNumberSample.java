package ps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/42839
public class FindPrimeNumberSample {

    /**
     * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 반환
     *
     * numbers의 길이는 1 이상 7 이하인 문자열
     * numbers는 0~9까지 숫자만으로 이루어짐
     * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미
     *
     * 풀이
     * 숫자들을 조합해 나가면 만들 수 있는 모든 소수를 구해야 한다.
     * 주어진 숫자들을 사용해서 가능한 모든 숫자를 만든 후에는 생성된 숫자 중 소수를 가려내야 한다.
     * 이를 위해 재귀를 활용하여 만들 수 있는 모든 숫자를 만든다.
     *
     * 상태 : 주어진 숫자들을 사용하여 숫자를 조합
     *  - 지금까지 만들어 놓은 숫자 acc
     *  - 사용할 수 있는 종이 조각들 numbers
     *
     * 종료 조건 : numbers가 비어있을 때
     *  - (acc, 0) = {acc} -> acc가 소수인 경우
     *               {}    -> acc가 소수가 아닌 경우
     *
     * 점화식 : acc의 소수 검사와 전이된 상태의 결과를 모두 합친 형태
     *  - (acc, numbers) = {acc} -> acc가 소수인 경우       (acc *10 +n, numbers -n)
     *                     {}    -> acc가 소수가 아닌 경우
     */

    public static void main(String[] args) {
        FindPrimeNumberSample fp = new FindPrimeNumberSample();
//        int result = fp.solution("17");
        int result = fp.solution("011");
        System.out.println("result = " + result);
    }

    private void getPrimes(int acc, List<Integer> numbers, Set<Integer> primes) {
        // 종료 조건
        if (isPrime(acc)) primes.add(acc);

        // 점화식
        for (int i = 0; i < numbers.size(); i++) {
            int nextAcc = acc *10 + numbers.get(i);
            List<Integer> nextNumbers = new ArrayList<>(numbers);
            nextNumbers.remove(i);
            getPrimes(nextAcc, nextNumbers, primes);
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n % 2 == 0) return n == 2;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public int solution(String nums) {
        Set<Integer> primes = new HashSet<>();
        List<Integer> numbers = nums.chars()
                .map(c -> c - '0')
                .boxed()
                .collect(Collectors.toList());
        getPrimes(0, numbers, primes);
        return primes.size();
    }

}
