package com.xwsd.android.myframework.utils;

import android.app.NotificationManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;

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

public class DownLoadUtils {

    public static String path = Environment.getExternalStorageDirectory().getAbsolutePath();

    public static String name = "framework.apk";

    /**
     * 如果返回true下载成功，false下载失败
     *
     * @param
     * @return
     */
    public static boolean saveFile(ResponseBody responseBody, Handler handler) {
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
                Message msg = handler.obtainMessage();
                if (bundle==null) bundle = new Bundle();
                bundle.putInt("progress", progress);
                msg.setData(bundle);
                msg.what = 1;
                msg.sendToTarget();
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
                if (outputStream != null)
                    outputStream.close();
            } catch (Exception e) {
                return false;
            }
        }
    }




}
