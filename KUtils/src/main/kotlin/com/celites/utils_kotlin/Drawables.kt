package com.celites.utils_kotlin

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView

/**
 * Created by Prasham on 12/14/2015.
 */
public fun Drawable.applyTinting(@ColorInt color: Int): Drawable {
    mutate()
    var drawableToTint = DrawableCompat.wrap(this);
    DrawableCompat.setTint(drawableToTint, color);
    return drawableToTint;
}

public fun Drawable.applyTinting(@ColorRes colorRes: Int, context: Context): Drawable {
    var color = ContextCompat.getColor(context, colorRes);
    return applyTinting(color)
}

public fun ImageView.applyTinting(@ColorInt color: Int) {
    val tintedDrawable = drawable.applyTinting(color)
    setImageDrawable(tintedDrawable)
}

