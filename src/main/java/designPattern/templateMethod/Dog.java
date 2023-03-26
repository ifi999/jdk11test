package designPattern.templateMethod;

public class Dog extends Animal {

//    public void playWithOwner() {
//        System.out.println("---START---");
//        System.out.println("DOG");
//        System.out.println("---END---");
//    }

    @Override
    void runSomething() {
        System.out.println("play with dog");
    }

    @Override
    void play() {
        System.out.println("DOG");
    }

}
