package etc;

import java.util.ArrayList;
import java.util.List;

public class CollectionLoopSample {
    public static void main(String[] args) {
        CollectionLoopSample cls = new CollectionLoopSample();
        cls.removeInLoop1();
    }

    public void removeInLoop1() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            nums.add(i);
        }

//        for (int i = 0; i < 10; i++) {
//            if (i % 2 == 0) nums.remove(i);
//        }

        for (Integer number : nums) {
            if (number % 2 == 0) nums.remove(number);
        }
    }
}
