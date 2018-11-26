@file:JvmName("CommonIntents")

package com.celites.kutils

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Created by Prasham on 2/13/2016.
 */

/**
 * Opens browser from Given URL
 * @param[url] Url to open
 * @return Boolean indicating whether this activity is available or not. Usually when there is a
 * handler available for opening URL, this method will start activity and return `true`. When
 * there is no Intent Handlers available, it returns `false`.
 */
fun Context.browseUrl(url: String): Boolean {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse(url)
    return if (isIntentAvailable(intent)) {
        startActivity(intent)
        true
    } else {
        false
    }
}

/**
 * Sends Email- This app open Email sending Intent
 * @param[email]: Email ID to send
 * @param[subject]: Subject of the email, defaults to blank
 * @param[text]: Message of email, defaults to blank.
 * @param[attachment]: Uri of the file to attach, defaults to blank.
 * @return Boolean indicating whether this activity is available or not. Usually when there is a
 * handler available for sending email, this method will start activity and return `true`. When
 * there is no Intent Handlers available, it returns `false`.
 */
@JvmOverloads
fun Context.sendEmail(email: String, subject: String = "", text: String = "", attachment: Uri? = null): Boolean {
    val intent = Intent(Intent.ACTION_SENDTO)
    intent.data = Uri.parse("mailto:")
    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
    if (subject.isNotEmpty()) {
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
    }
    if (text.isNotEmpty()) {
        intent.putExtra(Intent.EXTRA_TEXT, text)
    }
    attachment?.let {
        intent.putExtra(Intent.EXTRA_STREAM, it)
    }
    return openIntent(intent)
}

private fun Context.openIntent(intent: Intent): Boolean {
    return if (isIntentAvailable(intent)) {
        startActivity(intent)
        true
    } else {
        false
    }
}

/**
 * Open Android's Share menu to share any Text
 * @param[text]: Message to share
 * @return Boolean indicating whether this activity is available or not. Usually when there is a
 * handler available for sharing, this method will start activity and return `true`. When
 * there is no Intent Handlers available, it returns `false`.
 */
fun Context.share(text: String): Boolean {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, text)
    }
    return openIntent(intent)
}

/**
 * Makes call to given phone number
 * @param[number]: Phone number to call
 * @return Boolean indicating whether this activity is available or not. Usually when there is a
 * handler available for making call, this method will start activity and return `true`. When
 * there is no Intent Handlers available, it returns `false`.
 */
fun Context.makeCall(number: String): Boolean {
    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
    return openIntent(intent)
}