package designPattern.templateMethod;

public class Cat extends Animal{

//    public void playWithOwner() {
//        System.out.println("---START---");
//        System.out.println("CAT");
//        System.out.println("---END---");
//    }

    @Override
    void runSomething() {
        System.out.println("play with cat");
    }

    @Override
    void play() {
        System.out.println("CAT");
    }

}
