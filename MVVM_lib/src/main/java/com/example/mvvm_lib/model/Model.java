package com.example.mvvm_lib.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Model
 * @Description TODO
 * @Author 梁波
 * @Date 2021/8/18 9:02
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Model {
    String value() default "";
}
