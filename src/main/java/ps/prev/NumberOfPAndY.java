package ps.prev;

// https://school.programmers.co.kr/learn/courses/30/lessons/12916
public class NumberOfPAndY {

    /**
     * 대문자와 소문자가 섞인 문자열 s
     * s에 'p'의 개수와 'y'의 개수가 같으면 true, 다르면 false 반환
     * 단, 대소문자 구별 안함
     */

    public static void main(String[] args) {
        NumberOfPAndY no = new NumberOfPAndY();
//        boolean result = no.solution("pPoooyY");
        boolean result = no.solution("Pyy");
        System.out.println("result = " + result);
    }

    public boolean solution(String s) {
        // 소문자로 통일
        s = s.toLowerCase();
        int length = s.length();

        // p 길이
        int countP = length - s.replace("p", "").length();
        // y 길이
        int countY = length - s.replace("y", "").length();

        if (countP == countY) return true;
        return false;
    }

}
