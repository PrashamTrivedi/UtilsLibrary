package com.celites.kutils

import android.content.Context
import android.support.v4.app.NotificationCompat

/**
 * Created by Prash on 19-05-2017.
 */
inline public fun Context.setNotification(id: Int = 0, builderMethod: NotificationCompat.Builder.() -> Any) {
    val builder = NotificationCompat.Builder(this)
    builder.apply {
        builderMethod()
    }
    notificationManager.notify(id, builder.build())
}

inline public fun Context.removeNotification(id: Int = 0) {
    notificationManager.cancel(id)

}