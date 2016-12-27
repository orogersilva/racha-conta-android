package com.orogersilva.rachaconta.taberna;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

/**
 * Created by orogersilva on 12/26/2016.
 */

public class RachaContaApp extends Application {

    // region APPLICATION LIFECYCLE METHODS

    @Override
    public void onCreate() {

        super.onCreate();

        Fabric.with(this, new Crashlytics());
    }

    // endregion
}
