package ps.prev;

import java.util.Scanner;
import java.util.Stack;

// https://www.youtube.com/watch?v=vf-i7Q_fN6w&list=PLFgS-xIWwNVU_qgeg7wz_aMCk22YppiC6&index=8
public class CreateAscendingSequence {

    /**
     *  수열의 개수 n (1 <= n <= 100,000)과 수열을 이루는 1이상 n 이하의 정수가 주어진다.
     *  이때 같은 정수가 두 번 이상 나오지는 않는다.
     *
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        int count = 1;
        boolean flag = true;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();

            if (tmp >= count) {
                while (tmp >= count) {
                    sb.append("+").append("\n");
                    st.push(count++);
                }
                sb.append("-").append("\n");
                st.pop();
            }
            else {
                Integer pop = st.pop();
                if (pop > tmp) {
                    System.out.println("NO");
                    flag = false;
                    break;
                }
                else {
                    sb.append("-").append("\n");
                }
            }
        }

        if (flag) System.out.println(sb.toString());
    }

}
