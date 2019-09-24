package com.example.demoofcustomannotation;

import com.example.demoofcustomannotation.annotation.RPCScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RPCScan(basePackage = "com.example.demoofcustomannotation")
public class DemoOfCustomAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoOfCustomAnnotationApplication.class, args);
    }

}
