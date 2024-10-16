package ps.prev;

// https://school.programmers.co.kr/learn/courses/30/lessons/81302
public class DistancingSample {

    /**
     * 대기실은 5개이며, 각 대기실의 크기는 5*5이다.
     * 거리두기를 위하여 응시자들끼리는 맨해튼 거리가 2 이하가 될 수 없다.
     * 단, 응시자가 앉아 있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용.
     * -> 맨해튼 거리 : (r1, c1), (r2, c2) 에 위치하고 있는 것들이 있다면,
     *                이 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2|
     *
     * 응시자들의 정보와 대기실 구조를 대기실별로 담은 2차원 문자열 배열을 전해준다.
     * 각 대기실별로 거리두기를 지키고 있으면 1, 한 명이라도 지키지 않고 있으면 0을 배열에 담아 반환하기
     */

    // 상 좌 우 하
    // 반대 방향 인덱스끼리 더하면 3이 되도록 만든 것
    private static final int dx[] = {0, -1, 1, 0};
    private static final int dy[] = {-1, 0, 0, 1};

    public static void main(String[] args) {
        DistancingSample ds = new DistancingSample();
        String[][] example = {
                                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
                             };
        int[] result = ds.solution(example);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(String[][] places) {
        int[] result = new int[places.length];

        // 각 대기실을 char[][] 형식으로 만들기
        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];

            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }

            // 거리두기 검증
            if (isDistanced(room)) {
                result[i] = 1;
            }
            else {
                result[i] = 0;
            }
        }

        return result;
    }

    private boolean isDistanced(char[][] room) {
        for (int y = 0; y < room.length; y++){
            for (int x = 0; x < room[y].length; x++) {
                // 응시자가 아니라면 건너뜀
                if (room[y][x] != 'P') continue;
                if (!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }

    private boolean isDistanced(char[][] room, int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 2차원 배열 검증할 때는 y축을 먼저 검사하는 것이 안전
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            if (room[ny][nx] == 'P') return true;

            // room[nx][ny]를 통해 다른 응시자에게 도달하는지 검사
            // 파티션일 경우 처리 필요 없음. 응시자일 경우 지켜지지 않음. 빈 테이블일 경우 다시 인접한 곳 체크
            switch (room[ny][nx]) {
                case 'P': return false;
                case 'O' :
                    // 인접한 곳 검사
                    if (isNextToVolunteer(room, nx, ny, 3-d)) return false;
                    break;
            }
        }

        return true;
    }

    // 상좌우하 방향을 지정한 이유가 여기서 제외할 방향을 지정해주기 위해서
    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude) continue;

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            if (room[ny][nx] == 'P') return true;
        }

        return false;
    }

}
