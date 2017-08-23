@file:JvmName("NotificationHelper")
package com.celites.kutils

import android.content.Context
import android.support.v4.app.NotificationCompat

/**
 * Created by Prash on 19-05-2017.
 */
@JvmOverloads inline public fun Context.setNotification(id: Int = 0, channelName: String = "Default",
                                                        builderMethod: NotificationCompat.Builder.() -> Any) {
	val builder = NotificationCompat.Builder(this, channelName)
    builder.apply {
        builderMethod()
    }
    notificationManager.notify(id, builder.build())
}

@JvmOverloads inline public fun Context.removeNotification(id: Int = 0) {
    notificationManager.cancel(id)

}