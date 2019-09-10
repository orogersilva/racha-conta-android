package com.orogersilva.rachaconta.taberna.activities;

import android.os.Build;
import android.support.design.widget.FloatingActionButton;

import com.orogersilva.rachaconta.taberna.BuildConfig;
import com.orogersilva.rachaconta.taberna.R;
import com.orogersilva.rachaconta.taberna.dialogs.InputAddFriendDialog;
import com.orogersilva.rachaconta.taberna.roboeletric.config.RobolectricGradleTestRunner;
import com.orogersilva.rachaconta.taberna.roboeletric.config.ShadowTheme;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.shadows.ShadowDialog;

/**
 * Created by orogersilva on 12/26/2016.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class DeskActivityTest {

    // region FIELDS

    private DeskActivity mDeskActivity;

    // endregion

    // region SETUP METHODS

    @Before
    public void setup() {

        //mDeskActivity = Robolectric.setupActivity(DeskActivity.class);
    }

    // endregion

    // region TEST METHODS

    @Test
    public void clickingOnFloatingActionButton_shouldStartDialog() {

        // ARRANGE
/*
if(mDeskActivity != null) {
    FloatingActionButton addFriendFloatingActionButton = (FloatingActionButton) mDeskActivity.findViewById(R.id.deskfloatingactionbutton);

    // ACT

    addFriendFloatingActionButton.performClick();

    InputAddFriendDialog inputAddFriendDialog = (InputAddFriendDialog) ShadowDialog.getLatestDialog();

    // ASSERT

    Assert.assertTrue(inputAddFriendDialog.isShowing());
} else {
    Assert.assertTrue(true);
}
    }
*/

    }// endregion
}
