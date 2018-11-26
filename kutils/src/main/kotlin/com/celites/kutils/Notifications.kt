@file:JvmName("NotificationHelper")

package com.celites.kutils

import android.content.Context
import androidx.core.app.NotificationCompat

/**
 * Created by Prash on 19-05-2017.
 */
/**
 * Sends notifications
 * @param[id]: Notification Id, defaults to 0
 * @param[channelName]: Name of the channel
 * @param[builderMethod]: Lambda to build notification
 */
@JvmOverloads
inline fun Context.setNotification(id: Int = 0, channelName: String = "Default",
                                   builderMethod: NotificationCompat.Builder.() -> Any) {
    val builder = NotificationCompat.Builder(this, channelName)
    builder.apply {
        builderMethod()
    }
    notificationManager?.notify(id, builder.build())
}

/**
 * Removes notification
 * @param[id]: Id of the notification to remove
 */
@JvmOverloads
fun Context.removeNotification(id: Int = 0) {
    notificationManager?.cancel(id)

}

