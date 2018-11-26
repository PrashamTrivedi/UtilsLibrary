@file:JvmName("ViewUtils")

package com.celites.kutils

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import androidx.annotation.MenuRes
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.PopupMenu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StyleRes
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import androidx.core.widget.TextViewCompat

const val NO_GETTER: String = "Property does not have a getter"

fun noGetter(): Nothing = throw RuntimeException("Property does not have a getter")

var View.backgroundDrawable: Drawable?
    inline get() = background
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    set(value) {
        background = value
    }

inline var TextView.isSelectable: Boolean
    get() = isTextSelectable
    set(value) = setTextIsSelectable(value)


fun TextView.updateTextAppearance(@StyleRes resource: Int) =
        TextViewCompat.setTextAppearance(this, resource)

var ImageView.image: Drawable?
    inline get() = drawable
    inline set(value) = setImageDrawable(value)


@Deprecated(message = "This method is deprecated, please use Android KTX's method", level = DeprecationLevel.ERROR)
@JvmOverloads
fun setVisible(condition: Boolean, shouldBeGoneWhenFalse: Boolean = true) {
//    val visibility = if (condition) View.VISIBLE else if (shouldBeGoneWhenFalse) View.GONE else View.INVISIBLE
//    setVisibility(visibility)
    //Sorry won't do anything
}

fun View.hideKeyboard() {
    val imm = context.inputMethodManager
    imm?.hideSoftInputFromWindow(windowToken, 0)
}

inline fun View.showPopupMenu(@MenuRes menuId: Int, crossinline menuItemClickListener: (MenuItem) -> Unit) {
    val popupMenu = PopupMenu(context, this)
    popupMenu.menuInflater.inflate(menuId, popupMenu.menu)
    popupMenu.setOnMenuItemClickListener {
        menuItemClickListener(it)
        true
    }
    popupMenu.show()
}


fun View.bgColorAnim(from: Int, to: Int) {
    val backgroundColorAnimator = ObjectAnimator.ofObject(
            this,
            "backgroundColor",
            ArgbEvaluator(),
            ContextCompat.getColor(context, from),
            ContextCompat.getColor(context, to)
    )
    backgroundColorAnimator.duration = 300
    backgroundColorAnimator.start()
}

fun TextView.textColorAnim(from: Int, to: Int) {
    val textColorAnimator = ObjectAnimator.ofObject(
            this,
            "textColor",
            ArgbEvaluator(),
            ContextCompat.getColor(context, from),
            ContextCompat.getColor(context, to)
    )
    textColorAnimator.duration = 300
    textColorAnimator.start()
}

inline fun View.readAttributes(attrs: AttributeSet? = null, stylebleResource: IntArray, attributeReaderFun: (TypedArray) -> Unit = {}) {
    context.withStyledAttributes(attrs, stylebleResource, block = attributeReaderFun)
}
