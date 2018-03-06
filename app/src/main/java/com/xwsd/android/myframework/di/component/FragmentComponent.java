package com.xwsd.android.myframework.di.component;

import android.app.Activity;

import com.xwsd.android.myframework.di.module.FragmentModule;
import com.xwsd.android.myframework.di.scope.FragmentScope;
import com.xwsd.android.myframework.modules.MainFragment;
import com.xwsd.android.myframework.modules.discover.index.DiscoverFragment;
import com.xwsd.android.myframework.modules.home.index.HomeFragment;
import com.xwsd.android.myframework.modules.myself.download.DownLoadFragment;
import com.xwsd.android.myframework.modules.myself.index.MyselfFragment;
import com.xwsd.android.myframework.modules.others.webview.BaseWebViewFragment;
import com.xwsd.android.myframework.modules.project.index.ProjectFragment;
import com.xwsd.android.myframework.modules.project.projectdetail.ProjectDetailFragment;

import dagger.Component;

/**
 * Created by qiang.lin on 2017/11/7.
 * 注入fragment
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();

    /**
     * 主页
     *
     * @param fragment
     */
    void inject(MainFragment fragment);

    /**
     * 首页
     *
     * @param fragment
     */
    void inject(HomeFragment fragment);

    /**
     * 我的
     *
     * @param fragment
     */
    void inject(MyselfFragment fragment);

    /**
     * 项目
     *
     * @param fragment
     */
    void inject(ProjectFragment fragment);

    /**
     * 发现
     *
     * @param fragment
     */
    void inject(DiscoverFragment fragment);

    /**
     * 项目详情
     *
     * @param fragment
     */
    void inject(ProjectDetailFragment fragment);

    /**
     * x5WebView基类
     *
     * @param fragment
     */
    void inject(BaseWebViewFragment fragment);

    /**
     * 文件下载功能
     * @param fragment
     */
    void inject(DownLoadFragment fragment);
}
