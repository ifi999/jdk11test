package etc.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BComponent implements MemberTypeInterface {

    @Override
    public boolean convertable(MemberType memberType) {
        return MemberType.B == memberType;
    }

    @Override
    public void handle() {
        log.info("####### handle BComponent #######");
    }

    public void run() {
        log.info("####### BComponent #######");
    }

}
