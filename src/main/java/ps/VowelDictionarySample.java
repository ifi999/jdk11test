package ps;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/84512
public class VowelDictionarySample {

    /**
     * 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U' 만을 사용하여 만들 수 있는,
     * 길이 5 이하의 모든 단어가 수록되어 있다.
     * 사전에서 첫 번째 단어는 'A'이고, 그 다음은 'AA'이며, 마지막 단어는 'UUUUU'이다.
     * 단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 반환
     *
     * word의 길이는 1이상 5이하.
     * word는 대문자 'A', 'E', 'I', 'O', 'U' 로만 이루어져 있음.
     *
     * 풀이
     * 만들 수 있는 단어의 개수 5 + 5^2 + 5^3 + 5^4 + 5^5 (각 길이별 단어의 개수) = 3,905개 x 단어 5종류 = 19,525개
     * 고작 2만개도 안되므로, 모든 단어를 만들어서 위치를 찾아서 반환하는 것도 충분히 가능하다. (1초는 1억개 기준)
     *
     * 상태
     *  - word
     * 종료 조건
     *  - word의 길이가 5
     * 점화식
     *  - word = [word] + (word + 'A') + (word + 'E') + (word + 'I') + (word + 'O') + (word + 'U')
     */

    private static final char[] CHARS = "AEIOU".toCharArray();

    public static void main(String[] args) {
        VowelDictionarySample vds = new VowelDictionarySample();
        // 풀이 1
//        int result = vds.generate("").indexOf("AAAAE");
        int result = vds.generate("").indexOf("I");
        System.out.println("result 1 = " + result);

        // 풀이 2
        List<String> words = new ArrayList<>();
        vds.generate("", words);
        System.out.println("result 2 = " + words.indexOf("I"));
    }

    // 풀이 1
    // 처음부터 빈 문자열 ""으로 시작하면 모든 단어 조합을 만들 수 있다.
    public List<String> generate(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);

        if (word.length() == 5) return words;

        for (char c : CHARS) {
            words.addAll(generate(word +c));
        }
        return words;
    }

    // 풀이 2
    public void generate(String word, List<String> words) {
        words.add(word);

        if (word.length() == 5) return;
        for (char c : CHARS) {
            generate(word +c, words);
        }
    }

}
