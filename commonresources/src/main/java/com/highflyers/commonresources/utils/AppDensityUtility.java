package com.highflyers.commonresources.utils;

import android.content.Context;

public class AppDensityUtility {

    public static int convertToPx (int dp, Context context) {
        // Get the screen's density scale
        final float scale = context.getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (dp * scale + 0.5f);
    }

}
