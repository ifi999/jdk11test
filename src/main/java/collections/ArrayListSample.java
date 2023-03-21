package collections;

import java.util.*;

public class ArrayListSample {

    public static void main(String[] args) {

        /**
         * default capacity = 10
         * 속성 size는 private
         * 배열로 이루어진다
         * MAX_ARRAY_SIZE 값이 존재. Integer.MAX_VALUE - 8
         *
         * modCount : 배열이 수정된 횟수를 나타낸다.
         *            add(), remove() 등과 같은 메서드에서 사용됨
         */
        List<String> arrayList = new ArrayList<>();
        arrayList.add("test1");
        arrayList.add("test2");
        arrayList.add("test3");

        // 다른 Collection 객체를 인자로 받아서 생성 가능하다 1
        List<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        List<String> linked2array = new ArrayList<>(linkedList);
        for (String s : linked2array) {
            System.out.println("linked2array = " + s);
        }

        // 다른 Collection 객체를 인자로 받아서 생성 가능하다 2
        Set<String> hashSet = new HashSet<>();
        hashSet.add("D");
        hashSet.add("E");
        hashSet.add("F");
        List<String> set2array = new ArrayList<>(hashSet);
        for (String s : set2array) {
            System.out.println("set2array = " + s);
        }
        System.out.println("=================");

        /**
         * trimToSize()
         *
         * capacity를 현재 내부 배열의 요소 수에 맞게 축소하는 역할이라고 함.
         * 메모리를 더 효율적으로 사용할 수 있게 해주나봄.
         * 기본 capacity가 10인데, 내부 배열에 담긴 개수가 10 미만인 7이라면, 7로 capacity를 바꾼다는 뜻인듯.
         * 내부 호출은 Arrays.copyof() 메서드로 새로 만들어버리는 듯함.
         */

        /**
         * ensureCapacity(int minCapacity)
         *
         * trimToSize() 메서드와 다르게 capacity의 크기를 늘리는 역할로 보임.
         */

        /**
         * grow(int minCapacity)
         *
         * Arrays.copyOf() 메서드를 사용하여 capacity 크기를 늘려줌.
         *
         * ensureCapacity() 메서드에서 사용 중
         */

        /**
         * newCapacity(int minCapacity)
         *
         * 기존 capacity(oldCapacity)와 새로운 capacity(newCapacity)를 정의하고 시작함.
         * newCapacity는 oldCapacity의 1.5배(oldCapacity + (oldCapacity >> 1))
         * newCapacity의 값이 MAX_ARRAY_SIZE 값보다 크다면, 반환 시 newCapacity 값이 아닌 minCapacity를 추가 조작한 값을 반환
         * 만약 newCapacity가 인자로 받은 minCapacity보다 작다면, default capacity인 10으로 설정
         * 인자로 받은 minCapacity의 크기가 0보다 작다면 OOM 발생
         *
         * grow() 메서드에서 사용 중
         */

        /**
         * hugeCapacity(int minCapacity)
         *
         * minCapacity가 0보다 작다면 OOM 발생
         * MAX_ARRAY_SIZE 보다 크다면, Integer.MAX_VALUE으로 조정해서 리턴
         * 아니라면 MAX_ARRAY_SIZE로 리턴
         *
         * newCapacity() 메서드에서 사용중
         */

        /**
         * size()
         * size의 getter 역할 메서드
         *
         * isEmpty()
         * size가 0인지 체크
         *
         * contains(Object o)
         * 'o'라는 것이 존재하는지 여부 체크
         *
         * indexOf(Object o)
         * 'o'라는 것이 몇 번째에 위치하는지
         */
        System.out.println("size : " + arrayList.size());
        System.out.println("isEmpty : " + arrayList.isEmpty());
        System.out.println("contains - true : " + arrayList.contains("test1"));
        System.out.println("contains - false : " + arrayList.contains("test4"));
        System.out.println("indexOf 1 : " + arrayList.indexOf("test2"));
        System.out.println("indexOf -1 : " + arrayList.indexOf("test4"));
        System.out.println("=================");

        /**
         * indexOfRange(Object o, int start, int end)
         *
         * start부터 end까지의 인덱스를 돌면서 o가 몇 번째에 위치하는지
         * null도 체크해줌. 만약 o에 해당하는 것이 없다면 -1
         */

        /**
         *  lastIndexOf(Object o)
         *
         *  lastIndexOfRange() 메서드를 사용하여 역순으로 몇 번째에 위치하는지 찾아줌
         *  범위는 0부터 size 전체
         */
        System.out.println("lastIndexOf 1 : " + arrayList.lastIndexOf("test2"));
        System.out.println("=================");

        /**
         * lastIndexOfRange(Object o, int start, int end)
         *
         * indexOfRange() 메서드와 비슷하지만 역순으로 찾는다는 점이 다름
         *
         * lastIndexOf() 메서드에서 사용 중
         */

        /**
         * clone()
         *
         * 얕은 복사(주소 값이 동일)를 행해줌
         * Arrays.copyOf() 메서드를 사용하며, 복사 객체의 modCount를 초기화해주는 듯
         */

        /**
         * toArray()
         * Arrays.copyOf()를 바로 반환
         * 반환 타입은 Object[]
         *
         * toArray(T[] a)
         * 인자로 받은 타입으로 반환해줄 수도 있음
         */

        /**
         * elementData(int index)
         * index 위치에 맞는 값 반환
         *
         * get(int index)
         * elementData() 메서드를 반환
         * index 값이 0 보다 작거나 size 이상이라면, IndexOutBoundsException 처리
         *
         * set(int index, E element)
         * index 위치에 요소를 배정.
         * get과 마찬가지로 index 값에 문제가 있다면 동일한 예외 처리
         */
        System.out.println("get - test2 : " + arrayList.get(1));
        System.out.println("set - test4 : " + arrayList.set(1, "test4"));
        System.out.println("get - test4 : " + arrayList.get(1));
        System.out.println("=================");

        /**
         * 1.void add(E e, Object[] elementData, int s)
         * 2.boolean add(E e)
         * 3.void add(int index, E element)
         *
         * add()는 3가지 오버로딩 메서드가 있다.
         * 3번이 내가 주로 쓰던 add() 메서드인데, 가장 먼저 인덱스의 범위 체크를 한다.
         * 그리고 modCount 값을 늘리고 사이즈가 최대치라면 grow() 메서드로 capacity를 늘린다.
         * 마지막으로 System.arraycopy()를 사용하여 복사 후, size 속성 값을 늘려준다.
         *
         * 1,2의 경우에는 2가 public 이고 1이 private이다. 2의 내부에 1이 호출된다.
         * 2의 내용은 modCount를 늘리고, 1을 동작시켜 사이즈가 최대라면 capacity를 늘리고 size 속성 값을 늘려주는 것이다.
         */
        arrayList.add(3, "test5");
        System.out.println("index 3 value : " + arrayList.get(3));
        boolean addTest6 = arrayList.add("test6");
        System.out.println("addTest6 : " + addTest6);
        System.out.println("index 4 value : " + arrayList.get(4));
        System.out.println("=================");

        /**
         * E remove(int index)
         * 인자 index 범위 체크 후, 배열에서 index 값에 해당하는 값을 추출한다.
         * 그리고 fastRemove() 메서드를 호출하여 값을 제거한다.
         *
         * boolean remove(Object o)
         * 레이블을 사용하는 소스 코드가 존재한다. break found; 구문이 실행되면 return을 하지 않고 fastRemove() 메서드가 호출된다.
         * break found;의 조건으로는 null 이거나 일치하는 해당 값이 존재하면 된다.
         *
         * void fastRemove(Object[] es, int i)
         * modCount가 증가하는 메서드 중 하나.
         * System.arraycopy() 메서드를 사용하여 사이즈를 줄이는 듯. 삭제한 인덱스는 null로 바꿔서 지우는 것 같다.
         */
        boolean removeTest7 = arrayList.remove("test7"); // 없는 것 -> false
        boolean removeTest6 = arrayList.remove("test6"); // 존재하는 것 -> true
        System.out.println("removeTest7 : " + removeTest7);
        System.out.println("removeTest6 : " + removeTest6);
        String removeIndex3 = arrayList.remove(3);
        System.out.println("removeIndex3 : " + removeIndex3);

        /**
         * boolean equals(Object o)
         * 내부 로직 중에 expectedModCount 값이 존재한다.
         * 이 값이 modCount와 비교하는 checkForComodification() 메서드가 있다.
         * 두 개의 내부 값들이 동일할 수 있을지라도, 추가했다가 제거했다가 추가하거나 하면 modCount가 서로 다를 수 있기에 서로 다른 객체라고 보는 것이다.
         * 같지 않을 경우에는 ConcurrentModificationException()을 발생시킨다.
         *
         * 반환 값으로는 인자가 ArrayList class이고 동일하다면 equalsArrayList()의 반환값을, 아니라면 equalsRange()의 반환값을 보낸다.
         */

        /**
         * boolean equalsArrayList(ArrayList<?> other)
         * 사이즈, 길이, 요소등을 모두 검증하며 마지막으로 modCount 값 비교를 하며 모두 같다면 true를 반환한다.
         *
         * boolean equalsRange(List<?> other, int from, int to)
         * from부터 to까지 인덱스의 값을 비교한다. 요소가 서로 다르면 false를 반환한다.
         * 범위 내 모든 요소가 서로 같다면 true를 반환한다.
         */

        /**
         * int hashCode()
         * equals() 메서드와 마찬가지로 modCount 검증을 한다.
         * 그리고 hashCodeRange() 메서드를 사용하여 hash 값을 구하여 반환한다.
         *
         * int hashCodeRange(int from, int to)
         * from부터 to까지 돌며 hashCode 값을 구한다.
         * int hashCode = 1;
         * for (int i = from; i < to; i++) {
         *      Object e = es[i];
         *      hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
         * }
         * 기존 해시 코드 값에서 31을 곱하고, 인덱스 값에 해당하는 해시코드를 더하는 연산을 반복하여 구한다.
         */

        /**
         * void clear()
         * modCount 증가.
         * 모든 인덱스의 값을 null로 초기화시켜서 비워버린다.
         */

        /**
         * boolean addAll(Collection<? extends E> c)
         * modCount 증가.
         * 인자의 컬렉션 타입을 toArray() 메서드를 사용하여 Object[]로 만든다.
         * 이 배열의 사이즈에 맞게 늘어난 만큼 grow() 메서드로 capacity를 늘리고,
         * System.arrayCopy() 메서드를 통하여 복사하며, size 또한 그에 맞게 늘려준다.
         *
         * boolean addAll(int index, Collection<? extends E> c)
         * 위와 거의 유사한데, index 값이 추가되어있다.
         * 특정 위치를 지정하여 추가할 수 있으며, System.arraycopy() 메서드 2번 사용하여 그 뒷부분은 밀려나도록 구현되어있다.
         */

        /**
         * void removeRange(int fromIndex, int toIndex)
         * modCount 증가.
         * 구간 범위를 정하여 삭제하는 기능. 인덱스 값 검증 로직 존재.
         * shiftTailOverGap() 메서드를 호출하여 값을 null로 만들어 제거한다.
         *
         * void shiftTailOverGap(Object[] es, int lo, int hi)
         * System.arraycopy()를 사용하여 사이즈룰 줄이며, 값을 null로 만들어 제거한다.
         */

        /**
         * boolean removeAll(Collection<?> c)
         * 인자로 받은 컬렉션을 batchRemove() 메서드를 사용하여 제거
         * c에 속한 것들을 지움(공통된 것)
         *
         * boolean retainAll(Collection<?> c)
         * 인자로 받은 컬렉션을 batchRemove() 메서드를 사용하여 제거
         * c에 속한 것들만 남김(공통된 것)
         *
         * boolean batchRemove(Collection<?> c, boolean complement,
         *                         final int from, final int end)
         * complement가 true라면 c에 포함되지 않은 요소를 모두 제거,
         * false라면 c에 포함된 요소를 모두 제거
         */

        /**
         * void writeObject(java.io.ObjectOutputStream s)
         * stream 관련해서 데이터 삽입
         *
         * void readObject(java.io.ObjectInputStream s)
         * stream 관련해서 데이터 제거
         */

        /**
         * void forEach(Consumer<? super E> action)
         * boolean removeIf(Predicate<? super E> filter)
         * void replaceAll(UnaryOperator<E> operator)
         * void sort(Comparator<? super E> c)
         * 람다식 전용
         */

        /**
         * Spliterator<E> spliterator()
         * arrayList를 반토막
         */
    }

}
