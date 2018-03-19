package com.xwsd.android.myframework.modules.myself.download;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.content.PermissionChecker;
import android.view.View;
import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseFragment;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by qiang.lin on 2018/3/5.
 */
@RuntimePermissions
public class DownLoadFragment extends BaseFragment<DownLoadPresenter> implements DownLoadContract.View {

    @Override
    protected int getLayout() {
        return R.layout.fragment_download;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }


    @OnClick({R.id.navbar_left_image, R.id.tv_download})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.navbar_left_image:
                pop();
                break;
            case R.id.tv_download:
                if (PermissionChecker.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    //写入sd卡权限
                     DownLoadFragmentPermissionsDispatcher.applyDownloadPermissionWithPermissionCheck(this);
                } else {
                    applyDownloadPermission();
                }
                break;
        }
    }

    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void applyDownloadPermission() {
        mPresenter.download("http://xykd.taihaifintech.com//Uploads/Apk/20180305/5a9cf5c7330c4.apk",mActivity);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        DownLoadFragmentPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }



}
