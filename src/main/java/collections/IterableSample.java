package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class IterableSample {
    // Iterable.java

    public static void main(String[] args) {
        List<String> list = setList();

        System.out.println("=========0========");

        // forEach
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String value = iter.next();
            System.out.println("value = " + value);
        }

        System.out.println("=========1========");

        // spliterator
        Spliterator<String> spliterator1 = list.spliterator();
        while (spliterator1.tryAdvance(System.out::println));

        System.out.println("=========2========");

        Spliterator<String> spliterator2 = list.spliterator();
        spliterator2.forEachRemaining(System.out::println);

        System.out.println("=========3========");

        Spliterator<String> spliterator3 = list.spliterator();
        Spliterator<String> spliterator4 = spliterator3.trySplit();

        spliterator3.forEachRemaining(System.out::println);

        System.out.println("=========4========");

        spliterator4.forEachRemaining(System.out::println);
    }

    private static List<String> setList() {
        List<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        list.add("DDD");
        list.add("EEE");
        list.add("FFF");
        list.add("GGG");

        return list;
    }
}
