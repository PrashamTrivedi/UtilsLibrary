package com.celites.kutils

import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.CharacterStyle

class Spaniard(val originalString: String) {

    var spannableStringBuilder = SpannableStringBuilder(originalString)


    inline fun span(crossinline spanFun: Spaniard.() -> Unit): SpannableStringBuilder {
        spanFun()
        return spannableStringBuilder
    }


    fun addSpan(text: String, span: CharacterStyle, flag: Int = Spannable.SPAN_INCLUSIVE_INCLUSIVE) {
        val index = originalString.indexOf(text)
        if (index != -1) {
            spannableStringBuilder.setSpan(span, index, index + text.length, flag)
        }
    }


}
