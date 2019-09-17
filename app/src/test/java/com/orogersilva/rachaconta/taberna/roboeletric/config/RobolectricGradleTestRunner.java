package com.orogersilva.rachaconta.taberna.roboeletric.config;

import android.app.Activity;
import android.os.Build;

import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.res.Fs;

import java.io.File;
import java.io.IOException;

public class RobolectricGradleTestRunner extends RobolectricTestRunner {
    private static final String PROJECT_DIR =
            "C:/racha-conta-android-master/racha-conta-android-master";


    private static final int MAX_SDK_SUPPORTED_BY_ROBOLECTRIC =
            Build.VERSION_CODES.JELLY_BEAN_MR2;

    public RobolectricGradleTestRunner(final Class<?> testClass) throws Exception {
        super(testClass);
    }

   /* private static AndroidManifest getAndroidManifest() {

        String manifestPath = PROJECT_DIR+"/app/src/main/AndroidManifest.xml";
        String resPath = PROJECT_DIR+"/app/src/main/res";
        String assetPath = PROJECT_DIR+"/app/src/main/assets";

        System.out.print(" manifest path: "+manifestPath);
        System.out.print(" resPath path: "+resPath);
        System.out.print(" assetPath path: "+assetPath);

        return new AndroidManifest(
                Fs.fileFromPath(manifestPath), Fs.fileFromPath(resPath), Fs.fileFromPath(assetPath)) {
            @Override public int getTargetSdkVersion() {
                return MAX_SDK_SUPPORTED_BY_ROBOLECTRIC;
            }
           *//* @Override
            public String getThemeRef(Class<? extends Activity> activityClass) {
                return "@style/RoboAppTheme";
            }*//*
        };
    }*/

    private static String getProjectDirectory() {
        String path = "";
        try {
            File file = new File("..");
            path = file.getCanonicalPath();
            path = path + "/app/";
        } catch (IOException ex) {}
        return path;
    }

   /* @Override public AndroidManifest getAppManifest(Config config) {
        return getAndroidManifest();
    }*/
}
