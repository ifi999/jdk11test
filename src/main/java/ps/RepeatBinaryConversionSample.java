package ps;

// https://school.programmers.co.kr/learn/courses/30/lessons/70129
public class RepeatBinaryConversionSample {

    /**
     * 0,1로 이루어진 문자열 x에서 모든 0을 제거한다.
     * x의 길이를 c라고 한다면, c를 2진법으로 표현한 문자열로 변환한다.
     * 위의 과정을 반복하여 최종적으로 1을 만든다.
     * 반복되는 과정 횟수와, 그 과정 중 제거된 0의 개수를 배열에 담아 반환
     *
     * 1. 문자열 x -> 0 제거하는 함수 만들기
     * 2. 0 제거한 문자열의 길이를을 2진법으로 표현하는 함수 만들기
     * 3. 1번 과정과 2번 과정을 하며 카운팅한 것을 반환하기
     */

    public static void main(String[] args) {
        RepeatBinaryConversionSample rb = new RepeatBinaryConversionSample();
//        int[] result = rb.solution("110010101001");
        int[] result = rb.solution("1111111");
        System.out.println("result[0] = " + result[0]);
        System.out.println("result[1] = " + result[1]);
    }

    public int[] solution(String x) {
        int loop = 0;
        int removed = 0;
        String tmp = x;

        while(!tmp.equals("1")) {
            // 0 제거
            int zeroCnt = getZeroCnt(tmp);
            removed += zeroCnt;
            // 굳이 replace를 사용하여 제거할 필요가 없었다. 전체 길이에서 0의 개수(길이)를 제외햐면 1의 길이이기 때문
//            int replaceLength = tmp.replace("0", "").length();
            int ones = tmp.length() - zeroCnt;

            // 0 제거 문자열 -> 2진법
            tmp = Integer.toString(ones, 2);
            loop++;
        }

        int[] result = {loop, removed};

        return result;
    }

    private static int getZeroCnt(String tmp) {
        int cnt = 0;
        char[] chars = tmp.toCharArray();
        for (char c : chars) {
            if (c == '0') cnt++;
        }
        return cnt;
    }

}
