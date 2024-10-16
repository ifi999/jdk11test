package ps.prev;

// https://school.programmers.co.kr/learn/courses/30/lessons/12926
public class CaesarCipherSample {

    /**
     * 문자열 s와 거리 n이 있다.
     * s가 'AB'이고, n이 1일 때,
     * 시저 암호를 적용하면 'BC'가 된다.
     * s는 알파벳 소문자, 대문자, 공백으로 구성.
     * 공백은 아무리 밀어도 공백.
     * s <= 8000, 1 <= n <= 25
     *
     * 1. char 범위가 소문자, 대문자일 경우를 나누어야 함
     * 2. z, Z를 넘어간다면 a, A부터 시작하도록 해야 함
     */
    public static void main(String[] args) {
        CaesarCipherSample ccs = new CaesarCipherSample();
        String result = ccs.solution("zB Z", 1);
        System.out.println("result = " + result);
    }

    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        // A-Z : 65-90, a-z : 97-122
        char[] chars = s.toCharArray();
        for (char c : chars) {
            sb.append(push(c, n));
        }

        return sb.toString();
    }

    private char push(char c, int n) {
        // 알파벳이 아닐 경우 바로 반환. (공백)
        if (!Character.isAlphabetic(c)) return c;

        // z, Z를 넘어가는 것을 처리하기 위해 offset을 저장
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        // 0 ~ 25 로 만들고 n만큼 밀기
        int position = c - offset;
        position = (position +n) % 26;

        // offset을 이용하여 0~25를 영문으로 변경
        return (char) (offset +position);
    }
}
