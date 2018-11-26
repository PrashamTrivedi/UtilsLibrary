@file:JvmName("DateUtils")

package com.celites.kutils

import android.content.Context
import android.text.format.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Gives [Calendar] object from Date
 */
inline val Date.calendar: Calendar
    get() {
        val calendar = Calendar.getInstance()
        calendar.time = this
        return calendar
    }


/**
 * Gets and sets value of Year directly from [Calendar] Object
 */
inline var Calendar.year: Int
    get() = get(Calendar.YEAR)
    set(value) = set(Calendar.YEAR, value)

/**
 * Gets and sets value of DayOfMonth from [Calendar] Object
 */
inline var Calendar.dayOfMonth: Int
    get() = get(Calendar.DAY_OF_MONTH)
    set(value) = set(Calendar.DAY_OF_MONTH, value)

/**
 * Gets and sets value of Month from [Calendar] Object
 */
inline var Calendar.month: Int
    get() = get(Calendar.MONTH)
    set(value) = set(Calendar.MONTH, value)

/**
 * Gets and sets value of Hour from [Calendar] Object
 */
inline var Calendar.hour: Int
    get() = get(Calendar.HOUR)
    set(value) = set(Calendar.HOUR, value)

/**
 * Gets and sets value of HourOfDay from [Calendar] Object
 */
inline var Calendar.hourOfDay: Int
    get() = get(Calendar.HOUR_OF_DAY)
    set(value) = set(Calendar.HOUR_OF_DAY, value)

/**
 * Gets and sets value of Minute from [Calendar] Object
 */
inline var Calendar.minute: Int
    get() = get(Calendar.MINUTE)
    set(value) = set(Calendar.MINUTE, value)

/**
 * Gets and sets value of Second from [Calendar] Object
 */
inline var Calendar.second: Int
    get() = get(Calendar.SECOND)
    set(value) = set(Calendar.SECOND, value)

/**
 * Gets and sets value of DayOfMonth from [Date] Object
 */
inline var Date.yearFromCalendar: Int
    get() = calendar.year
    set(value) {
        calendar.year = value
    }
/**
 * Gets and sets value of DayOfMonth from [Date] Object
 */
inline var Date.dayOfMonth: Int
    get() = calendar.dayOfMonth
    set(value) {
        calendar.dayOfMonth = value
    }
/**
 * Gets and sets value of Month from [Date] Object
 */
inline var Date.monthFromCalendar: Int
    get() = calendar.month
    set(value) {
        calendar.month = value
    }
/**
 * Gets and sets value of Hour from [Date] Object
 */
inline var Date.hour: Int
    get() = calendar.hour
    set(value) {
        calendar.hour = value
    }
/**
 * Gets and sets value of HourOfDay from [Date] Object
 */
inline var Date.hourOfDay: Int
    get() = calendar.hourOfDay
    set(value) {
        calendar.hourOfDay = value
    }
/**
 * Gets and sets value of Minute from [Date] Object
 */
inline var Date.minute: Int
    get() = calendar.minute
    set(value) {
        calendar.minute = value
    }

/**
 * Gets and sets value of Second from [Date] Object
 */
inline var Date.second: Int
    get() = calendar.second
    set(value) {
        calendar.second = value
    }

/**
 * Gets value of Milliseconds of current time
 */
inline val now: Long
    get() = Calendar.getInstance().timeInMillis

/**
 * Gets current time in given format
 */
fun getCurrentTimeInFormat(stringFormat: String): String {
    val currentTime = Date()
    return SimpleDateFormat(stringFormat, Locale.getDefault()).format(currentTime)
}

/**
 * Formats date according to device's default date format
 */
fun Context.formatDateAccordingToDevice(date: Date): String {
    val format = DateFormat.getDateFormat(this)
    return format.format(date)
}

/**
 * Formats time according to device's default time format
 */
fun Context.formatTimeAccordingToDevice(date: Date): String {
    val format = DateFormat.getTimeFormat(this)
    return format.format(date)
}