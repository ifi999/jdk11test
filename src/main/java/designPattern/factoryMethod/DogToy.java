package designPattern.factoryMethod;

// 팩터리 메서드가 생성할 객체
public class DogToy extends AnimalToy {
    @Override
    void identify() {
        System.out.println("dog toy");
    }
}
