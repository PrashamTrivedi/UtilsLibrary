@file:JvmName("ContextUtils")

package com.celites.kutils

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.support.annotation.RequiresPermission
import android.widget.Toast

/**
 * Created by Prasham on 12/14/2015.
 */
/**
 * checks if device is online or not
 */
@RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
fun Context.isOnline(): Boolean {
    val cm = this.connectivityManager
    var connectedOrConnecting = false
    connectedOrConnecting = cm.activeNetworkInfo?.isConnectedOrConnecting ?: false

    return connectedOrConnecting
}


inline val Context.versionName: String?
    get() = packageManager.getPackageInfo(packageName, 0).versionName
inline val Context.versionCode: Int
    get() = packageManager.getPackageInfo(packageName, 0).versionCode

/**
 * Checks if given intent is available or not
 */
@JvmOverloads
fun Context.isIntentAvailable(intent: Intent, matchConstant: Int = PackageManager.MATCH_DEFAULT_ONLY): Boolean {
    val queryIntentActivities = packageManager.queryIntentActivities(intent, matchConstant)
    return queryIntentActivities.size > 0
}


/**
 * Shows toast
 */
@JvmOverloads
fun Context.toast(tag: String, message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, "$tag $message", duration).show()
}
