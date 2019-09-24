package com.example.demoofcustomannotation.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD,})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRPC {
    String name() default "";
    String value() default "";
}
