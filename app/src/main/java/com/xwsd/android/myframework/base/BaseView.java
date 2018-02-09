package com.xwsd.android.myframework.base;

/**
 * Created by qiang.lin on 2017/11/4.
 */

public interface BaseView {
    /**
     * 显示错误信息
     *
     * @param msg
     */
    void showErrorMsg(String msg);

    /**
     * 显示错误页
     *
     * @param i
     */
    void showErrorPage(int i);

    /**
     * 显示正在加载progress
     */
    void showLoading();

    /**
     * 隐藏正在加载progress
     */
    void hideLoading();

    /**
     * 显示成功信息
     * @param msg
     */
    void showSuccessMsg(String msg);
}
