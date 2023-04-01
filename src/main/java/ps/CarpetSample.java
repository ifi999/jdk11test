package ps;

// https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class CarpetSample {

    /**
     * 카펫의 색상 갈색, 노란색이 있는데, 갈색 격자의 수, 노란색 격자의 수만 기억하고 있다.
     * 카펫의 가로, 세로 크기를 순서대로 배열에 담아 반환하기
     * 갈색의 수는 8 이상 5,000 이하
     * 노란색의 수는 1 이상 2,000,000 이하
     * 가로의 길이는 세로의 길이 이상
     *
     * 예시) brown yellow return
     *      10    2      [4, 3]
     *      8     1      [3, 3]
     *      24    24     [8, 6]
     *
     * 풀이
     * 가로의 길이 : width, 세로의 길이 : height
     * 갈색의 개수 : width *2 + (height -2) *2
     *            = (width + height -2) *2
     * 노란색 개수 : 넓이 - 갈색 개수
     *            = width * height - (width + height -2) *2
     * 노란색은 최소 1개 이상 있어야하므로, height는 최소 3이고 최대 가로의 길이다.
     * 그러므로 width도 3 이상이다.
     */

    public static void main(String[] args) {
        CarpetSample cs = new CarpetSample();
//        int[] result = cs.solution(10, 2);
        int[] result = cs.solution(24, 24);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int brown, int yellow) {

        for (int width = 3; width <= 5000; width++) {
            for (int height = 3; height <= width; height++) {
                int boundary = (width + height -2) *2;
                int center = width *height -boundary;
                if (boundary == brown && center == yellow) return new int[]{width, height};
            }
        }

        return null;
    }

}
