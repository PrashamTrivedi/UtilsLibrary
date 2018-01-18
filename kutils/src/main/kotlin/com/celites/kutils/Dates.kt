@file:JvmName("DateUtils")

package com.celites.kutils

import java.util.*


val Date.calendar: Calendar
    get() {
        val calendar = Calendar.getInstance()
        calendar.time = this
        return calendar
    }


var Calendar.year: Int
    get() = get(Calendar.YEAR)
    set(value) = set(Calendar.YEAR, value)
var Calendar.dayOfMonth: Int
    get() = get(Calendar.DAY_OF_MONTH)
    set(value) = set(Calendar.DAY_OF_MONTH, value)
var Calendar.month: Int
    get() = get(Calendar.MONTH)
    set(value) = set(Calendar.MONTH, value)
var Calendar.hour: Int
    get() = get(Calendar.HOUR)
    set(value) = set(Calendar.HOUR, value)
var Calendar.hourOfDay: Int
    get() = get(Calendar.HOUR_OF_DAY)
    set(value) = set(Calendar.HOUR_OF_DAY, value)
var Calendar.minute: Int
    get() = get(Calendar.MINUTE)
    set(value) = set(Calendar.MINUTE, value)
var Calendar.second: Int
    get() = get(Calendar.SECOND)
    set(value) = set(Calendar.SECOND, value)


var Date.yearFromCalendar: Int
    get() = calendar.year
    set(value) {
        calendar.year = value
    }
var Date.dayOfMonth: Int
    get() = calendar.dayOfMonth
    set(value) {
        calendar.dayOfMonth = value
    }
var Date.monthFromCalendar: Int
    get() = calendar.month
    set(value) {
        calendar.month = value
    }
var Date.hour: Int
    get() = calendar.hour
    set(value) {
        calendar.hour = value
    }
var Date.hourOfDay: Int
    get() = calendar.hourOfDay
    set(value) {
        calendar.hourOfDay = value
    }
var Date.minute: Int
    get() = calendar.minute
    set(value) {
        calendar.minute = value
    }
var Date.second: Int
    get() = calendar.second
    set(value) {
        calendar.second = value
    }
