package com.xwsd.android.myframework.model.schedulers;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

/**
 * Created by qiang.lin on 017/11/9.
 */
public interface BaseSchedulerProvider {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();

    @NonNull
    Scheduler trampoline();

}
