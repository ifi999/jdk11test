package ps.prev;

// https://school.programmers.co.kr/learn/courses/30/lessons/12917
public class StringDescendingSample {

    /**
     * 문자열 s에 나타나는 문자를 큰 것부터 작은 순으로 정렬해 새로운 문자열을 반환
     * s는 영문 대소문자로만 구성. 대문자는 소문자보다 작은 것으로 간주함.
     *
     * str은 1이상.
     */

    public static void main(String[] args) {
        StringDescendingSample sds = new StringDescendingSample();
        String result = sds.solution("Zbcdefg");
        System.out.println("result = " + result);
    }

    public String solution(String s) {
        return s.chars()
                .boxed()
                .sorted((v1, v2) -> v2 - v1)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

}
