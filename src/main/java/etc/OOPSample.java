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