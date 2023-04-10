package etc.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SampleFactory {

    @Autowired
    private MemberTypeFactory memberTypeFactory;

    public static void main(String[] args) {
        AnyRequest anyRequest = new AnyRequest("userEmail", "userAddr", MemberType.A);
//        AnyRequest anyRequest = new AnyRequest("userEmail", "userAddr", MemberType.B);
//        AnyRequest anyRequest = new AnyRequest("userEmail", "userAddr", MemberType.D);

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        SampleFactory sf = ac.getBean(SampleFactory.class);
        sf.handleRequest(anyRequest);
    }

    private void handleRequest(AnyRequest request) {
        MemberTypeInterface memberTypeInterface = memberTypeFactory.getMemberTypeInterface(request.getMemberType());
        memberTypeInterface.handle();
    }

}
