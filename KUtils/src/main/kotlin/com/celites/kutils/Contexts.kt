package com.celites.kutils

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.widget.Toast

/**
 * Created by Prasham on 12/14/2015.
 */
/**
 * checks if device is online or not
 */
public fun Context.isOnline(): Boolean {
    var cm = this.connectivityManager()
    var connectedOrConnecting = false
    connectedOrConnecting = cm.activeNetworkInfo.isConnectedOrConnecting

    return connectedOrConnecting
}

public fun Context.getVersionName() = packageManager.getPackageInfo(packageName, 0).versionName
public fun Context.getVersionCode() = packageManager.getPackageInfo(packageName, 0).versionCode

/**
 * Checks if given intent is available or not
 */
public fun Context.isIntentAvailable(intent: Intent, matchConstant: Int = PackageManager.MATCH_DEFAULT_ONLY): Boolean {
    val queryIntentActivities = packageManager.queryIntentActivities(intent, matchConstant)
    return queryIntentActivities.size > 0
}


/**
 * Shows toast
 */
public fun Context.toast(tag: String, message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, "${tag} ${message}", duration).show()
}
