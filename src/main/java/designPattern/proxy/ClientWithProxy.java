package designPattern.proxy;

public class ClientWithProxy {

    /**
     * 프록시 패턴의 중요 포인트
     * - 대리자는 실제 서비스와 같은 이름의 메서드를 구현. 이때 인터페이스를 사용한다.
     * - 대리자는 실제 서비스에 대한 참조 변수를 갖는다.(합성)
     * - 대리자는 실제 서비스의 같은 이름을 가진 메서드를 호출하고, 그 값을 클라이언트에게 돌려준다.
     * - 대리자는 실제 서비스의 메서드 호출 전후에 별도의 로직을 수행할 수 있다.
     *
     * 프록시 패턴이 실제 서비스 메서드의 반환값에 가감하는 것을 목적으로 하지 않고, 제어의 흐름을 변경하거나 다른 로직을 수행하기 위해 사용한다.
     * 제어 흐름을 조정하기 위한 목적으로 중간에 대리자를 두는 패턴.
     */

    public static void main(String[] args) {
        // 프록시를 이용한 호출
        IService proxy = new Proxy();
        System.out.println(proxy.runSomething());
    }

}
