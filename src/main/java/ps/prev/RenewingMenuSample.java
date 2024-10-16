package ps.prev;

import java.util.*;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/72411
public class RenewingMenuSample {

    /**
     * 손님들의 주문 목록에 가장 많이 포함된 메뉴들의 조합을 메뉴 개수별로 구해야 한다.
     * 이를 위해 적용할 수 있는 것은 '완전 탐색'이다.
     * 재귀를 이용하여 모든 메뉴의 조합을 구한 후, 주문에서 등장한 횟수를 구하면 구할 수 있다.
     *
     * 종료 조건은 메뉴가 최대 10개일 경우와 조합된 메뉴가 2회 이상 등장하지 않았을 경우
     */

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        RenewingMenuSample rms = new RenewingMenuSample();
        String[] solution = rms.solution(orders, course);
        for (String s : solution) {
            System.out.print(s + " ");
        }
    }

    public String[] solution(String[] orders, int[] course) {
        List<Set<String>> orderList = Arrays.stream(orders)
                .map(String::chars)
                .map(charStream -> charStream
                        .mapToObj(menu -> String.valueOf((char) menu))
                        .collect(Collectors.toSet()))
                .collect(Collectors.toList());

        Map<Integer, List<Course>> courses = new HashMap<>();
        for (int length : course) {
            List<Course> list = new ArrayList<>();
            list.add(new Course("", 0));
            courses.put(length, list);
        }
        getCourses('A', new HashSet<>(), orderList, courses);

        return courses.values().stream()
                .filter(list -> list.get(0).occurrences > 0)
                .flatMap(List::stream)
                .map(c -> c.course)
                .sorted()
                .toArray(String[]::new);
    }

    /**
     * 코스 구성, 주문 목록에서 등장한 횟수
     */
    private static class Course {
        public final String course;
        public final int occurrences;

        public Course(String course, int occurrences) {
            this.course = course;
            this.occurrences = occurrences;
        }
    }

    private void getCourses(char nextMenu, Set<String> selectedMenus, List<Set<String>> orderList, Map<Integer, List<Course>> courses) {
        int occurrences = (int) orderList.stream()
                .filter(order -> order.containsAll(selectedMenus))
                .count();

        if (occurrences < 2) return;

        int size = selectedMenus.size();

        if (courses.containsKey(size)) {
            List<Course> coursesList = courses.get(size);

            Course course = new Course(selectedMenus.stream()
                        .sorted()
                        .collect(Collectors.joining("")), occurrences);

            Course origin = coursesList.get(0);

            if (origin.occurrences < occurrences) {
                coursesList.clear();
                coursesList.add(course);
            }
            else if (origin.occurrences == occurrences) {
                coursesList.add(course);
            }
        }

        if (size >= 10) return;
        for (char menuChar = nextMenu; menuChar <= 'Z'; menuChar++) {
            String menu = String.valueOf(menuChar);
            selectedMenus.add(menu);
            getCourses((char) (menuChar +1), selectedMenus, orderList, courses);
            selectedMenus.remove(menu);
        }
    }
}
