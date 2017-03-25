package me.iwf.PhotoPickerDemo;

import android.app.Application;

import com.hss01248.image.ImageLoader;

/**
 * Created by Administrator on 2017/3/25.
 */

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.init(this,60);
    }
}
