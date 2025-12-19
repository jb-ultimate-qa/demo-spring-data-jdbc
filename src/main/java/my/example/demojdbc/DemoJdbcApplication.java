package my.example.demojdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJdbcApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoJdbcApplication.class);
        app.setAdditionalProfiles("book");      // change profile to switch between runners
        app.run(args);
    }

}
