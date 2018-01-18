@file:JvmName("DrawableUtils")
package com.celites.kutils

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.util.TypedValue
import android.widget.ImageView

/**
 * Created by Prasham on 12/14/2015.
 */
fun Drawable.applyTinting(@ColorInt color: Int): Drawable {
    mutate()
    val drawableToTint = DrawableCompat.wrap(this)
    DrawableCompat.setTint(drawableToTint, color)
    return drawableToTint
}

fun Drawable.applyTinting(@ColorRes colorRes: Int, context: Context): Drawable {
    val color = ContextCompat.getColor(context, colorRes)
    return applyTinting(color)
}

fun ImageView.applyTinting(@ColorInt color: Int) {
    val tintedDrawable = drawable.applyTinting(color)
    setImageDrawable(tintedDrawable)
}

val ImageView.bitmapDrawable: Bitmap
    get() {
        if (drawable is BitmapDrawable) {
            return (drawable as BitmapDrawable).bitmap
        }
        var width = drawable.intrinsicWidth
        var height = drawable.intrinsicHeight
        val r = context.resources
        val px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 56.0f,
                r.displayMetrics).toInt()
        if (width <= 0) {
            width = px
        }
        if (height <= 0) {
            height = px
        }

        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)

        return bitmap
    }

fun Drawable.toBitmap(resources: Resources): Bitmap {
    if (this is BitmapDrawable) {
        return this.bitmap
    }
    var width = intrinsicWidth
    var height = intrinsicHeight
    val px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 56.0f,
            resources.displayMetrics).toInt()
    if (width <= 0) {
        width = px
    }
    if (height <= 0) {
        height = px
    }

    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    setBounds(0, 0, canvas.width, canvas.height)
    draw(canvas)

    return bitmap
}

