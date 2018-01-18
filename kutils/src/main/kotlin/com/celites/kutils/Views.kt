@file:JvmName("ViewUtils")

package com.celites.kutils

import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.MenuRes
import android.support.annotation.RequiresApi
import android.support.v7.widget.PopupMenu
import android.util.TypedValue
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by zoomi on 6/23/2017.
 */
const val NO_GETTER: String = "Property does not have a getter"

fun noGetter(): Nothing = throw RuntimeException("Property does not have a getter")
val matchParent: Int = android.view.ViewGroup.LayoutParams.MATCH_PARENT
val wrapContent: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT

var ViewGroup.MarginLayoutParams.verticalMargin: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(v) {
        topMargin = v
        bottomMargin = v
    }

var ViewGroup.MarginLayoutParams.horizontalMargin: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(v) {
        leftMargin = v; rightMargin = v
    }

var ViewGroup.MarginLayoutParams.margin: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(v) {
        leftMargin = v
        rightMargin = v
        topMargin = v
        bottomMargin = v
    }


var View.backgroundDrawable: Drawable?
    inline get() = background
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    set(value) {
        background = value
    }

var View.leftPadding: Int
    inline get() = paddingLeft
    set(value) = setPadding(value, paddingTop, paddingRight, paddingBottom)

var View.topPadding: Int
    inline get() = paddingTop
    set(value) = setPadding(paddingLeft, value, paddingRight, paddingBottom)

var View.rightPadding: Int
    inline get() = paddingRight
    set(value) = setPadding(paddingLeft, paddingTop, value, paddingBottom)

var View.bottomPadding: Int
    inline get() = paddingBottom
    set(value) = setPadding(paddingLeft, paddingTop, paddingRight, value)


var View.horizontalPadding: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setPadding(value, paddingTop, value, paddingBottom)

var View.verticalPadding: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setPadding(paddingLeft, value, paddingRight, value)

var View.padding: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    inline set(value) = setPadding(value, value, value, value)

inline var TextView.isSelectable: Boolean
    get() = isTextSelectable
    set(value) = setTextIsSelectable(value)

var TextView.textAppearance: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = if (Build.VERSION.SDK_INT >= 23) setTextAppearance(value) else setTextAppearance(context, value)

var TextView.textSizeDimen: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(value))

var ImageView.image: Drawable?
    inline get() = drawable
    inline set(value) = setImageDrawable(value)


@JvmOverloads
fun View.setVisible(condition: Boolean, shouldBeGoneWhenFalse: Boolean = true) {
    val visibility = if (condition) View.VISIBLE else if (shouldBeGoneWhenFalse) View.GONE else View.INVISIBLE
    setVisibility(visibility)
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
