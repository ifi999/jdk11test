package etc.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BComponent {

    public void run() {
        log.info("####### BComponent #######");
    }

}
