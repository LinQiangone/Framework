package com.xwsd.android.myframework.modules.project.projectdetail;


import com.xwsd.android.myframework.base.RxPresenter;
import com.xwsd.android.myframework.model.DataManager;
import com.xwsd.android.myframework.model.schedulers.BaseSchedulerProvider;
import com.xwsd.android.myframework.model.schedulers.SchedulerProvider;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;

/**
 * Created by qiang.lin on 2018/2/28.
 */

public class ProjectDetailPresenter extends RxPresenter<ProjectDetailContract.View> implements ProjectDetailContract.Presenter {

    private DataManager dataManager;
    private BaseSchedulerProvider schedulerProvider;
    private Disposable disposable;
    private final int START_TIME = 0;
    private final int TOTAL_NUMBER = 11;
    private final int INTERVAL_TIME = 1;
    private final int DELAY_TIME = 0;
    private int totalTime = 10;


    @Inject
    public ProjectDetailPresenter(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
    }

    /**
     * 最后一次事件走doOnComplete，所以需要多执行一次doOnNext
     */
    @Override
    public void countDown() {
         disposable = Flowable.intervalRange(START_TIME, TOTAL_NUMBER, DELAY_TIME, INTERVAL_TIME, TimeUnit.SECONDS)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnNext(aLong -> {
                    mView.updateTime(String.valueOf(totalTime - aLong));
                }).doOnComplete(() -> {
                    mView.setTextStatus();
                }).subscribe();
        addSubscribe(disposable);
    }
}
