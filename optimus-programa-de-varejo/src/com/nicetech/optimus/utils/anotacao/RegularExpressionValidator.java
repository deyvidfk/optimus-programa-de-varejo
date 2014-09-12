package com.nicetech.optimus.utils.anotacao;

import com.nicetech.optimus.utils.Regex;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RegularExpressionValidator {

    Regex ValidationExpression();

    String Label();

    String RegexErrorMessage() default "Erro";

    boolean EnableErrorMessage() default true;
}
