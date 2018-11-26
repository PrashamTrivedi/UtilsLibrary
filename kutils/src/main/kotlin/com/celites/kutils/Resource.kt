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

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Typeface
import android.os.Build
import androidx.core.content.ContextCompat
import android.util.DisplayMetrics
import androidx.core.content.res.ResourcesCompat

/**
 * Fetches animation from Given animation resource id.
 *
 * Method name changed to avoid conflict with Framework APIs
 */
fun Context.fetchAnimation(animResId: Int) =
        resources.getAnimation(animResId)

/**
 * Fetches boolean from Given boolean resource id.
 *
 * Method name changed to avoid conflict with Framework APIs
 */

fun Context.fetchBoolean(booleanResId: Int) =
        resources.getBoolean(booleanResId)

/**
 * Fetches Color from Given Color resource id.
 *
 * This method calls ContextCompat Api
 *
 * Method name changed to avoid conflict with Framework APIs.
 */
fun Context.fetchColor(colorResId: Int) =
        ContextCompat.getColor(this, colorResId)

/**
 * Fetches ColorStateList from Given State List resource id.
 *
 * This method calls ContextCompat Api
 *
 * Method name changed to avoid conflict with Framework APIs.
 */
fun Context.fetchColorStateListCompat(stateListResId: Int) =
        ContextCompat.getColorStateList(this, stateListResId)

/**
 * Fetches Dimension from Given Dimension resource id.
 *
 * Method name changed to avoid conflict with Framework APIs.
 */
fun Context.fetchDimension(dimenResId: Int) =
        resources.getDimension(dimenResId)

/**
 * Gets Display Metrics
 */
val Context.displayMetrics: DisplayMetrics
    get() =
        resources.displayMetrics

/**
 * Fetches Int Array from Given id.
 *
 * Method name changed to avoid conflict with Framework APIs.
 */
fun Context.fetchIntArray(id: Int) =
        resources.getIntArray(id)

/**
 * Fetches Integer Resource from Given Integer resource id.
 *
 * Method name changed to avoid conflict with Framework APIs.
 */
fun Context.fetchInteger(id: Int) =
        resources.getInteger(id)


fun Context.fetchLayout(id: Int) =
        resources.getLayout(id)

fun Context.fetchMovie(id: Int) =
        resources.getMovie(id)

/**
 * Fetches Quantity String from Given Quantity String resource id.
 *
 * Method name changed to avoid conflict with Framework APIs.
 */
fun Context.fetchQuantityString(id: Int, quantity: Int, vararg formatArgs: Any) =
        resources.getQuantityString(id, quantity, formatArgs)

fun Context.fetchQuantityText(id: Int, quantity: Int) =
        resources.getQuantityText(id, quantity)

fun Context.fetchStringArray(arrayResId: Int) =
        resources.getStringArray(arrayResId)

fun Context.typefaceFromAssets(assetPathResId: Int) =
        typefaceFromAssets(getString(assetPathResId))

fun Context.typefaceFromAssets(assetPath: String): Typeface =
        Typeface.createFromAsset(assets, assetPath)

/**
 * Fetches Drawable from Given Drawable resource id.
 *
 * This method calls ContextCompat Api.
 *
 * Method name changed to avoid conflict with Framework APIs.
 */
fun Context.fetchDrawable(id: Int) =
        ContextCompat.getDrawable(this, id)

/**
 * Fetches animation from Given animation resource id

 * Method name changed to avoid conflict with Framework APIs
 */
fun Context.fetchFont(id: Int) = ResourcesCompat.getFont(this, id)
