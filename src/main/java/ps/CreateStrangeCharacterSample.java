package ps;

public class CreateStrangeCharacterSample {

    /**
     * 문자열 s는 단어 + 공백 + 단어 + 공백 + 단어 ... 같이 구성되어 있다.
     * 각 단어의 짝수 번째 알파벳은 대문자, 홀수 번째 알파벳은 소문자로 바꿔서 반환하기 (인덱스 번호 기준)
     */

    public static void main(String[] args) {
        CreateStrangeCharacterSample cscs = new CreateStrangeCharacterSample();
        String result = cscs.solution("try hello world");
        System.out.println("result = " + result);
    }

    public String solution(String s) {

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        // idx로 풀었는데, 다른 풀이는 boolean으로 해결함. 기억해두기
        // boolean toUpper = true;

        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                // 공백일 경우
                idx = 0;
//                toUpper = true;
                sb.append(c);
            }
            else {
                // 공백이 아닐 경우
                if (idx % 2 == 0) {
                    sb.append(Character.toUpperCase(c));
                }
                else {
                    sb.append(Character.toLowerCase(c));
                }
                idx++;
//                toUpper = !toUpper;
            }
        }

        return sb.toString();
    }
}
