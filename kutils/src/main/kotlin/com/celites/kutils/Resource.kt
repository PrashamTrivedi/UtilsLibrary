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


public fun Context.getAnimation(animResId: Int) =
        resources.getAnimation(animResId)

public fun Context.getBoolean(booleanResId: Int) =
        resources.getBoolean(booleanResId)

public fun Context.getColor(colorResId: Int) =
        ContextCompat.getColor(this, colorResId)

public fun Context.getColorStateList(stateListResId: Int) =
        ContextCompat.getColorStateList(this, stateListResId)

public fun Context.getDimension(dimenResId: Int) =
        resources.getDimension(dimenResId)

public val Context.displayMetrics: DisplayMetrics
    get() =
    resources.getDisplayMetrics()

public fun Context.getIntArray(id: Int) =
        resources.getIntArray(id)

public fun Context.getInteger(id: Int) =
        resources.getInteger(id)

public fun Context.getLayout(id: Int) =
        resources.getLayout(id)

public fun Context.getMovie(id: Int) =
        resources.getMovie(id)

public fun Context.getQuantityString(id: Int, quantity: Int) =
        resources.getQuantityString(id, quantity)

public fun Context.getQuantityString(id: Int, quantity: Int, vararg formatArgs: Any) =
        resources.getQuantityString(id, quantity, formatArgs)

public fun Context.getQuantityText(id: Int, quantity: Int) =
        resources.getQuantityText(id, quantity)

public fun Context.getStringArray(arrayResId: Int) =
        resources.getStringArray(arrayResId)

public fun Context.typefaceFromAssets(assetPathResId: Int) =
        typefaceFromAssets(getString(assetPathResId))

public fun Context.typefaceFromAssets(assetPath: String): Typeface =
        Typeface.createFromAsset(getAssets(), assetPath)

public fun Context.getDrawable(id: Int) =
        ContextCompat.getDrawable(this, id)

