package com.solarexsoft.mpandroidchartdemo;

import android.app.Application;

/**
 * <pre>
 *    Author: houruhou
 *    CreatAt: 16:50/2019-07-11
 *    Desc:
 * </pre>
 */

public class App extends Application {
    static Application me;

    @Override
    public void onCreate() {
        super.onCreate();
        me = this;
    }

    public static Application getApplication() {
        return me;
    }
}
