package etc.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AComponent implements MemberTypeInterface {

    @Override
    public boolean convertable(MemberType memberType) {
        return MemberType.A == memberType;
    }

    @Override
    public void handle() {
        log.info("####### handle AComponent #######");
    }

    public void run() {
        log.info("####### AComponent #######");
    }

}
