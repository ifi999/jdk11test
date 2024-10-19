package ps.prev;

public class KeyPad {

    public static void main(String[] args) {
        String s1 = "44335550555666";
        String result1 = solution(s1);
        System.out.println(result1);

        String s2 = "9666775553";
        String result2 = solution(s2);
        System.out.println(result2);

        String s3 = "2220281";
        String result3 = solution(s3);
        System.out.println(result3);
    }

    public static String solution(String s) {

        String[] arr = {
                ".QZ", "ABC", "DEF", "GHI", "JKL", "MNO", "PRS", "TUV", "WXY", "*", "0", "#"
        };

        StringBuilder sb = new StringBuilder();
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            int num = chars[i] - '0';
            if (num == 0) continue;
            if (i +1 < len && chars[i] == chars[i +1]) {
                if (i +2 < len && chars[i] == chars[i +2]) {
                    sb.append(arr[num -1].charAt(2));
                    i += 2;
                }
                else {
                    sb.append(arr[num -1].charAt(1));
                    i += 1;
                }
            }
            else {
                sb.append(arr[num -1].charAt(0));
            }
        }

        return sb.toString();
    }

}
