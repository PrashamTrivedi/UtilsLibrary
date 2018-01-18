@file:JvmName("ResourceUtils")
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
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.util.DisplayMetrics


fun Context.getAnimation(animResId: Int) =
        resources.getAnimation(animResId)

fun Context.getBoolean(booleanResId: Int) =
        resources.getBoolean(booleanResId)

fun Context.getColorCompat(colorResId: Int) =
        ContextCompat.getColor(this, colorResId)

fun Context.getColorStateListCompat(stateListResId: Int) =
        ContextCompat.getColorStateList(this, stateListResId)

fun Context.getDimension(dimenResId: Int) =
        resources.getDimension(dimenResId)

val Context.displayMetrics: DisplayMetrics
    get() =
        resources.displayMetrics

fun Context.getIntArray(id: Int) =
        resources.getIntArray(id)

fun Context.getInteger(id: Int) =
        resources.getInteger(id)

fun Context.getLayout(id: Int) =
        resources.getLayout(id)

fun Context.getMovie(id: Int) =
        resources.getMovie(id)

fun Context.getQuantityString(id: Int, quantity: Int) =
        resources.getQuantityString(id, quantity)

fun Context.getQuantityString(id: Int, quantity: Int, vararg formatArgs: Any) =
        resources.getQuantityString(id, quantity, formatArgs)

fun Context.getQuantityText(id: Int, quantity: Int) =
        resources.getQuantityText(id, quantity)

fun Context.getStringArray(arrayResId: Int) =
        resources.getStringArray(arrayResId)

fun Context.typefaceFromAssets(assetPathResId: Int) =
        typefaceFromAssets(getString(assetPathResId))

fun Context.typefaceFromAssets(assetPath: String): Typeface =
        Typeface.createFromAsset(getAssets(), assetPath)

fun Context.getDrawableCompat(id: Int) =
        ContextCompat.getDrawable(this, id)

