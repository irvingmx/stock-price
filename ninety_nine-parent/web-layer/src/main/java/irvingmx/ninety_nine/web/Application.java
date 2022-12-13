package irvingmx.ninety_nine.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"irvingmx.ninety_nine.*"})
@EntityScan(basePackages = {"irvingmx.ninety_nine.*"})
@EnableJpaRepositories(basePackages = {"irvingmx.ninety_nine.*"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
