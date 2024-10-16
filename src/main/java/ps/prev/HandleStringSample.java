package ps.prev;

// https://school.programmers.co.kr/learn/courses/30/lessons/12918
public class HandleStringSample {

    /**
     * 문자열 s의 길이가 4 또는 6이고, 숫자로만 구성되어있는지 확인하시오
     * ex) "a234" -> false
     *     "1234" -> true
     */

    public static void main(String[] args) {
        HandleStringSample hs = new HandleStringSample();
//        boolean result = hs.solution("a234");
        boolean result = hs.solution("1234");
        System.out.println("result = " + result);
    }

    // 내 풀이
//    public boolean solution(String s) {
//        if (s.length() != 4 && s.length() != 6) return false;
//
//        for (char c : s.toCharArray()) {
//            // 내용이 거의 같기는 했는데 아래 조건문이 달랐음.
//            // 나는 문자열이면 false로 하였는데 아래가 더 정확할듯
////            if (!Character.isDigit(c)) return false;
//            if (Character.isAlphabetic(c)) return false;
//        }
//
//        return true;
//    }

    // 책 풀이
    public boolean solution(String s) {
        // 이처럼 정규식을 이용하면 위의 내 풀이도 틀린 것은 아닌데 간단하게 처리 가능하다.
        return s.matches("[0-9]{4}|[0-9]{6}");
    }

}
