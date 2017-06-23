@file:JvmName("FileTypeUtils")
package com.celites.kutils

import android.support.v4.provider.DocumentFile

/**
 * Created by Prash on 19-05-2017.
 */
/**
 * Created by Prasham on 6/30/2016.
 */
public val DocumentFile.isImage: Boolean
    get() = this.type != null && !this.type.isEmptyString() &&
            (this.type.startsWith("image") || this.type.containsInArray("application/vnd.oasis.opendocument.graphics", "application/vnd.oasis.opendocument.graphics-template", "application/vnd.oasis.opendocument.image", "application/vnd.stardivision.draw", "application/vnd.sun.xml.draw", "application/vnd.sun.xml.draw.template"))

public val DocumentFile.isAudio: Boolean
    get() = this.type != null && !this.type.isEmptyString() && (this.type.startsWith("audio") || this.type.containsInArray("application / ogg", "application/x-flac"))

public val DocumentFile.isVideo: Boolean
    get() = this.type != null && !this.type.isEmptyString() && (this.type.startsWith("video") || this.type.containsInArray("application/x-quicktimeplayer", "application/x-shockwave-flash"))

public val DocumentFile.hasPreview: Boolean
    get() = isImage || isVideo