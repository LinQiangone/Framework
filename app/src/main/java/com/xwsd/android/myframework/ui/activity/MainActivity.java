package com.xwsd.android.myframework.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseActivity;
import com.xwsd.android.myframework.presenter.MainPresenter;
import com.xwsd.android.myframework.ui.fragment.MainFragment;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class MainActivity extends BaseActivity<MainPresenter> {


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.view_main, new MainFragment());
        }
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }


    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }
}
