package time.capsule.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class TimeCapsuleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeCapsuleApiApplication.class, args);
    }

}
