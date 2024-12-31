package com.education.ztu;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CustomAnnotation {
    String value() default "Default Value";
    int priority() default 1;
}
