package ps.prev;

// https://school.programmers.co.kr/learn/courses/30/lessons/81301
public class NumericStringAndEnglishWord {

    /**
     * 숫자를 건네받을 때 일부 자릿수를 영단어로 바꾼 것으로 받는다.
     * 예를 들어, 1478 -> "one4seveneight"
     * 이렇게 일부가 바뀌었거나, 바뀌지 않고 그대로인 문자열 s가 주어진다.
     * s가 의미하는 원래 숫자를 반환
     */

    public static void main(String[] args) {
        NumericStringAndEnglishWord ns = new NumericStringAndEnglishWord();
//        int result = ns.solution("one4seveneight");
        int result = ns.solution("1zerotwozero3");
        System.out.println("result = " + result);
    }

    // 내가 푼 것
//    public int solution(String s) {
//        // 대응하는 영단어 표를 맵에 기록
//        Map<String, String> map = new HashMap<>();
//        map.put("zero", "0");
//        map.put("one", "1");
//        map.put("two", "2");
//        map.put("three", "3");
//        map.put("four", "4");
//        map.put("five", "5");
//        map.put("six", "6");
//        map.put("seven", "7");
//        map.put("eight", "8");
//        map.put("nine", "9");
//
//        // map을 돌면서 s에 있는지 확인 -> 있다면 변경
//        for (String str : map.keySet()) {
//            if (s.contains(str)) s = s.replace(str, map.get(str));
//        }
//
//        return Integer.parseInt(s);
//    }


    /**
     * 풀이
     *  - 최적의 방식보다는 비효율적이나, 시간 복잡도를 따져본다.
     *    원본 문자열의 길이를 N, 변환해야 하는 영단어의 종류를 M이라고 가정.
     *    replace() 메서드를 한 번 실행하는데 O(N) 소요.
     *    이를 M번 반복하므로 O(NM).
     *    문제에서 N의 최댓값은 50, M의 최댓값은 10이므로 넉넉한 시간 복잡도임을 알 수 있다.
     */
    // 영단어 배열 선언
    private static final String[] words = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
    };

    public int solution(String s) {
        // 각 영단어를 매칭되는 인덱스 값으로 변환
        for (int i = 0; i < words.length; i++) {
            s = s.replace(words[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }

}
