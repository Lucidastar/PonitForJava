package com.lucida.point.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface UseCase {
    public int id();
    public String description() default "no description";
}
