package designPattern.strategy;

public class StrategyBow implements Strategy {
    @Override
    public void runStrategy() {
        System.out.println("pull");
    }
}
