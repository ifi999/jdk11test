package designPattern.proxy;

public class Proxy implements IService {
    IService service1;
    @Override
    public String runSomething() {
        System.out.println("호출에 대한 흐름 제어가 주목적.\n반환 결과를 그대로 전달");

        service1 = new Service();

        // Decorator Pattern의 경우 Proxy Pattern과 다르게 반환값에 조작을 가한다.
        // return "decorated " + service1.runSomething();

        return service1.runSomething();
    }
}
