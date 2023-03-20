package etc;

import java.util.ArrayList;
import java.util.List;

public class SystemGCSample {

    static List<String> list = new ArrayList<>(100000);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000000; i++) {
            Test test = new Test("A", "B");
        }
        System.out.println(System.nanoTime());
        System.gc();
        System.out.println(System.nanoTime());
        System.gc();
        System.out.println(System.nanoTime());
        System.gc();
        System.out.println(System.nanoTime());
        System.out.println("??");
        System.out.println(System.nanoTime());
//        Thread.sleep(1000);
//        System.gc();
    }

}

class Test {
    String first;
    String second;

    public Test(String first, String second) {
        this.first = first;
        this.second = second;
    }
}
