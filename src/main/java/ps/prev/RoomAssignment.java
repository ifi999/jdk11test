package ps.prev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/09-02
public class RoomAssignment {

    /**
     * 끝나는 시간이 빠를수록 많이 붙을 수 있을 것이라고 생각해서
     * Room class에서 정렬은 짧을수록 먼저 오도록하였다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new Room(start, end));
        }

        Collections.sort(list);

        int endTime = 0;
        int result = 0;
        for (Room room : list) {
            if (room.start >= endTime) {
                result++;
                endTime = room.end;
            }
        }

        System.out.println(result);
    }

}

class Room implements Comparable<Room> {
    public int start, end;

    public Room(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Room r) {
        if (this.end == r.end) {
            return this.start - r.start;
        }
        return this.end - r.end;
    }
}
