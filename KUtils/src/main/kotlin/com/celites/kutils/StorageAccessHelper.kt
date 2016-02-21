package com.celites.kutils

/**
 * Created by Prasham on 1/4/2016.
 */
import android.annotation.TargetApi
import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import java.io.File

/**
 * Created by Prasham on 1/2/2016.
 */
public fun String.getExtension(): String {
    if (isEmptyString()) {
        return ""
    } else {
        var dot = lastIndexOf(".")
        if (dot >= 0) {
            return substring(dot)
        } else {
            return ""
        }
    }
}

public fun String.isLocal() = !isEmptyString() && (startsWith("http://") || startsWith("https://"))

public fun Uri.isMediaUri() = authority.equals("media", true)

public fun File.getUri() = Uri.fromFile(this)

public fun Uri.isExternalStorageDocument() = authority.equals("com.android.externalstorage.documents")

public fun Uri.isDownloadDocuments() = authority.equals("com.android.providers.downloads.documents")

public fun Uri.isMediaDocument() = authority.equals("com.android.providers.media.documents")

@TargetApi(19)
public fun Context.getFilePath(uri: Uri): String {
    var path = ""
    if (uri.isExternalStorageDocument()) {
        var docId = DocumentsContract.getDocumentId(uri)
        var split = docId.split(":")
        var storageType = split[0]

        if (storageType.equals("primary", true)) {
            path = Environment.getExternalStorageDirectory().path + "/" + split[1];
        }
    } else if (uri.isDownloadDocuments()) {
        var id = DocumentsContract.getDocumentId(uri)
        val contentUri = ContentUris.withAppendedId(
                Uri.parse("content://downloads/public_downloads"),
                id.toLong());
        path = getDataColumn(contentUri, null, null)
    } else if (uri.isMediaDocument()) {
        var id = DocumentsContract.getDocumentId(uri)
        var split = id.split(":")
        var mediaType = split[0]
        val selection = "_id"
        val selectionArg = arrayOf(split[1])

        if (mediaType.equals("image", true)) {
            path = getDataColumn(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection, selectionArg)
        } else if (mediaType.equals("video", true)) {
            path = getDataColumn(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, selection, selectionArg)
        } else if (mediaType.equals("audio", true)) {
            path = getDataColumn(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, selection, selectionArg)
        }


    } else if (uri.isMediaUri()) {
        path = getDataColumn(uri, null, null)
    }
    return path
}

@TargetApi(19)
public fun ContentResolver.getRealPathFromUri(contentUri: Uri): String {
    var proj = arrayOf(MediaStore.Audio.Media.DATA)
    var cursor = query(contentUri, proj, null, null, null)
    try {
        var columnIndex = 0
        if (cursor != null) {
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)
            cursor.moveToFirst()
            return cursor.getString(columnIndex)
        } else {
            return ""
        }
    } finally {
        if (cursor != null) {
            cursor.close()
        }

    }
}

@TargetApi(19)
public fun Context.getDataColumn(uri: Uri, selection: String?, selectionArg: Array<String>?): String {
    val column = "_data"
    val projection = arrayOf(column)

    var cursor = contentResolver.query(uri, projection, selection, selectionArg, null)
    try {
        if (cursor != null) {
            val columnIndex = cursor.getColumnIndexOrThrow(column)
            cursor.moveToFirst()
            return cursor.getString(columnIndex)
        }
    } finally {
        if (cursor != null)
            cursor.close();

    }
    return ""
}