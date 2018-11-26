@file:JvmName("DrawableUtils")

package com.celites.kutils

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import android.util.TypedValue
import android.widget.ImageView

/**
 * Created by Prasham on 12/14/2015.
 */

/**
 * Apply Tint to drawable, this method returns a drawable that you have to use when you need
 * tinted drawable.
 * @param[color] Tint Color to apply
 * @return Tinted Drawable, use this
 * @receiver Drawable to apply tint To
 */
fun Drawable.applyTinting(@ColorInt color: Int): Drawable {
    mutate()
    val drawableToTint = DrawableCompat.wrap(this)
    DrawableCompat.setTint(drawableToTint, color)
    return drawableToTint
}

/**
 * Apply Tint to drawable, where color is pointed from Resource. This method returns a drawable
 * that you have to use when you need
 * tinted drawable.
 * @param[colorRes] Color Resource to apply tint
 * @param[context] Context to get Color from Resource
 * @return Tinted Drawable
 * @receiver Drawable to apply tint To
 */
fun Drawable.applyTinting(@ColorRes colorRes: Int, context: Context): Drawable {
    val color = ContextCompat.getColor(context, colorRes)
    return applyTinting(color)
}

/**
 * Apply Tint to ImageView.
 * @param[color] Tint Color to apply
 * @receiver ImageView where tint is being applied
 */
fun ImageView.applyTinting(@ColorInt color: Int) {
    val tintedDrawable = drawable.applyTinting(color)
    setImageDrawable(tintedDrawable)
}

/**
 * Get Bitmap from receiver's drawable.
 * **Caution:** This method isn't tested with vector drawable.
 * @receiver ImageView whose drawable is converted to Bitmap
 */
val ImageView.bitmapDrawable: Bitmap
    get() {
        return drawable.toBitmap(context.resources)
    }

/**
 * Get Bitmap from receiver.
 * **Caution:** This method isn't tested with vector drawable.
 * @receiver Drawable to convert to Bitmap
 */
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

