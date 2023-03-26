package designPattern.factoryMethod;

// 팩터리 메서드가 생성할 객체
public class CatToy extends AnimalToy {
    @Override
    void identify() {
        System.out.println("cat toy");
    }
}
