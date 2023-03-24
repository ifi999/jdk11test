package ps;

// https://school.programmers.co.kr/learn/courses/30/lessons/12932
public class ReverseNumberSample {

    /**
     * 1.정수 -> 문자열 변환
     * 2.문자열 뒤집기
     * 3.문자열 -> 배열
     * 4.배열 -> 정수 변환
     */
    public static void main(String[] args) {
        ReverseNumberSample rns = new ReverseNumberSample();
        int[] result = rns.solution(12345l);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(long n) {
        // 정수 -> 문자열 변환
        String strNum = String.valueOf(n); // 내부 보면 Long.toString(n) 사용

        // 문자열 뒤집기
        String reverseStrNum = new StringBuilder(strNum).reverse().toString();

        // 문자열 -> 배열
        char[] chars = reverseStrNum.toCharArray();

        // 배열 -> 정수 변환
        int[] result = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            result[i] = chars[i] - '0';  // - '0' 을 안해주면 아스키코드 기준 값이 출력된다. '0'을 빼서 해당 정수만 출력되도록 하기
        }

        return result;
    }
}
