package designPattern.strategy;

public class Client {
    public static void main(String[] args) {
        Strategy strategy = null;
        Soldier soldier = new Soldier();

        // 총
        strategy = new StrategySword();
        soldier.runContext(strategy);

        System.out.println();

        // 검
        strategy = new StrategySword();
        soldier.runContext(strategy);

        System.out.println();

        // 활
        strategy = new StrategyBow();
        soldier.runContext(strategy);
    }
}
