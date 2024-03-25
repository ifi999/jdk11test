package psBook.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class solution07 {

    /**
     * p.128
     * U : 왼쪽 / D : 아래 / R : 오른쪽 / L : 왼쪽 -> 각 위치로 한 칸 이동
     * 좌표평면의 (0, 0) 위치에서 시작, (-5, 5), (-5, -5), (5, 5), (5, -5) 로 경계 구성
     * 지나간 길 중에서 처음 걸어본 길의 길이를 구하시오
     *
     * 1) dirs는 string형으로 주어지며, 'U', 'D', 'R', 'L' 이외의 문자는 주어지지 않음
     * 2) dirs의 길이는 500 이하의 자연수
     */

    public static void main(String[] args) {
        String dirs1 = "ULURRDLLU";
        int solution1 = solution(dirs1);
        System.out.println("solution1 = " + solution1);

        String dirs2 = "LULLLLLLU";
        int solution2 = solution(dirs2);
        System.out.println("solution2 = " + solution2);
    }

    private static final Map<Character, int[]> location = new HashMap<>();

    public static int solution(String dirs) {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('R', new int[]{1, 0});
        location.put('L', new int[]{-1, 0});

        Set<String> result = new HashSet<>();

        int x = 5;
        int y = 5;

        for (int i = 0; i < dirs.length(); i++) {
            int[] tmp = location.get(dirs.charAt(i));
            int nx = x + tmp[0];
            int ny = y + tmp[1];

            if (!validateMoving(nx, ny)) {
                continue;
            }

            result.add(x + " " + y + " " + nx + " " + ny);
            result.add(nx + " " + ny + " " + x + " " + y);

            x = nx;
            y = ny;
        }

        return result.size() /2;
    }

    private static boolean validateMoving(int nx, int ny) {
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }

}
