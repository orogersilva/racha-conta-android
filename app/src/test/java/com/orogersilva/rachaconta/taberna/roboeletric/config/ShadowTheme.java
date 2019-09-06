package com.orogersilva.rachaconta.taberna.roboeletric.config;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import org.robolectric.Robolectric;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.shadows.ShadowResources;

@Implements(value = Resources.Theme.class)
public class ShadowTheme extends ShadowResources.ShadowTheme {


    @Implementation
    @Override
    public TypedArray obtainStyledAttributes(AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes) {
        try {
            return super.obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes);
        } catch (Throwable err) {
            AttributeSet attributeSet = Robolectric.buildAttributeSet()
                    .addAttribute(android.R.attr.layout_width, "0dp")
                    .addAttribute(android.R.attr.layout_height, "0dp")
                    .build();
            return super.obtainStyledAttributes(attributeSet, attrs, defStyleAttr, defStyleRes);
        }
    }
}
