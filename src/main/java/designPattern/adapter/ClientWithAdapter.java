package designPattern.adapter;

public class ClientWithAdapter {

    /**
     * 클라이언트가 변환기를 통해 동일한 메서드명으로 두 객체의 메서드를 호출한다.
     * 변환기들을 인터페이스로 구현해서 더 개선할 수 있다.
     *
     * 호출 당하는 쪽의 메서드를 호출하는 쪽의 코드에 대응하도록 중간에 변환기를 통해 호출하는 패턴
     */
    public static void main(String[] args) {
        AdapterServiceA a = new AdapterServiceA();
        AdapterServiceB b = new AdapterServiceB();

        a.runService();
        b.runService();
    }
}
