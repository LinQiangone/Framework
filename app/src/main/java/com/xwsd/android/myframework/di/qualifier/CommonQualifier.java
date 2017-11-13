package com.xwsd.android.myframework.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by qiang.lin on 2017/11/8.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface CommonQualifier {
}
