package com.xwsd.android.myframework.modules.welcome;

import android.os.Bundle;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.SimpleActivity;

import javax.inject.Inject;

/**
 * Created by qiang.lin on 2018/2/28.
 * 引导页
 */
public class WelcomeActivity extends SimpleActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }


    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected void initEventAndData() {
    }

}
