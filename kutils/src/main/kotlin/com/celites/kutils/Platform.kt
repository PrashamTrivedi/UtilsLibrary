@file:JvmName("PlatformUtils")

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

import android.os.Build


val platformApi: Int
    get() = Build.VERSION.SDK_INT

fun platformIsOlderThan(version: Int): Boolean = Build.VERSION.SDK_INT < version


fun platformIsGreaterThan(version: Int): Boolean = Build.VERSION.SDK_INT >= version


inline fun runAndLogException(block: () -> Unit) {
    try {
        block()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}