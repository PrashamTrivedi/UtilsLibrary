@file:JvmName("DialogUtils")

package com.celites.kutils

import android.content.Context
import androidx.appcompat.app.AlertDialog


/**
 * Shows AlertDialog
 *
 * @param[themeId] Theme Id for Dialog
 * @param[cancelable] Whether dialog is cancelable or not, by default dialog is not cancelable,
 * use `true` to make it cancelable
 * @param[cancelableTouchOutside] Whether dialog is cancelled on touched outside or not, by
 * default it's not cancelable. Use `true` to make it cancelable when user touches outside of dialog
 * @param[builderFunction] Pass your `AlertDialog.Builder` functions which helps you to create
 * dialogs
 */
@JvmOverloads
inline fun Context.showDialog(themeId: Int = 0, cancelable: Boolean = false, cancelableTouchOutside: Boolean = false, builderFunction: AlertDialog.Builder.() -> Any) {
    val builder = AlertDialog.Builder(this, themeId)
    builder.builderFunction()
    val dialog = builder.create()

    dialog.setCancelable(cancelable)
    dialog.setCanceledOnTouchOutside(cancelableTouchOutside)
    dialog.show()
}

/**
 * Helper method to create positive button for Alert dialog and listen to the button's click
 * @param[text] Positive Button Text, Defaults to "OK"
 * @param[handleClick] Callback that works as click listener when positive button is clicked
 *
 */
@JvmOverloads
inline fun AlertDialog.Builder.positiveButton(text: String = "OK", crossinline handleClick:
(i: Int) -> Unit = {}) {
    this.setPositiveButton(text) { _, i -> handleClick(i) }
}

/**
 * Helper method to create negative button for Alert dialog and listen to the button's click
 * @param[text] Positive Button Text, Defaults to "CANCEL"
 * @param[handleClick] Callback that works as click listener when negative button is clicked
 *
 */
@JvmOverloads
inline fun AlertDialog.Builder.negativeButton(text: String = "CANCEL", crossinline handleClick: (i: Int) -> Unit = {}) {
    this.setNegativeButton(text) { _, i -> handleClick(i) }
}

/**
 * Helper method to create neutral button for Alert dialog and listen to the button's click
 * @param[text] Positive Button Text
 * @param[handleClick] Callback that works as click listener when neutral button is clicked
 *
 */
@JvmOverloads
inline fun AlertDialog.Builder.neutralButton(text: String, crossinline handleClick: (i: Int) -> Unit = {}) {
    this.setNeutralButton(text) { _, i -> handleClick(i) }
}