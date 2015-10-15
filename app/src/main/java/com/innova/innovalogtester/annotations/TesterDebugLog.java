package com.innova.innovalogtester.annotations;

/**
 * Created by mtuksal on 09.10.2015.
 */
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

@Target({TYPE, METHOD, CONSTRUCTOR}) @Retention(CLASS)
public @interface TesterDebugLog {
}