package designPattern.strategy;

public class Soldier {
    void runContext(String weapon) {
        System.out.println("전투 시작");
        executeWeapon(weapon).runStrategy();
        System.out.println("전투 종료");
    }

    private Strategy executeWeapon(final String weapon) {
        return new Strategy() {
            @Override
            public void runStrategy() {
                System.out.println(weapon);
            }
        };
    }
}
