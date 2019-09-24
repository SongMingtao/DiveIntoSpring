package com.example.demoofcustomannotation.annotation;

import com.example.demoofcustomannotation.annotation.impl.RPCScannerRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Import(RPCScannerRegistrar.class)
@Documented
public @interface RPCScan {
    String[] basePackage() default {};
}
