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
import android.os.Build
import android.preference.PreferenceManager


public fun Context.getDefaultSharedPreferences(): SharedPreferences {
    return PreferenceManager.getDefaultSharedPreferences(this)
}

public fun SharedPreferences.put(params: Array<out Pair<String,Any>>){
    val editor = edit()
    params.forEach {
        val key = it.first
        val value = it.second
        when(value){
            is Int->putInt(key, value)
            is Float->putFloat(key, value)
            is Boolean->putBoolean(key, value)
            is Long-> putLong(key, value)
            is String-> putString(key, value)
        }
    }
    editor.apply()
}

public fun SharedPreferences.clear() {
    edit { clear() }
}

public fun SharedPreferences.putBoolean(key: String, value: Boolean) {
    edit { putBoolean(key, value) }
}

public fun SharedPreferences.putFloat(key: String, value: Float) {
    edit { putFloat(key, value) }
}

public fun SharedPreferences.putInt(key: String, value: Int) {
    edit { putInt(key, value) }
}

public fun SharedPreferences.putLong(key: String, value: Long) {
    edit { putLong(key, value) }
}

public fun SharedPreferences.putString(key: String, value: String?) {
    edit { putString(key, value) }
}

public fun SharedPreferences.putStringSet(key: String, values: Any) {
    edit { putStringSet(key, values) }
}

public fun SharedPreferences.remove(key: String) {
    edit { remove(key) }
}


inline public fun SharedPreferences.edit(func: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.func()
    editor.apply()
}

/*
 * -----------------------------------------------------------------------------
 *  Private properties
 * -----------------------------------------------------------------------------
 */
private var SharedPreferences.bulkEditor: SharedPreferences.Editor?
    get() = this.bulkEditor

    set(editor: SharedPreferences.Editor?) {
        this.bulkEditor = editor
    }

/*
 * -----------------------------------------------------------------------------
 *  Private functions
 * -----------------------------------------------------------------------------
 */
private fun SharedPreferences.getEditor(): SharedPreferences.Editor {
    return this.edit()
}

private fun SharedPreferences.apply(editor: SharedPreferences.Editor) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
        editor.commit()
    } else {
        editor.apply()
    }
}
