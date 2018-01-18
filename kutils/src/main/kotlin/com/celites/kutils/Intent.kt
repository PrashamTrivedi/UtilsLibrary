@file:JvmName("IntentUtils")

/*
 * Copyright (C) 2015 Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.celites.kutils

import android.app.Activity
import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment


fun Context.flags(flag: Int, vararg flags: Int): Int {
    var orFlags = flag
    for (i in flags) {
        orFlags = orFlags or i
    }
    return orFlags
}

inline fun <reified T : Activity> Activity.startActivity() = this.startActivity(
        getIntent<T>())

inline fun <reified T : Activity> Activity.startActivity(flags: Int) = this.startActivity(
        getIntent<T>(flags))

inline fun <reified T : Activity> Activity.startActivity(extras: Bundle) = this.startActivity(
        getIntent<T>(bundle = extras))

inline fun <reified T : Activity> Activity.startActivity(flags: Int,
                                                         extras: Bundle) = this.startActivity(
        getIntent<T>(flags, extras))

inline fun <reified T : Activity> Activity.startActivityForResult(
        requestCode: Int) = this.startActivityForResult(getIntent<T>(), requestCode)

inline fun <reified T : Activity> Activity.startActivityForResult(requestCode: Int,
                                                                  flags: Int) = this.startActivityForResult(
        getIntent<T>(flags), requestCode)

inline fun <reified T : Activity> Activity.startActivityForResult(extras: Bundle,
                                                                  requestCode: Int) = this.startActivityForResult(
        getIntent<T>(bundle = extras), requestCode)

inline fun <reified T : Activity> Activity.startActivityForResult(extras: Bundle, requestCode: Int,
                                                                  flags: Int) = this.startActivityForResult(
        getIntent<T>(flags, extras), requestCode)

inline fun <reified T : Activity> Service.startActivity() = this.startActivity(
        getIntent<T>(Intent.FLAG_ACTIVITY_NEW_TASK))

inline fun <reified T : Activity> Service.startActivity(flags: Int) = this.startActivity(
        getIntent<T>(flags))

inline fun <reified T : Activity> Service.startActivity(extras: Bundle) = this.startActivity(
        getIntent<T>(Intent.FLAG_ACTIVITY_NEW_TASK, extras))

inline fun <reified T : Activity> Service.startActivity(extras: Bundle,
                                                        flags: Int) = this.startActivity(
        getIntent<T>(flags, extras))

inline fun <reified T : Service> Context.startService(): ComponentName = this.startService(
        getIntent<T>())

inline fun <reified T : Service> Context.startService(
        flags: Int): ComponentName = this.startService(getIntent<T>(flags))

inline fun <reified T : Service> Context.startService(
        extras: Bundle): ComponentName = this.startService(getIntent<T>(bundle = extras))

inline fun <reified T : Service> Context.startService(extras: Bundle,
                                                      flags: Int): ComponentName = this.startService(
        getIntent<T>(flags, extras))

inline fun <reified T : Activity> Fragment.startActivity() = this.startActivity(
        getIntent<T>())

inline fun <reified T : Activity> Fragment.startActivityForResult(
        requestCode: Int) = this.startActivityForResult(getIntent<T>(), requestCode)

inline fun <reified T : Activity> Fragment.startActivity(flags: Int) = this.startActivity(
        getIntent<T>(flags = flags))

inline fun <reified T : Activity> Fragment.startActivityForResult(requestCode: Int,
                                                                  flags: Int) = this.startActivityForResult(
        getIntent<T>(flags = flags), requestCode)

inline fun <reified T : Activity> Fragment.startActivity(extras: Bundle) = this.startActivity(
        getIntent<T>(bundle = extras))

inline fun <reified T : Activity> Fragment.startActivityForResult(requestCode: Int,
                                                                  extras: Bundle) = this
        .startActivityForResult(
                getIntent<T>(bundle = extras), requestCode)


inline fun <reified T : Context> Fragment.getIntent(flags: Int = 0,
                                                    bundle: Bundle? = null): Intent {

    val intent = Intent(context, T::class.java)
    intent.flags = flags
    bundle?.let {
        intent.putExtras(bundle)
    }
    return intent
}

inline fun <reified T : Context> Context.getIntent(): Intent = Intent(this, T::class.java)

inline fun <reified T : Context> Context.getIntent(flags: Int = 0, bundle: Bundle? = null): Intent {
    val intent = getIntent<T>()
    intent.flags = flags
    bundle?.let {
        intent.putExtras(bundle)
    }
    return intent
}

