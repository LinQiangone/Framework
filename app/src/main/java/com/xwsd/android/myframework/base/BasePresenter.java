package com.xwsd.android.myframework.base;

/**
 * Created by qiang.lin on 2017/11/3.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
}
