package com.xwsd.android.myframework.base;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.app.AppManager;
import com.xwsd.android.myframework.app.MyApp;
import com.xwsd.android.myframework.model.preferences.PreferencesHelperImpl;
import com.xwsd.android.myframework.view.loading.LoadDialog;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by qiang.lin on 2017/11/3.
 */

public abstract class SimpleActivity extends SupportActivity {
    private Unbinder unbinder;
    protected Activity mContext;
    private LoadDialog loadDialog;

    @Inject
    protected PreferencesHelperImpl preferencesHelper;

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
        if (unbinder != null)
            unbinder.unbind();
    }

    protected void onViewCreated(){

    }


    public LoadDialog showWaitDialog() {
        if (loadDialog == null) {
            loadDialog = new LoadDialog(this);

        }
        if (loadDialog != null) {
            loadDialog.setMessage(getString(R.string.loading));
            loadDialog.show();
        }
        return loadDialog;
    }

    public void hideWaitDialog() {
        if ( loadDialog != null) {
            try {
                loadDialog.dismiss();
                loadDialog = null;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    protected abstract int getLayout();

    protected abstract void initEventAndData();
}
