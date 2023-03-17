package ps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfStartSample {

    public static void main(String[] args) {
        IntersectionOfStartSample ios = new IntersectionOfStartSample();
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
//        int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
        String[] solution = ios.solution(line);
        for (String s : solution) {
            System.out.println(s);
        }
    }
    public String[] solution(int[][] line) {
        Set<Point> points = new HashSet<>();
        setPointList(line, points);

        Point minPoint = getMinPoint(points);
        Point maxPoint = getMaxPoint(points);

        int width = (int) (maxPoint.x - minPoint.x + 1);
        int height = (int) (maxPoint.y - minPoint.y + 1);

        char[][] arr = new char[height][width];
        fillDotArray(arr);
        GeneralToTwoDimension(points, minPoint, maxPoint, arr);

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }

        return result;
    }

    private static void GeneralToTwoDimension(Set<Point> points, Point minPoint, Point maxPoint, char[][] arr) {
        for (Point p : points) {
            // 일반 좌표 -> 2차원 배열 좌표 변환
            int x = (int) (p.x - minPoint.x);
            int y = (int) (maxPoint.y - p.y);
            arr[y][x] = '*';
        }
    }

    private static void fillDotArray(char[][] arr) {
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }
    }

    private void setPointList(int[][] line, Set<Point> list) {
        for (int i = 0; i < line.length; i++) {
            for (int j = i+1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2],
                                                  line[j][0], line[j][1], line[j][2]);

                if (intersection != null) {
                    list.add(intersection);
                }
            }
        }
    }

    private Point getMinPoint(Set<Point> points) {
        // 가장 작은 좌표
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point point : points) {
            if (point.x < x) x = point.x;
            if (point.y < y) y = point.y;
        }

        return new Point(x, y);
    }

    private Point getMaxPoint(Set<Point> points) {
        // 가장 큰 좌표
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point point : points) {
            if (point.x > x) x = point.x;
            if (point.y > y) y = point.y;
        }

        return new Point(x, y);
    }

    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        // 교점 값 반환
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long) x, (long) y);
    }

    public static class Point {
        private final long x,y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
