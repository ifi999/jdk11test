package designPattern.proxy;

public class ClientWithNoProxy {

    /**
     * 프록시는 대리자, 대변인이라는 뜻. 누군가를 대신해서 그 역할을 수행하는 존재.
     */
    public static void main(String[] args) {
        Service service = new Service();

        System.out.println(service.runSomething());
    }
}
