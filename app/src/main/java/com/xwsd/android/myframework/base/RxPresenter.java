package com.xwsd.android.myframework.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by qiang.lin on 2017/11/7.
 *
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T>{

    protected T mView;
    protected CompositeDisposable mCompositeDisposable;

    protected void unSubscribe(){
        if (mCompositeDisposable != null){
            mCompositeDisposable.clear();
        }
    }

    protected void addSubscribe(Disposable disposable){
        if (mCompositeDisposable == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void attachView(T view) {
        mView = view;
    }

    //view的分离
    @Override
    public void detachView() {
        mView = null;
        unSubscribe();
    }


}
