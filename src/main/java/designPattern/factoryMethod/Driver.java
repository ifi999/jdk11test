package designPattern.factoryMethod;

public class Driver {

    public static void main(String[] args) {
        // 팩터리 메서드를 보유한 객체들 생성
        Animal a = new Dog();
        Animal b = new Cat();

        // 팩터리 메서드가 반환하는 객체들
        AnimalToy at = a.getToy();
        AnimalToy bt = b.getToy();

        // 팩터리 메서드가 반환한 객체들을 사용
        at.identify();
        bt.identify();
    }

}
