package etc;

public class OOPSample {

    public static void main(String[] args) {
        Penguin p1 = new Penguin();
        p1.name = "P1";
        p1.habitat = "H1";

        p1.showName();
        p1.showName("P1.");
        p1.showHabitat();

        // Animal로 Promotion
        Animal p2 = new Penguin();
        p2.name = "P2";

        p2.showName();

//        Plant plant = new Plant();

        System.out.println("==================");
        동물 동물객체 = new 동물();
        동물 조류객체 = new 조류();
        동물 참새객체 = new 참새();

        System.out.println(동물객체 instanceof 동물);

        System.out.println(조류객체 instanceof 동물);
        System.out.println(조류객체 instanceof 조류);

        System.out.println(참새객체 instanceof 동물);
        System.out.println(참새객체 instanceof 조류);
        System.out.println(참새객체 instanceof 참새);
        System.out.println("==================");

        참새 참새test = new 참새();
        참새test.test();
        System.out.println("==================");

        참새test.method();
    }

}

class Animal {
    public String name;

    public void showName() {
        System.out.printf("hi %s. \n", name);
    }
}

class Penguin extends Animal {
    public String habitat;

    public void showHabitat() {
        System.out.printf("%s는 %s에 거주 \n", name, habitat);
    }

    @Override
    public void showName() {
        System.out.println("몰루");
    }

    public void showName(String name) {
        System.out.println("name : " + name);
    }
}

abstract class Plant {
    abstract void photosynthesize();
}

class 동물 {
    void method() {
        System.out.println("동물");
    }
}

class 조류 extends 동물 {
    void method() {
        super.method();
        System.out.println("조류");
    }
}

class 참새 extends 조류 {

    int a = 10;

    void test() {
       int a = 20;

       System.out.println(a);
       System.out.println(this.a);
    }

    void method() {
        super.method();
        System.out.println("참새");
    }
}