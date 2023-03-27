package ps;

// https://school.programmers.co.kr/learn/courses/30/lessons/72410
public class RecommendNewAccount {

    /**
     * 아이디 규칙에 맞지 않는 아이디를 입력했을 때,
     * 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천하기.
     *
     * 조건 : 길이는 3자 이상 15자 이하
     *       알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용 가능
     *       단, 마침표(.)는 처음과 끝에 사용할 수 없으며, 연속으로 사용할 수 없음
     *
     * 위의 조건으로 검사하고 맞지 않은 경우 아래의 규칙으로 새로운 아이디를 추천한다
     * ex) new_id
     *
     * 조건 : 1. 모든 대문자를 소문자로 치환
     *       2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제거
     *       3. 마침표(.)가 2번 이상 연속이라면 하나의 마침표(.)로 치환
     *       4. 마침표(.)가 처음이나 끝에 위치하면 제거
     *       5. 빈 문자열이라면, a를 대입
     *       6. 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
     *          만약 제거 후 마침표(.)가 끝에 위치한다면 제거
     *       7. 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙힘
     */

    public static void main(String[] args) {
        RecommendNewAccount rna = new RecommendNewAccount();
//        String result = rna.solution("...!@BaT#*..y.abcdefghijklm");
//        String result = rna.solution("z-+.^.");
//        String result = rna.solution("=.=");
//        String result = rna.solution("123_.def");
        String result = rna.solution("abcdefghijklmn.p");
        System.out.println("result = " + result);
    }

    public String solution(String newId) {
        // 1단계
        newId = newId.toLowerCase();

        // 2단계
        // 정규표현식 찾아서 기억해두기
        // '\\-'인 이유 : 특수 문자 앞에는 '\' 인데, \를 표현하기 위해 2번 사용해서 '\\-'
        newId = newId.replaceAll("[^a-z0-9\\-_.]", "");

        // 3단계
        // 1회 이상 등장하는 패턴은 '+'로 표현 가능
        newId = newId.replaceAll("\\.+", ".");

        // 4단계
        // 끝이라는 조건은 '$'로 표현 가능
        newId = newId.replaceAll("^\\.+|\\.+$", "");

        // 5단계
        if (newId.isEmpty()) newId = "a";

        // 6단계
        if (newId.length() >= 16) {
            newId = newId.substring(0, 15);
            newId = newId.replaceAll("\\.+$", "");
        }

        // 7단계
        while (newId.length() < 3) {
            newId += newId.charAt(newId.length() -1);
        }

        return newId;
    }

}
