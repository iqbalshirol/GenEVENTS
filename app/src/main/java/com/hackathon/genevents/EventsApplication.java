package com.hackathon.genevents;

import android.app.Application;
import android.content.Context;

/**
 * Created by venkatesh.kolla on 11/28/2015.
 */
public class EventsApplication extends Application{

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);
    }
    private void setInstance(final EventsApplication currentObj) {
        context = currentObj;
    }
    public static Context getContext() {
        return context;
    }
    public static String getResString(final int resId) {
        return getContext().getResources().getString(resId);
    }
}
