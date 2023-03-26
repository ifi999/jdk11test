package designPattern.templateMethod;

public class Driver {

    public static void main(String[] args) {
        Animal a = new Dog();
        Animal b = new Cat();

        a.playWithOwner();

        System.out.println();

        b.playWithOwner();
    }

}
