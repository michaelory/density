package density;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DensityMain {

    private static Logger LOG = LoggerFactory.getLogger(DensityMain.class);

    public static void main(String... args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(DensityMain.class, args);
        LOG.info("APPLICATION FINISHED");
    }
}
