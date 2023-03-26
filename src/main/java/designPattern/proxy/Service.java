package designPattern.proxy;

public class Service implements IService{

    @Override
    public String runSomething() {
        return "Something Service";
    }

}
