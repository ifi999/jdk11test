package ps.hash;

import java.util.Arrays;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 해시 - 전화번호 목록 (https://school.programmers.co.kr/learn/courses/30/lessons/42577)
 *
 * - 문제 설명
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 *
 *      구조대 : 119
 *      박준영 : 97 674 223
 *      지영석 : 11 9552 4421
 *
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * - phone_book의 길이는 1 이상 1,000,000 이하입니다.
 * - 각 전화번호의 길이는 1 이상 20 이하입니다.
 * - 같은 전화번호가 중복해서 들어있지 않습니다.
 *
 * 입출력 예제
 * - phone_book	                        return
 *  ["119", "97674223", "1195524421"]	false
 *  ["123","456","789"]	                true
 *  ["12","123","1235","567","88"]	    false
 *
 * 풀이
 * - 정렬(TimSort) : O(Nlog(N))
 * - 순회 : O(N)
 *
 * 틀린 점
 * - contains를 사용하였는데 다음 경우에 문제가 된다.
 *   > "23", "123"
 *   접두어이기에 startsWith로 대체
 */
public class Programmers42577 {

    public static void main(String[] args) {
        final String[] phoneBook1 = {"119", "97674223", "1195524421"};
        final String[] phoneBook2 = {"123","456","789"};
        final String[] phoneBook3 = {"12","123","1235","567","88"};
        final String[] phoneBook4 = {"123", "2345", "23467"};

        System.out.println(solution(phoneBook1));
        System.out.println(solution(phoneBook2));
        System.out.println(solution(phoneBook3));
        System.out.println(solution(phoneBook4));
    }

    public static boolean solution(final String[] phoneBook) {
        boolean answer = true;

        Arrays.sort(phoneBook);
        final int length = phoneBook.length;
        for (int i = 0; i < length -1; i++) {
            if (phoneBook[i +1].startsWith(phoneBook[i])) return false;
        }

        return answer;
    }
}
