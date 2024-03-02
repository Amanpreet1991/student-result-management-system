package io.shyftlabs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Student Result Management System"))
public class StudentResultManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentResultManagementApplication.class, args);
    }

}
