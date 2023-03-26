package designPattern.adapter;

public class ClientWithNoAdapter {

    /**
     * 각 메서드가 비슷한 일을 하지만 메서드명이 다른 것을 볼 수 있다.
     */
    public static void main(String[] args) {
        ServiceA a = new ServiceA();
        ServiceB b = new ServiceB();

        a.runServiceA();
        b.runServiceB();
    }
}
