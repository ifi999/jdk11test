package ps.prev;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/60057
public class StringCompressionSample {

    /**
     * 문자열에서 반복되는 것을 압축하고, 가장 짧은 것의 길이를 반환
     *
     * 1.1부터 입력 문자열 s의 길이만큼 자를 문자열의 길이를 설정하며 반복
     * 2.설정된 길이만큼 문자열을 잘라 낸 token의 배열 생성
     * 3.문자열을 비교하며 token의 배열을 하나의 문자열로 압축
     * 4.1~3과정으로 압축된 무자열 중 가장 짧은 길이 반환
     */

    public static void main(String[] args) {
        StringCompressionSample scs = new StringCompressionSample();
//        int result = scs.solution("aabbaccc");
//        int result = scs.solution("ababcdcdababcdcd");
        int result = scs.solution("abcabcdede");
        System.out.println("result = " + result);
    }

    public int solution(String s) {
        int min = Integer.MAX_VALUE;

        for (int length = 1; length <= s.length(); length++) {
            // 문자열 압축 후 가장 짧은 길이 선택
            int compressed = compress(s, length);
            if (compressed < min) {
                min = compressed;
            }
        }

        return min;
    }

    private int compress(String source, int length) {
        // 압축한 문자열의 길이 반환
        StringBuilder sb = new StringBuilder();

        String last = "";
        int count = 0;
        for (String token : split(source, length)) {
            // 압축 문자열 구성
            if (token.equals(last)) {
                count++;
            }
            else {
                // 새로운 토큰 등장 처리
                if (count > 1) sb.append(count);
                sb.append(last);
                last = token;
                count = 1;
            }
        }
        if (count > 1) sb.append(count);
        sb.append(last);

        return sb.length();
    }

    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        // source를 length만큼씩 잘라 tokens에 추가

        for (int startIdx = 0; startIdx < source.length(); startIdx += length) {
            // 문자열을 startidx부터 잘라서 tokens에 추가
            int endIdx = startIdx + length;
            if (endIdx > source.length()) endIdx = source.length();
            tokens.add(source.substring(startIdx, endIdx));
        }

        return tokens;
    }
}
