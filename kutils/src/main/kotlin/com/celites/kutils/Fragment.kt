@file:JvmName("FragmentUtils")

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

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


/**
 * Calls fragment's `setHasOptionMenu` with `true` as default
 * @receiver Fragment
 * @param[hasOptionsMenu]: Default `true`, Pass false to not have options menu
 */
@JvmOverloads
fun Fragment.allowOptionsMenu(hasOptionsMenu: Boolean = true) {
    setHasOptionsMenu(hasOptionsMenu)
}

/**
 * Call's Parent activity's `setSupportActionBar` from Fragment
 * @receiver Fragment
 * @param[toolbar]: Toolbar to set support actionbar
 */
fun Fragment.setSupportActionbar(toolbar: Toolbar) {
    val appcompatActivity = this.activity as AppCompatActivity?
    appcompatActivity?.setSupportActionBar(toolbar)
}

/**
 * Go back to fragment whose tag matches with name
 * @param[name]: Name of the tag.
 * @param[flag]: Flag, Defaults to 0, optionally you can pass POP_BACKSTACK_INCLUSIVE
 * @receiver FragmentActivity
 */
@JvmOverloads
fun FragmentActivity.goBackToFragment(name: String, flag: Int = 0) {
    supportFragmentManager.popBackStackImmediate(name, flag)
}

/**
 * Go back to fragment whose tag matches with name
 * @param[name]: Name of the tag.
 * @param[flag]: Flag, Defaults to 0, optionally you can pass POP_BACKSTACK_INCLUSIVE
 * @receiver Fragment
 */
@JvmOverloads
fun Fragment.goBackToFragment(name: String, flag: Int = 0) {
    fragmentManager?.popBackStackImmediate(name, flag)
}