package designPattern.singleton;

public class Client {

    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();

        // 단일 객체를 참조하는 것을 확인 가능
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }

}
