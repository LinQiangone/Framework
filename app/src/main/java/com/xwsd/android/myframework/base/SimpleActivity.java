package com.xwsd.android.myframework.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.xwsd.android.myframework.app.AppManager;
import com.xwsd.android.myframework.app.MyApp;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by qiang.lin on 2017/11/3.
 */

public abstract class SimpleActivity extends SupportActivity {
    private Unbinder unbinder;
    protected Activity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mContext = this;
        unbinder = ButterKnife.bind(this);
        onViewCreated();
        AppManager.getInstance().addActivity(this);
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().finishActivity(this);
        try {
            unbinder.unbind();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onViewCreated(){

    }

    protected void setToolBar(Toolbar toolbar,int titleId, String title) {
        //toolbar_back.setTitle(title);
        TextView textView = (TextView) findViewById(titleId);
        textView.setText(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressedSupport();
            }
        });
    }



    protected abstract int getLayout();
    protected abstract void initEventAndData();
}
