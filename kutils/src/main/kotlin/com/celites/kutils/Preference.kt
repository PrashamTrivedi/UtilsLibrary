@file:JvmName("PreferenceUtils")

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

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.core.content.edit


inline val Context.sharedPreferences: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(this)


fun SharedPreferences.put(commit: Boolean = false, params: Array<out Pair<String, Any>>) {
    edit(commit = commit) {
        for ((key, value) in params) {
            when (value) {
                is Int -> putInt(key, value)
                is Float -> putFloat(key, value)
                is Boolean -> putBoolean(key, value)
                is Long -> putLong(key, value)
                is String -> putString(key, value)
            }
        }
    }
}

fun SharedPreferences.clear(commit: Boolean = false) {
    edit(commit = commit) { clear() }
}


fun SharedPreferences.remove(key: String) {
    edit {
        remove(key)
    }
}

@Deprecated(message = "Please use Android KTX's edit method", replaceWith = ReplaceWith("edit(commit=false,action=func)"))
inline fun SharedPreferences.edit(func: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.func()
    editor.apply()
}


