package com.xwsd.android.myframework.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by 95 on 2017/5/3.
 */

@Scope
@Retention(RUNTIME)
public @interface FragmentScope {
}
