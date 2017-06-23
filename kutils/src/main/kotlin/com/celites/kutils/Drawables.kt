@file:JvmName("DrawableUtils")
package com.celites.kutils

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.widget.ImageView

/**
 * Created by Prasham on 12/14/2015.
 */
public fun Drawable.applyTinting(@ColorInt color: Int): Drawable {
    mutate()
    val drawableToTint = DrawableCompat.wrap(this);
    DrawableCompat.setTint(drawableToTint, color);
    return drawableToTint;
}

public fun Drawable.applyTinting(@ColorRes colorRes: Int, context: Context): Drawable {
    val color = ContextCompat.getColor(context, colorRes);
    return applyTinting(color)
}

public fun ImageView.applyTinting(@ColorInt color: Int) {
    val tintedDrawable = drawable.applyTinting(color)
    setImageDrawable(tintedDrawable)
}

