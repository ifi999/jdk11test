package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class CollectionSample {
    // Collection.java
    //    See Also:
    //    Set, List, Map, SortedSet, SortedMap, HashSet, TreeSet, ArrayList, LinkedList, Vector, Collections, Arrays, AbstractCollection

    public static void main(String[] args) {
        List<String> list = setList();
        List<String> emptyList = new ArrayList<>();
        List<String> nullList = null;

        int size1 = list.size();
        System.out.println("size1 = " + size1);

        int size2 = emptyList.size();
        System.out.println("size2 = " + size2);

        // NPE
//        int size3 = nullList.size();
//        System.out.println("size3 = " + size3);

        System.out.println("====================");

        boolean empty1 = list.isEmpty();
        System.out.println("empty1 = " + empty1);

        boolean empty2 = emptyList.isEmpty();
        System.out.println("empty2 = " + empty2);

        // NPE
//        boolean empty3 = nullList.isEmpty();
//        System.out.println("empty3 = " + empty3);

        System.out.println("====================");

        boolean contains1 = list.contains("AAA");
        System.out.println("contains1 = " + contains1);

        boolean contains2 = list.contains("A");
        System.out.println("contains2 = " + contains2);

        boolean contains3 = list.contains(null);
        System.out.println("contains3 = " + contains3);

        boolean contains4 = emptyList.contains(null);
        System.out.println("contains4 = " + contains4);

        // NPE
//        boolean contains5 = nullList.contains(null);
//        System.out.println("contains5 = " + contains5);

        System.out.println("====================");

        Iterator<String> iter1 = list.iterator();
        while (iter1.hasNext()) {
            String val1 = iter1.next();
            System.out.println("val1 = " + val1);
        }

        Iterator<String> iter2 = emptyList.iterator();
        while (iter2.hasNext()) {
            String val2 = iter2.next();
            System.out.println("val2 = " + val2);
        }

        // NPE
//        Iterator<String> iter3 = nullList.iterator();
//        while (iter3.hasNext()) {
//            String val3 = iter3.next();
//            System.out.println("val3 = " + val3);
//        }

        // ConcurrentModificationException
//        Iterator<String> iter4 = list.iterator();
//        while (iter4.hasNext()) {
//            String val4 = iter4.next();
//            System.out.println("val4 = " + val4);
//            list.add("EEE");
//        }

        // NoSuchElementException
//        Iterator<String> iter5 = list.iterator();
//        while (true) {
//            String val5 = iter5.next();
//            System.out.println("val5 = " + val5);
//        }

        System.out.println("====================");

        Object[] objArr1 = list.toArray();
        String str1 = (String) objArr1[0];
        System.out.println("str1 = " + str1);

        Object[] objArr2 = emptyList.toArray();
        // ArrayIndexOutOfBoundsException
//        Object obj1 = objArr2[0];

        // NPE
//        Object[] objArr3 = nullList.toArray();

        System.out.println("====================");

        list.add("EEE");

        // NPE
//        nullList.add("HI");

        System.out.println("====================");

        list.remove("EEE");

        // IndexOutOfBoundsException 같은 것이 발생하지 않는데, List 인터페이스에서 정의된 동작이라고 한다.
        emptyList.remove("BYE");

        // NPE
//        nullList.remove("WHY");

        System.out.println("====================");

        boolean containsAll1 = list.containsAll(List.of("AAA", "BBB"));
        System.out.println("containsAll1 = " + containsAll1);

        boolean containsAll2 = list.containsAll(List.of("AAA", "EEE"));
        System.out.println("containsAll2 = " + containsAll2);

        // NPE
//        boolean containsAll3 = emptyList.containsAll(null);
//        System.out.println("containsAll3 = " + containsAll3);

        // NPE + Compile warning
//        boolean containsAll4 = emptyList.containsAll(List.of(null));
//        System.out.println("containsAll4 = " + containsAll4);

        // NPE
//        boolean containsAll5 = nullList.containsAll(null);
//        System.out.println("containsAll5 = " + containsAll5);

        // NPE + Compile warning
//        boolean containsAll6 = nullList.containsAll(List.of(null));
//        System.out.println("containsAll6 = " + containsAll6);

        System.out.println("====================");

        boolean addAll1 = list.addAll(List.of("EEE", "FFF"));
        System.out.println("addAll1 = " + addAll1);

        // NPE + Compile warning
//        boolean addAll2 = list.addAll(List.of(null));
//        System.out.println("addAll2 = " + addAll2);

        // NPE
//        boolean addAll3 = list.addAll(null);
//        System.out.println("addAll3 = " + addAll3);

        // NPE
//        boolean addAll4 = nullList.addAll(List.of("HI", "BYE"));
//        System.out.println("addAll4 = " + addAll4);

        System.out.println("====================");

        boolean removeAll1 = list.removeAll(List.of("EEE", "FFF"));
        System.out.println("removeAll1 = " + removeAll1);

        // NPE
//        boolean removeAll2 = list.removeAll(null);
//        System.out.println("removeAll2 = " + removeAll2);

        boolean removeAll3 = emptyList.removeAll(List.of("EEE", "FFF"));
        System.out.println("removeAll3 = " + removeAll3);

        // NPE
//        boolean removeAll4 = emptyList.removeAll(null);
//        System.out.println("removeAll4 = " + removeAll4);

        // NPE
//        boolean removeAll5 = nullList.removeAll(List.of("EEE", "FFF"));
//        System.out.println("removeAll5 = " + removeAll5);

        // NPE
//        boolean removeAll6 = nullList.removeAll(null);
//        System.out.println("removeAll6 = " + removeAll6);

        System.out.println("====================");

        List<Integer> numberList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Predicate<Integer> predicate1 = n -> n % 2 == 0;
        Predicate<Integer> predicate2 = null;
        Predicate<Integer> predicate3 = n -> n == 999;

        boolean removeIf1 = numberList.removeIf(predicate1);
        System.out.println("removeIf1 = " + removeIf1);

        // NPE
//        boolean removeIf2 = numberList.removeIf(predicate2);
//        System.out.println("removeIf2 = " + removeIf2);

        boolean removeIf3 = numberList.removeIf(predicate3);
        System.out.println("removeIf3 = " + removeIf3);

        boolean removeIf4 = numberList.removeIf(n -> n % 2 == 0);
        System.out.println("removeIf4 = " + removeIf4);

        System.out.println("====================");

        /**
         * equals()와 hashCode()는 Object class의 것과 같다.
         *
         */

    }

    private static List<String> setList() {
        List<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        list.add("DDD");

        return list;
    }
}
