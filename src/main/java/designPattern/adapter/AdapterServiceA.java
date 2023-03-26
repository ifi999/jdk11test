package designPattern.adapter;

public class AdapterServiceA {
    ServiceA serviceA = new ServiceA();

    void runService() {
        serviceA.runServiceA();
    }
}
