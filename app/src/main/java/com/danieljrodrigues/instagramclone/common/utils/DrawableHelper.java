package com.danieljrodrigues.instagramclone.common.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;

public final class DrawableHelper {

    public static Drawable getDrawable(Context context, @DrawableRes int drawable) {
        return ContextCompat.getDrawable(context, drawable);
    }

}
