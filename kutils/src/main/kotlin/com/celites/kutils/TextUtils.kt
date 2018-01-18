@file:JvmName("TextUtils")

package com.celites.kutils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Prasham on 11/28/2015.
 */
fun CharSequence.isEmptyString(): Boolean {
    return this.isEmpty() || this.toString().equals("null", true)
}

fun CharSequence.isDigitOnly(): Boolean {
    return (0 until length).any { Character.isDigit(this[it]) }
}

fun CharSequence.getNumber(): Int {
    return if (isDigitOnly()) {
        Integer.parseInt(toString())
    } else {
        0
    }
}

@JvmOverloads
fun String.addToCommaSeparatedString(stringToAdd: String, allowDuplicates: Boolean = false): String {
    val joinedString: String
    if (this.isEmptyString()) {
        joinedString = stringToAdd
    } else {
        val failSafeSplit = failSafeSplit()
        val mutableList: MutableList<String> = failSafeSplit as MutableList<String>? ?: emptyList<String>() as MutableList<String>
        if (!allowDuplicates) {
            var isExists = false
            failSafeSplit?.forEach {
                if (it.toLowerCase() == stringToAdd.toLowerCase()) {
                    isExists = true

                }
            }
            if (!isExists) {
                mutableList.add(stringToAdd)
            }
        } else {
            mutableList.add(stringToAdd)
        }
        joinedString = mutableList.joinToString(",")
    }
    return joinedString

}

@JvmOverloads
fun String.failSafeSplit(delimeter: String = ","): List<String>? {
    return if (contains(delimeter)) {
        this.split(delimeter)
    } else {
        listOf(this)
    }
}

@JvmOverloads
fun String?.containsInArray(vararg names: String, ignoreCase: Boolean = true): Boolean {
    this?.let {
        it.replace(" ", "")
        it.replace("\n", "")
        it.replace(",\n", "")
        it.replace(", ", "")
        return names.any { this.equals(it, ignoreCase) }
    }
    return false
}

fun String.convertDateFormat(fromFormat: String, toFormat: String): String {
    return if (this.isDateStringProperlyFormatted(fromFormat)) {
        try {
            this toDate fromFormat asString toFormat
        } catch (e: Exception) {
            e.printStackTrace()
            this
        }

    } else {
        this
    }
}

fun String.isDateStringProperlyFormatted(dateFormat: String): Boolean {
    var isProperlyFormatted = false
    val format = SimpleDateFormat(dateFormat, Locale.getDefault())
    //SetLenient means dateString will be checked strictly with dateFormat. Otherwise it will format as per wish.
    format.isLenient = false
    try {
        format.parse(this)
        isProperlyFormatted = true
    } catch (e: ParseException) {
        //exception means dateString is not parsable by dateFormat. Thus dateIsProperlyFormatted.
    }

    return isProperlyFormatted
}

infix fun Date.asString(parseFormat: String): String {
    return try {
        SimpleDateFormat(parseFormat, Locale.getDefault()).format(this)
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }

}

infix fun String.toDate(currentFormat: String): Date {
    return try {
        if (this.isEmptyString()) {
            Date()
        } else {
            SimpleDateFormat(currentFormat, Locale.getDefault()).parse(this)
        }
    } catch (e: Exception) {
        e.printStackTrace()
        //If It can not be parsed, return today's date instead of null. So return value of this method does not create null pointer exception.
        Date()
    }
}

fun CharSequence.getDouble(): Double {
    return try {
        if (isDigitOnly()) {
            if (contains(".")) {
                toString().toDouble()
            } else {
                getNumber().toDouble()
            }
        } else {
            0.0
        }
    } catch (e: Exception) {
        0.0
    }
}


infix fun String?.useIfEmpty(otherString: String?) = if ((this ?: "").isEmptyString()) otherString ?: "" else (this ?: "")