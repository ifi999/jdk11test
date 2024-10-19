package ps;

// 복리
public class Money {

    public static void main(String[] args) {
        int res1 = solution(10000000, 9, 13000000);
        System.out.println(res1);
    }

    public static int solution(int p, int m, int d) {
        double k = Math.pow((double) d /(double) p, (double) 1 /m);
        return (int) Math.round((k -1) *100);
    }
}
