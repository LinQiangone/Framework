package com.xwsd.android.myframework.modules;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.app.Constants;
import com.xwsd.android.myframework.base.BaseFragment;
import com.xwsd.android.myframework.modules.discover.index.DiscoverFragment;
import com.xwsd.android.myframework.modules.home.index.HomeFragment;
import com.xwsd.android.myframework.modules.myself.index.MyselfFragment;
import com.xwsd.android.myframework.modules.project.index.ProjectFragment;
import com.xwsd.android.myframework.utils.BottomNavigationViewUtils;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by qiang.lin on 2017/11/7.
 * 主页
 */

public class MainFragment extends BaseFragment<MainFragmentPresenter> implements MainFragmentContract.View, BottomNavigationView.OnNavigationItemSelectedListener {

    private MyselfFragment myselfFragment;
    private HomeFragment homeFragment;
    private ProjectFragment projectFragment;
    private DiscoverFragment discoverFragment;

    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;
    private int hideFragment = 0;
    private int showFragment = 0;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initEventAndData() {
        initBottomNavigation();
    }


    /**
     * 底部导航初始化
     */
    public void initBottomNavigation() {
        BottomNavigationViewUtils.disableShiftMode(bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SupportFragment firstFragment = findChildFragment(HomeFragment.class);
        if (firstFragment == null) {
            homeFragment = new HomeFragment();
            myselfFragment = new MyselfFragment();
            projectFragment=new ProjectFragment();
            discoverFragment=new DiscoverFragment();
            loadMultipleRootFragment(R.id.content, 0, homeFragment,projectFragment,discoverFragment, myselfFragment);
        } else {
            homeFragment = (HomeFragment) firstFragment;
            projectFragment=findChildFragment(ProjectFragment.class);
            discoverFragment=findChildFragment(DiscoverFragment.class);
            myselfFragment = findChildFragment(MyselfFragment.class);
        }

    }

    private SupportFragment getTargetFragment(int item) {
        switch (item) {
            case Constants.HOME_FRAGMENT:
                return homeFragment;
            case Constants.SECOND_FRAGMENT:
                return projectFragment;
            case Constants.THIRD_FRAGMENT:
                return discoverFragment;
            case Constants.MY_CENTER_FRAGMENT:
                return myselfFragment;
        }
        return homeFragment;
    }

    /**
     * 页面内容切换
     */
    public void switchFragment() {
        showHideFragment(getTargetFragment(showFragment), getTargetFragment(hideFragment));
        hideFragment = showFragment;
    }


    /**
     * 底部导航栏切换事件
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_fragment:
                showFragment = Constants.HOME_FRAGMENT;
                switchFragment();
                break;
            case R.id.second_fragment:
                showFragment = Constants.SECOND_FRAGMENT;
                switchFragment();
                break;
            case R.id.third_fragment:
                showFragment = Constants.THIRD_FRAGMENT;
                switchFragment();
                break;
            case R.id.my_center_fragment:
                showFragment = Constants.MY_CENTER_FRAGMENT;
                switchFragment();
                break;
        }
        return true;
    }


}
