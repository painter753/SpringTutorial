package com.lazyprod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = "com.lazyprod"
)
public class Main {

    public static void main (String[] args ) {
        SpringApplication.run(Main.class);
    }

}
