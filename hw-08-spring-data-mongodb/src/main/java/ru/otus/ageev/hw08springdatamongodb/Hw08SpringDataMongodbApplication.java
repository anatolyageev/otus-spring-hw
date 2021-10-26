package ru.otus.ageev.hw08springdatamongodb;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableMongock
@SpringBootApplication
@EnableConfigurationProperties
public class Hw08SpringDataMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hw08SpringDataMongodbApplication.class, args);
    }

}
