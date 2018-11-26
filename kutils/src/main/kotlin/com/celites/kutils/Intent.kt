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
import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * Starts activity from Context.
 * @receiver Context to call startActivity From
 * @param[flags] Flags to pass to the intent
 * @param[data] Uri to pass to intent
 * @param[extras] Extra to pass to intent
 */
@JvmOverloads
inline fun <reified T : Activity> Context.startActivity(
        flags: Int = 0,
        data: Uri? = null,
        extras: Bundle? = null
) {

    this.startActivity(getIntent<T>(flags, extras, data))
}

/**
 * Starts activity from Activity.
 * @receiver Activity to call startActivity From
 * @param[flags] Flags to pass to the intent
 * @param[data] Uri to pass to intent
 * @param[extras] Extra to pass to intent
 */
@JvmOverloads
inline fun <reified T : Activity> Activity.startActivity(
        flags: Int = 0,
        data: Uri? = null,
        extras: Bundle? = null
) {
    this.startActivity(getIntent<T>(flags, extras, data))
}

/**
 * Starts activity for result from Activity.
 * @receiver Context to startActivity From
 * @param[flags] Flags to pass to the intent
 * @param[data] Uri to pass to intent
 * @param[extras] Extra to pass to intent
 */
@JvmOverloads
inline fun <reified T : Activity> Activity.startActivityForResult(
        flags: Int = 0,
        data: Uri? = null,
        extras: Bundle? = null, requestCode: Int) = this.startActivityForResult(getIntent<T>
(flags, extras, data),
        requestCode)

/**
 * Starts Service
 * @param[flags] Flags to pass to the intent
 * @param[data] Uri to pass to intent
 * @param[extras] Extra to pass to intent
 */
@JvmOverloads
inline fun <reified T : Service> Context.startService(flags: Int = 0,
                                                      data: Uri? = null,
                                                      extras: Bundle? = null) = this.startService(
        getIntent<T>(flags, extras, data))

/**
 * Starts Activity
 * @param[flags] Flags to pass to the intent
 * @param[data] Uri to pass to intent
 * @param[extras] Extra to pass to intent
 */
@JvmOverloads
inline fun <reified T : Activity> Fragment.startActivity(flags: Int = 0,
                                                         data: Uri? = null,
                                                         extras: Bundle? = null) = this.startActivity(
        getIntent<T>(flags, extras, data))

/**
 * Calls `startActivityForResult` using given flags, bundles and url
 * @param[flags] Flags to pass to the intent
 * @param[data] Uri to pass to intent
 * @param[extras] Extra to pass to intent
 */
@JvmOverloads
inline fun <reified T : Activity> Fragment.startActivityForResult(
        flags: Int = 0,
        data: Uri? = null,
        extras: Bundle? = null, requestCode: Int) = this.startActivityForResult(getIntent<T>
(flags, extras, data),
        requestCode)

/**
 * Generates intent from Fragment
 * @return: Generated intent from Flags, Data and Bundle.
 * @param[flags] Flags to pass to the intent
 * @param[data] Uri to pass to intent
 * @param[bundle] Extra to pass to intent
 */
@JvmOverloads
inline fun <reified T : Context> Fragment.getIntent(flags: Int = 0,
                                                    bundle: Bundle? = null,
                                                    data: Uri? = null
): Intent? {
    return context?.getIntent<T>(flags, bundle, data)
}

/**
 * Gets intent from Context
 * @return: Generated intent from Flags, Data and Bundle.
 * @param[flags] Flags to pass to the intent
 * @param[data] Uri to pass to intent
 * @param[bundle] Extra to pass to intent
 * @receiver Context to generate intent from
 */
@JvmOverloads
inline fun <reified T : Context> Context.getIntent(
        flags: Int = 0,
        bundle: Bundle? = null,
        data: Uri? = null
): Intent = Intent(this, T::class.java).apply {
    this.flags = flags
    this.data = data
    bundle?.let {
        putExtras(it)
    }
}

