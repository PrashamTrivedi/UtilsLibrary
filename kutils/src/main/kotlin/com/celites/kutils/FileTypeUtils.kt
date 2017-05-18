package com.celites.kutils

import android.support.v4.provider.DocumentFile

/**
 * Created by Prash on 19-05-2017.
 */
/**
 * Created by Prasham on 6/30/2016.
 */
public fun DocumentFile.isImage() = this.type != null &&
        (this.type.startsWith("image") || this.type.containsInArray("application/vnd.oasis.opendocument.graphics", "application/vnd.oasis.opendocument.graphics-template", "application/vnd.oasis.opendocument.image", "application/vnd.stardivision.draw", "application/vnd.sun.xml.draw", "application/vnd.sun.xml.draw.template"))

public fun DocumentFile.isAudio() = this.type != null && (this.type.startsWith("audio") || this.type.containsInArray("application / ogg", "application/x-flac"))

public fun DocumentFile.isVideo() = this.type != null && (this.type.startsWith("video") || this.type.containsInArray("application/x-quicktimeplayer", "application/x-shockwave-flash"))

public fun DocumentFile.hasPreview(): Boolean = isImage() || isVideo()