package com.srijanmukherjee.yeetcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class YeetcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(YeetcodeApplication.class, args);
    }

}
