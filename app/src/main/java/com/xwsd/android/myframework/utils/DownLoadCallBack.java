package com.xwsd.android.myframework.utils;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;

import com.xwsd.android.myframework.modules.myself.download.FileCallBack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by qiang.lin on 2018/3/6.
 */

public class DownLoadCallBack implements FileCallBack{

    public static String path = Environment.getExternalStorageDirectory().getAbsolutePath();

    public static String name = "framework.apk";

    private ResponseBody responseBody;
    private Activity activity;

    public DownLoadCallBack(ResponseBody responseBody,Activity activity,FileCallBack fileCallBack) {
        this.activity=activity;
        this.responseBody=responseBody;
        downloadFile();
    }

    @Override
    public void updateProgress(int progress) {

    }



    public void downloadFile() {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            long fileSize = responseBody.contentLength();
            inputStream = responseBody.byteStream();
            outputStream = new FileOutputStream(new File(path, name));
            byte[] dataSize = new byte[1024];
            int length = 0;
            int totalLength = 0;
            int progress = 0;
            Bundle bundle = null;
            while ((length = inputStream.read(dataSize)) != -1) {
                outputStream.write(dataSize, 0, length);
//                做计算
                totalLength += length;
                progress = (int) ((totalLength / (double) fileSize) * 100);
                int finalProgress = progress;
                activity.runOnUiThread(() -> {
                    updateProgress(finalProgress);
                });
            }
            outputStream.flush();
        } catch (IOException e) {
            e.getMessage();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
                if (outputStream != null)
                    outputStream.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }


}
