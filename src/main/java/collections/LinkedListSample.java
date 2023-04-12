package collections;

import java.util.LinkedList;
import java.util.List;

public class LinkedListSample {

    public static void main(String[] args) {

        /**
         * 양방향 Node로 구성되어있다. item, prev, next
         * ArrayList는 배열로 구성되어있지만, LinkedList의 경우에는 위 Node의 연결로 구성되어있다.
         */

        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");

    }

}
