package com.xwsd.android.myframework.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.app.AppManager;
import com.xwsd.android.myframework.app.MyApp;
import com.xwsd.android.myframework.model.preferences.PreferencesHelperImpl;
import com.xwsd.android.myframework.view.loading.LoadDialog;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by qiang.lin on 2017/11/7.懒加载
 */

public abstract class SimpleLazyFragment extends SupportFragment {
    protected View mView;
    protected Activity mActivity;
    protected Context mContext;
    protected Unbinder unbinder;
    private LoadDialog loadDialog;
    @Inject
    protected PreferencesHelperImpl preferencesHelper;
    @Nullable
    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bSavedInstanceState) {
        mView = inflater.inflate(getLayout(), null);
        unbinder = ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initEventAndData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null)
            unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        MyApp.getRefWatcher(mContext).watch(this);
    }

    protected abstract int getLayout();

    protected abstract void initEventAndData();

    @Override
    public boolean onBackPressedSupport() {
        AppManager.getInstance().finishActivity(mActivity);
        // 默认flase，继续向上传递,如果return true，则消费该事件，不再向上传递。
        return super.onBackPressedSupport();
    }


    public LoadDialog showWaitDialog() {
        if (loadDialog == null) {
            loadDialog = new LoadDialog(getActivity());

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
}
