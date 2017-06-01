package com.celites.kutils

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Created by Prasham on 2/13/2016.
 */
fun Context.browse(url: String): Boolean {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.setData(Uri.parse(url))
    if (isIntentAvailable(intent)) {
        startActivity(intent)
        return true
    } else {
        return false
    }
}


fun Context.email(email: String, subject: String = "", text: String = ""): Boolean {
    val intent = Intent(Intent.ACTION_SENDTO)
    intent.setData(Uri.parse("mailto:"))
    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
    if (subject.isNotEmpty())
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
    if (text.isNotEmpty())
        intent.putExtra(Intent.EXTRA_TEXT, text)
    if (isIntentAvailable(intent)) {
        startActivity(intent)
        return true
    } else {
        return false
    }

}

public fun Context.makeCall(number: String): Boolean {
    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
    if (isIntentAvailable(intent)) {
        startActivity(intent)
        return true
    } else {
        return false
    }
}