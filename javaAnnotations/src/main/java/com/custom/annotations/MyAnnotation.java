package com.custom.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE, ElementType.FIELD})
public @interface MyAnnotation {

    String name() default "FirstCustomAnnotation";
    int count() default 999;

    String[] tags() default {"Java", "Python", "C#"};
}
