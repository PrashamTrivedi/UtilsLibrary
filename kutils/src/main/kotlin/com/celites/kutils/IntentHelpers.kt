@file:JvmName("CommonIntents")

package com.celites.kutils

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Created by Prasham on 2/13/2016.
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
	return if (isIntentAvailable(intent)) {
		startActivity(intent)
		true
	} else {
		false
	}
}

fun Context.makeCall(number: String): Boolean {
	val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
	return if (isIntentAvailable(intent)) {
		startActivity(intent)
		true
	} else {
		false
	}
}