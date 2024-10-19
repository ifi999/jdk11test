package ps.prev;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchPhoneNumberSample {

    /**
     * 전화번호 형식?
     * -> 010-0000-0000, 010 0000 0000, 01000000000 형식들이 있다.
     * --> phoneNumber.replaceAll("[^0-9]", ""); 정규표현식 사용하기.
     *
     * 전화번호부 저장되어 있는 사람은 어덯게 나타낸 것?
     *
     * 사람과 전화번호는 어떻게 비교?
     *
     * 전화번호는 어떤 현식으로 나타낼 것?
     */
    public static void main(String[] args) {
        System.out.println(new PhoneNumber("010-1234-5678"));
        System.out.println(new PhoneNumber("010 1234 5678"));
        System.out.println(new PhoneNumber("01012345678"));
        System.out.println("=================");

        Person person = new Person("하이");
        person.addPhoneNumber(new PhoneNumber("010-1234-5678"));
        person.addPhoneNumber(new PhoneNumber("010 1234 5678"));
        person.addPhoneNumber(new PhoneNumber("01012345678"));
        System.out.println(person);
        System.out.println(person.hasPhoneNumber(new PhoneNumber("01012345678")));
        System.out.println("=================");

        Person person2 = new Person("하이2");
        person2.addPhoneNumber(new PhoneNumber("010-1111-2222"));

        Person person3 = new Person("하이3");
        person3.addPhoneNumber(new PhoneNumber("010-3333-4444"));

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPerson(person);
        phoneBook.addPerson(person2);
        phoneBook.addPerson(person3);

        System.out.println(phoneBook);
        System.out.println(phoneBook.search(new PhoneNumber("01012121212")));
        System.out.println(phoneBook.search(new PhoneNumber("01012345678")));
        System.out.println(phoneBook.search(new PhoneNumber("01033334444")));
        System.out.println(phoneBook.search(new PhoneNumber("01022221111")));
    }

    private static class PhoneNumber {
        public final String phoneNumber;

        public PhoneNumber(String rawPhoneNumber) {
            this.phoneNumber = rawPhoneNumber.replaceAll("[^0-9]", "");
        }

        @Override
        public String toString() {
            return "PhoneNumber{" +
                    "phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof PhoneNumber)) return false;
            return phoneNumber.equals(((PhoneNumber) obj).phoneNumber);
        }
    }

    private static class Person {
        public final String name;
        private final List<PhoneNumber> numbers;

        public Person(String name) {
            this.name = name;
            numbers = new ArrayList<>();
        }

        public void addPhoneNumber(PhoneNumber number) {
            numbers.add(number);
        }

        public boolean hasPhoneNumber(PhoneNumber number) {
            return numbers.contains(number);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", numbers=" + numbers +
                    '}';
        }
    }

    private static class PhoneBook {
        private final Set<Person> people;

        public PhoneBook() {
            people = new HashSet<>();
        }

        public void addPerson(Person person) {
            people.add(person);
        }

        public Person search(PhoneNumber number) {
            return people.stream()
                    .filter(o -> o.hasPhoneNumber(number))
                    .findFirst()
                    .orElse(null);
        }

        @Override
        public String toString() {
            return "PhoneBook{" +
                    "people=" + people +
                    '}';
        }
    }
}
