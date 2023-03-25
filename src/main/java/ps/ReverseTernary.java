package ps;

//
public class ReverseTernary {

    /**
     * 자연수 n을 3진법으로 변환한 후, 뒤집은 것을 10진법으로 다시 변환하기.
     *
     * 1. 자연수 n -> 3진법
     * 2. 3진법 뒤집기
     * 4. 3진법 -> 10진법으로 변환하여 반환
     */

    public static void main(String[] args) {
        ReverseTernary rt = new ReverseTernary();
//        int result = rt.solution(45);
        int result = rt.solution(125);
        System.out.println("result = " + result);
    }

    public int solution(int n) {
        // 자연수 n -> 3진법
        String str = Integer.toString(n, 3);

        // 3진법 뒤집기
        String reverseStr = new StringBuilder(str).reverse().toString();

        // 3진법 -> 10진법
        // 아래 주석으로 하면 45 -> 1200 -> 0021 -> 21로 단순히 String이 정수 형태로 바뀌기만 해서 잘못된 것이다.
//        int result = Integer.parseInt(reverseStr, 10);
        int result = Integer.valueOf(reverseStr, 3);

        return result;
    }

}
