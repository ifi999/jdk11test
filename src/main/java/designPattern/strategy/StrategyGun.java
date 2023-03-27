package designPattern.strategy;

public class StrategyGun implements Strategy {
    @Override
    public void runStrategy() {
        System.out.println("shoot");
    }
}
