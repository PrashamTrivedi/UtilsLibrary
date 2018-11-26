@file:JvmName("FileTypeUtils")

package com.celites.kutils

import androidx.documentfile.provider.DocumentFile

/**
 * Determines if current [DocumentFile] is an image
 * Courtesy: Code of Amaze file manager
 */
inline val DocumentFile.isImage: Boolean
    get() {
        val type = this.type
        return type != null && !type.isEmptyString() &&
                (type.startsWith("image") || type.containsInArray("application/vnd" +
                        ".oasis.opendocument.graphics", "application/vnd.oasis.opendocument.graphics-template", "application/vnd.oasis.opendocument.image", "application/vnd.stardivision.draw", "application/vnd.sun.xml.draw", "application/vnd.sun.xml.draw.template"))
    }

/**
 * Determines if current [DocumentFile] is an Audio
 * Courtesy: Code of Amaze file manager
 */
inline val DocumentFile.isAudio: Boolean
    get() {
        val type = this.type
        return type != null && !type.isEmptyString() && (type.startsWith("audio") ||
                type.containsInArray("application / ogg", "application/x-flac"))
    }
/**
 * Determines if current [DocumentFile] is a Video
 * Courtesy: Code of Amaze file manager
 */
inline val DocumentFile.isVideo: Boolean
    get() {
        val type = this.type
        return type != null && !type.isEmptyString() && (type.startsWith("video") ||
                type.containsInArray("application/x-quicktimeplayer", "application/x-shockwave-flash"))
    }

val DocumentFile.hasPreview: Boolean
    get() = isImage || isVideo