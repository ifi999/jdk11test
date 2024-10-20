package etc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Singleton {

    private static final Logger logger = LoggerFactory.getLogger(Singleton.class);

    // 싱글톤 클래스가 로드될 때 호출됨
    static {
        logger.info("Singleton 클래스가 로드되었습니다.");
    }

    private Singleton() {
        // Singleton 인스턴스가 생성될 때 로그 출력
        logger.info("Singleton 생성자가 호출되었습니다.");
    }

    // static inner class
    private static class SingletonHelper {
        // 정적 내부 클래스가 로드될 때 로그 출력
        static {
            logger.info("SingletonHelper 클래스가 로드되었습니다.");
        }

        // Singleton 인스턴스가 초기화
        private static final Singleton INSTANCE = new Singleton();
    }

    // Singleton 인스턴스를 반환
    public static Singleton getInstance() {
        // getInstance() 호출 시 로그 출력
        logger.info("getInstance() 메서드가 호출되었습니다.");
        return SingletonHelper.INSTANCE;
    }

    public void someMethod() {
        // someMethod() 호출 시 로그 출력
        logger.info("someMethod()가 호출되었습니다.");
    }

}

