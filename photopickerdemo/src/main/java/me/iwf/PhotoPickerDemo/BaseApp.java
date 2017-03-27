package me.iwf.PhotoPickerDemo;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;

import com.hss01248.image.ImageLoader;

/**
 * Created by Administrator on 2017/3/25.
 */

public class BaseApp extends Application {
    int count =0;

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.init(this,60,false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
                @Override
                public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

                }

                @Override
                public void onActivityStarted(Activity activity) {
                    count++;
                }

                @Override
                public void onActivityResumed(Activity activity) {


                }

                @Override
                public void onActivityPaused(Activity activity) {


                }

                @Override
                public void onActivityStopped(Activity activity) {
                    count--;
                    if(count==0){
                        //进入后台了
                        ImageLoader.getActualLoader().clearAllMemoryCaches();

                    }
                }

                @Override
                public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

                }

                @Override
                public void onActivityDestroyed(Activity activity) {

                }
            });
        }
    }
}
