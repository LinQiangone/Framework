package com.xwsd.android.myframework.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseActivity;
import com.xwsd.android.myframework.base.SimpleActivity;

public class WelcomeActivity extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }
}
