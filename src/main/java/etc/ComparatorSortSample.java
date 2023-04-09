package etc;

import java.util.Arrays;

public class ComparatorSortSample {

    /**
     * compare() : 양수 -> 왼쪽 객체가 더 큼 = 내림차순
     *             음수 -> 오른쪽 객체가 더 큼 = 오름차순
     *
     * ------------------------------
     *
     * sorted((v1, v2) -> ? - ?)
     * 오름차순 : v1 -v2
     * 내림차순 : v2 -v1
     */

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 4, 7, 0, 9};
        int[] result = Arrays.stream(arr)
                .boxed()
                .sorted((v1, v2) -> v2 - v1)
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i : result) {
            System.out.print(i + " ");
        }

        System.out.println();

        // 문자열 길이 순서 정렬
        String[] words = {"java", "algorithm", "programming", "hi", "hello", "coding"};
//        Arrays.sort(words, (v1, v2) -> v1.length() - v2.length());
        Arrays.sort(words, (v1, v2) -> v2.length() - v1.length());
        for (String word : words) {
            System.out.print(word + " ");
        }
    }

}
