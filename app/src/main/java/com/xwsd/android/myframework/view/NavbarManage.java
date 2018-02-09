package com.xwsd.android.myframework.view;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.xwsd.android.myframework.R;

/**
 * 管理导航栏各控件的显示影藏
 */
public class NavbarManage {
    private Activity activity;
    private View rootView;
    private Toolbar toolbar;
    public TextView navbar_left_text;
    public ImageView navbar_centre_image;
    public TextView navbar_centre;
    public TextView navbar_right_text;
    public SlidingTabLayout tl;

    private ImageView navbar_left_image;
    private ImageView navbar_right_image;
    public LinearLayout navbar_left;
    public LinearLayout navbar_right;
    private OnLeftClickListener onLeftClickListener;
    private OnRightClickListener onRightClickListener;
    private OnLeftTextClickListener onLeftTextClickListener;
    private OnRightTextClickListener onRightTextClickListener;
    /**
     * 在Activity中使用导航栏
     *
     * @param activity
     */
    public NavbarManage(Activity activity) {
        this.activity = activity;
        init();
    }

    /**
     * 在Fragment中使用导航栏
     *
     * @param view
     */
    public NavbarManage(Activity activity, View view) {
        this.activity = activity;
        this.rootView = view;
        init();
    }


    private void init() {
        if (rootView == null) {
            toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
            navbar_left_text = (TextView) activity.findViewById(R.id.navbar_left_text);
            navbar_centre = (TextView) activity.findViewById(R.id.navbar_centre);
            navbar_centre_image = (ImageView) activity.findViewById(R.id.navbar_centre_ima);
            navbar_right_text = (TextView) activity.findViewById(R.id.navbar_right_text);
            navbar_left = (LinearLayout) activity.findViewById(R.id.navbar_left);
            navbar_right = (LinearLayout) activity.findViewById(R.id.navbar_right);
            navbar_left_image = (ImageView) activity.findViewById(R.id.navbar_left_image);
            navbar_right_image = (ImageView) activity.findViewById(R.id.navbar_right_image);
            tl = (SlidingTabLayout) activity.findViewById(R.id.tl);

        } else {
            toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
            navbar_left_text = (TextView) rootView.findViewById(R.id.navbar_left_text);
            navbar_centre = (TextView) rootView.findViewById(R.id.navbar_centre);
            navbar_centre_image = (ImageView) activity.findViewById(R.id.navbar_centre_ima);
            navbar_right_text = (TextView) rootView.findViewById(R.id.navbar_right_text);
            navbar_left = (LinearLayout) rootView.findViewById(R.id.navbar_left);
            navbar_right = (LinearLayout) rootView.findViewById(R.id.navbar_right);
            navbar_left_image = (ImageView) rootView.findViewById(R.id.navbar_left_image);
            navbar_right_image = (ImageView) rootView.findViewById(R.id.navbar_right_image);
            tl = (SlidingTabLayout) rootView.findViewById(R.id.tl);
        }

        setBackgroundColor(R.color.colorPrimary);
        showLeft(true);
        setTextColor(R.color.white);
        setLeftImg(R.mipmap.back_white);
    }

    //设置控件显示----------------------------------------------------------------------

    /**
     * 设置显示中间标题
     */
    public void showCentre(boolean showTitle) {
        if (showTitle) {
            navbar_centre.setVisibility(View.VISIBLE);
        } else {
            navbar_centre.setVisibility(View.GONE);
        }
    }
    /**
     * 设置显示中间图标
     */
    public void showCentreImage(boolean showTitle) {
        if (showTitle) {
            navbar_centre_image.setVisibility(View.VISIBLE);
        } else {
            navbar_centre_image.setVisibility(View.GONE);
        }
    }
    /**
     * 设置显示中间tab
     */
    public void showCentreTab(boolean showTitle) {
        if (showTitle) {
            tl.setVisibility(View.VISIBLE);
        } else {
            tl.setVisibility(View.GONE);
        }
    }
    /**
     * 设置显示左边按钮
     */
    public void showLeft(boolean showBack) {
        if (showBack) {
            navbar_left.setVisibility(View.VISIBLE);
        } else {
            navbar_left.setVisibility(View.GONE);
        }
    }

    /**
     * 设置显示右边按钮
     */
    public void showRight(boolean showBill) {
        if (showBill) {
            navbar_right.setVisibility(View.VISIBLE);
        } else {
            navbar_right.setVisibility(View.GONE);
        }
    }
    /**
     * 设置显示右边图片
     */
    public void showRightImg(boolean showBill) {
        if (showBill) {
            navbar_right_image.setVisibility(View.VISIBLE);
        } else {
            navbar_right_image.setVisibility(View.GONE);
        }
    }

    //设置控件内容----------------------------------------------------------------------


    /**
     * 设置背景颜色
     */
    public void setBackgroundColor(int colorId) {
        toolbar.setBackgroundColor(activity.getResources().getColor(colorId));
    }

    /**
     * 设置字体颜色
     */
    public void setTextColor(int colorId) {
        navbar_left_text.setTextColor(activity.getResources().getColor(colorId));
        navbar_centre.setTextColor(activity.getResources().getColor(colorId));

    }



    public void setTextSize(int textSize) {
//        以sp为单位
        navbar_centre.setTextSize(textSize);
    }
    /**
     * 设置字体颜色
     */
    public void setRightTextColor(int colorId) {
        navbar_right_text.setTextColor(activity.getResources().getColor(colorId));
    }

    /**
     * 设置左边文本
     */
    public void setLeftStr(String str) {
        navbar_left_text.setText(str);
    }
    /**
     * 设置左边文本图片
     */
    public void setLeftSrc(int imgId) {
        navbar_left_text.getLayoutParams().height =activity.getResources().getDimensionPixelSize(R.dimen.DIMEN_25) ;
        navbar_left_text.getLayoutParams().width = activity.getResources().getDimensionPixelSize(R.dimen.DIMEN_25) ;
        navbar_left_text.setBackgroundDrawable(activity.getResources().getDrawable(imgId));

    }

    /**
     * 设置中间文本
     */
    public void setCentreStr(String str) {
        navbar_centre.setText(str);
    }



    /**
     * 设置中间图标
     */
    public void setCentreBackground(@DrawableRes int resid) {
        navbar_centre_image.setVisibility(View.VISIBLE);
        navbar_centre_image.setImageResource(resid);
}

    /**
     * 设置中间tab
     */
    public void setCentreTabViewPager(ViewPager vp, String[] titles) {
        tl.setVisibility(View.VISIBLE);
        tl.setViewPager(vp,titles);
    }
    /**
     * 设置右边文本
     */
    public void setRightStr(String str) {
        navbar_right_text.setText(str);
    }

    /**
     * 设置右边文本图片
     */
    public void setRightBackground(int imgId) {
        navbar_right_text.getLayoutParams().height =activity.getResources().getDimensionPixelSize(R.dimen.DIMEN_25) ;
        navbar_right_text.getLayoutParams().width = activity.getResources().getDimensionPixelSize(R.dimen.DIMEN_25) ;
        navbar_right_text.setBackgroundDrawable(activity.getResources().getDrawable(imgId));
    }

    /**
     * 设置左边图片
     */
    public void setLeftImg(int imgId) {
        navbar_left_image.setBackgroundDrawable(activity.getResources().getDrawable(imgId));
    }

    /**
     * 设置右边图片
     */
    public void setRightImg(int imgId) {
        navbar_right_image.setBackgroundDrawable(activity.getResources().getDrawable(imgId));
    }





    //设置按钮监听器----------------------------------------------------------------------

    /**
     * 设置左边按钮监听器
     */
    public void setOnLeftClickListener(OnLeftClickListener onLeftClickListener) {
        this.onLeftClickListener = onLeftClickListener;
        navbar_left_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NavbarManage.this.onLeftClickListener != null) {
                    NavbarManage.this.onLeftClickListener.onLeftClick();
                }
            }
        });

    }

    /**
     * 设置左边文字按钮监听器
     */
    public void setOnLeftTextClickListener(OnLeftTextClickListener onLeftTextClickListener) {
        this.onLeftTextClickListener = onLeftTextClickListener;
        navbar_left_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NavbarManage.this.onLeftTextClickListener != null) {
                    NavbarManage.this.onLeftTextClickListener.onLeftClick();
                }
            }
        });

    }
    /**
     * 设置右边按钮监听器
     */
    public void setOnRightClickListener(OnRightClickListener onRightClickListener) {
        this.onRightClickListener = onRightClickListener;
        navbar_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NavbarManage.this.onRightClickListener != null) {
                    NavbarManage.this.onRightClickListener.onRightClick();
                }
            }
        });

    }

    /**
     * 设置左边文字按钮监听器
     */
    public void setOnRightTextClickListener(OnRightTextClickListener onRightTextClickListener) {
        this.onRightTextClickListener = onRightTextClickListener;
        navbar_right_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NavbarManage.this.onRightTextClickListener != null) {
                    NavbarManage.this.onRightTextClickListener.onRightClick();
                }
            }
        });

    }
    //按钮监听接口----------------------------------------------------------------------

    /**
     * Menu按钮的事件监听
     */
    public interface OnRightClickListener {
        void onRightClick();
    }

    /**
     * Back按钮的事件监听
     */
    public interface OnLeftClickListener {
        void onLeftClick();
    }
    /**
     * 功能按钮的事件监听
     */
    public interface OnLeftTextClickListener {
        void onLeftClick();
    }
    /**
     * 功能按钮的事件监听
     */
    public interface OnRightTextClickListener {
        void onRightClick();    }
}
