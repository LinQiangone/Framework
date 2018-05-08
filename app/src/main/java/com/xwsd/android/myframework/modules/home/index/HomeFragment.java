package com.xwsd.android.myframework.modules.home.index;

import android.animation.ObjectAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseLazyFragment;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by qiang.lin on 2017/11/7.
 * 首页
 */

public class HomeFragment extends BaseLazyFragment<HomePresenter> implements HomeContract.View {


    @BindView(R.id.rl_layout)
    RelativeLayout rlLayout;

private int rlTopShareHeight;
private ObjectAnimator topUpAnimation;
    private ObjectAnimator topPullAnimation;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initEventAndData() {
        rlLayout.post(new Runnable() {
            @Override
            public void run() {

                rlTopShareHeight = rlLayout.getHeight();
                initAnimation();
            }
        });
    }


    @OnClick(R.id.tv_title)
    public void onViewClicked() {
        //click share btn
        if(!topPullAnimation.isRunning()) {
            topPullAnimation.start();
        }
        if(!topUpAnimation.isRunning()) {
            topUpAnimation.start();
        }

    }
    /**
     * 初始化Animation
     */
    private void initAnimation() {
        /**
         * 顶部动画
         */
        //打开动画
        topPullAnimation = ObjectAnimator.ofFloat(
                rlLayout,"translationY",rlTopShareHeight);
        topPullAnimation.setDuration(1000);
        topPullAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        //关闭动画
        topUpAnimation = ObjectAnimator.ofFloat(
                rlLayout,"translationY",-rlTopShareHeight);
        topUpAnimation.setDuration(500);
        topUpAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        topUpAnimation.start();

    }

}
