package ps;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12915
public class SortStringAtWill {

    /**
     * 문자열로 구성된 리스트 Strings, 정수 n
     * 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬
     * 예를 들어 Strings가 {"sun", "bed", "car"}, n이 1이라면
     * 각 인덱스 1의 문자 "u", "e", "a"로 Strings를 정렬한다.
     *
     * Strings의 길이는 1이상 50이하
     * Strings의 원소는 소문자 알파벳으로 이루어짐, 길이는 1이상 100이하
     * Strings의 모든 원소의 길이는 n보다 큼
     * 인덱스 1의 문자가 같은 문자열이 여럿일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치
     */

    public static void main(String[] args) {
        SortStringAtWill ss = new SortStringAtWill();
        String[] arr = {"sun", "bed", "car"};
        int n = 1;
        String[] result = ss.solution(arr, n);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) != s2.charAt(n)) {
                return s1.charAt(n) - s2.charAt(n);
            }

            return s1.compareTo(s2);
        });

        return strings;
    }
}
