package designPattern.strategy;

public class Client {
    public static void main(String[] args) {
//        Strategy strategy = null;
        Soldier soldier = new Soldier();

        // 총
//        strategy = new StrategySword();
//        soldier.runContext(strategy);

        // Template Callback Pattern
        // 중복된 내용이 많음 -> Soldier class에서 메서드 생성
//        soldier.runContext(new Strategy() {
//            @Override
//            public void runStrategy() {
//                System.out.println("shoot");
//            }
//        });
        soldier.runContext("shoot");

        System.out.println();

        // 검
//        strategy = new StrategySword();
//        soldier.runContext(strategy);

//        soldier.runContext(() -> System.out.println("swing"));
        soldier.runContext("swing");

        System.out.println();

        // 활
//        strategy = new StrategyBow();
//        soldier.runContext(strategy);

//        soldier.runContext(() -> System.out.println("pull"));
        soldier.runContext("pull");
    }
}
