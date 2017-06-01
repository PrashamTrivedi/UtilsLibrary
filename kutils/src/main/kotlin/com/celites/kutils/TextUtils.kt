package com.celites.kutils

/**
 * Created by Prasham on 11/28/2015.
 */
public fun CharSequence.isEmptyString(): Boolean {
    return this.length == 0 || this.toString().equals("null", true);
}

public fun CharSequence.isDigitOnly(): Boolean {
    for (i in 0..length - 1) {
        if (!Character.isDigit(this[i])) {
            return false;
        }
    }
    return true
}

public fun CharSequence.getNumber(): Int {
    if (isDigitOnly()) {
        return Integer.parseInt(toString())
    } else {
        return 0;
    }
}

public fun String.addToCommaSeparatedString(stringToAdd: String, allowDuplicates: Boolean = false): String {
    var joinedString = ""
    if (this.isEmptyString()) {
        joinedString = stringToAdd
    } else {
        val failSafeSplit = failSafeSplit()
        val mutableList: MutableList<String> = failSafeSplit as MutableList<String>? ?: emptyList<String>() as MutableList<String>
        if (!allowDuplicates) {
            var isExists = false
            failSafeSplit?.forEach {
                if (it.toLowerCase().equals(stringToAdd.toLowerCase())) {
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
    return joinedString;

}

public fun String.failSafeSplit(delimeter: String = ","): List<String>? {
    if (contains(delimeter)) {
        return this.split(delimeter)
    } else {
        return listOf(this)
    }
}

public fun String?.containsInArray(vararg names: String, ignoreCase: Boolean = true): Boolean {
    this?.let {
        it.replace(" ", "")
        it.replace("\n", "")
        it.replace(",\n", "")
        it.replace(", ", "")
        return names.any { this.equals(it, ignoreCase) }
    }
    return false
}