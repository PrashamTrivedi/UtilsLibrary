@file:JvmName("DialogUtils")
package com.celites.kutils

import android.content.Context
import android.support.v7.app.AlertDialog

/**
 * Created by Prash on 19-05-2017.
 */
@JvmOverloads inline public fun Context.showDialog(cancelable: Boolean = false, cancelableTouchOutside: Boolean = false, builderFunction: AlertDialog.Builder.() -> Any) {
    val builder = AlertDialog.Builder(this)
    builder.builderFunction()
    val dialog = builder.create();

    dialog.setCancelable(cancelable)
    dialog.setCanceledOnTouchOutside(cancelableTouchOutside)
    dialog.show()
}


@JvmOverloads inline public fun AlertDialog.Builder.positiveButton(text: String = "OK", noinline handleClick: (i: Int) -> Unit = {}) {
    this.setPositiveButton(text, { dialogInterface, i -> handleClick(i) })
}

@JvmOverloads inline public fun AlertDialog.Builder.negativeButton(text: String = "CANCEL", noinline handleClick: (i: Int) -> Unit = {}) {
    this.setNegativeButton(text, { dialogInterface, i -> handleClick(i) })
}

@JvmOverloads inline public fun AlertDialog.Builder.neutralButton(text: String, noinline handleClick: (i: Int) -> Unit = {}) {
    this.setNeutralButton(text, { dialogInterface, i -> handleClick(i) })
}