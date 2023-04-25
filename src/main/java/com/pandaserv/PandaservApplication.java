package com.pandaserv;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Panda"))
@EnableEurekaClient
public class PandaservApplication {

    public static void main(String[] args) {
        SpringApplication.run(PandaservApplication.class, args);
    }

}
