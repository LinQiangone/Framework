package com.xwsd.android.myframework.view.loading;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.xwsd.android.myframework.R;


/**
 * 装载对话框
 * 可设置消息提示
 */
public class LoadDialog extends Dialog {
    View view;
    TextView tvMessage;
    ProgressBar ivProgressSpinner;
    Context context;

    public LoadDialog(Context context) {
        super(context, R.style.DialogTheme);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));
        this.setCanceledOnTouchOutside(false);
        this.context = context;
        view = getLayoutInflater().inflate(R.layout.dialog_progress, null);
        tvMessage = (TextView) view.findViewById(R.id.textview_message);
        ivProgressSpinner = (ProgressBar) view
                .findViewById(R.id.imageview_progress_spinner);

        this.setContentView(view);
    }

    public LoadDialog setMessage(String message) {
        tvMessage.setText(message);
        return this;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
//        ivProgressSpinner.post(new Runnable() {
//            @Override
//            public void run() {
//                adProgressSpinner.start();
//            }
//        });
    }
}
