package ps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// https://cote.inflearn.com/contest/10/problem/10-04
public class BuildTheTallestTower {

    /**
     *
     */

    static int[] dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Brick> arr = new ArrayList<>();
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Brick(a, b, c));
        }

        BuildTheTallestTower bt = new BuildTheTallestTower();
        System.out.println(bt.solution(arr));
    }

    public int solution(List<Brick> arr) {
        int result = 0;
        Collections.sort(arr);
        dy[0] = arr.get(0).h;
        result = dy[0];

        for (int i = 1; i < arr.size(); i++) {
            int max_h = 0;
            for (int j = i-1; j >= 0; j--) {
                if (arr.get(j).w > arr.get(i).w && dy[j] > max_h) {
                    max_h = dy[j];
                }
            }
            dy[i] = max_h + arr.get(i).h;
            result = Math.max(result, dy[i]);
        }

        return result;
    }

}

class Brick implements Comparable<Brick> {
    int s;
    int h;
    int w;

    public Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick o) {
        return o.s - this.s;
    }
}