package com.xwsd.android.myframework.utils;

import android.support.annotation.RestrictTo;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import java.lang.reflect.Field;

/**
 * Created by qiang.lin on 2017/9/12.
 * 解決BottomNavigationView 超过三个item问题
 */

public class BottomNavigationViewUtils {

    public static void disableShiftMode(BottomNavigationView navigationView) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigationView.getChildAt(0);
        Field shiftingMode = null;
        try {
            shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            try {
                shiftingMode.setBoolean(menuView, false);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(i);
                itemView.setShiftingMode(false);
                itemView.setChecked(itemView.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
