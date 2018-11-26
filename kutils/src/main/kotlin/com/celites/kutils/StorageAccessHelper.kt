@file:JvmName("StorageAccessHelper")

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
 * Gets extension from filePath
 */
val String.extension: String
    get() {
        return if (isEmptyString()) {
            ""
        } else {
            val dot = lastIndexOf(".")
            if (dot >= 0) {
                substring(dot)
            } else {
                ""
            }
        }
    }

fun String.isLocal() = !isEmptyString() && (startsWith("http://") || startsWith("https://"))

fun Uri.isMediaUri() = authority.equals("media", true)

fun File.getUri() = Uri.fromFile(this)

fun Uri.isExternalStorageDocument() = authority == "com.android.externalstorage.documents"

fun Uri.isDownloadDocuments() = authority == "com.android.providers.downloads.documents"

fun Uri.isMediaDocument() = authority == "com.android.providers.media.documents"

@TargetApi(19)
fun Context.getFilePath(uri: Uri): String {
    var path = ""
    if (uri.isExternalStorageDocument()) {
        val docId = DocumentsContract.getDocumentId(uri)
        val split = docId.split(":")
        val storageType = split[0]

        if (storageType.equals("primary", true)) {
            path = "${Environment.getExternalStorageDirectory().path}/${split[1]}"
        }
    } else if (uri.isDownloadDocuments()) {
        val id = DocumentsContract.getDocumentId(uri)
        val contentUri = ContentUris.withAppendedId(
                Uri.parse("content://downloads/public_downloads"),
                id.toLong())
        path = getDataColumn(contentUri, null, null)
    } else if (uri.isMediaDocument()) {
        val id = DocumentsContract.getDocumentId(uri)
        val split = id.split(":")
        val mediaType = split[0]
        val selection = "_id=?"
        val selectionArg = arrayOf(split[1])

        when {
            mediaType.equals("image", true) -> path = getDataColumn(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection, selectionArg)
            mediaType.equals("video", true) -> path = getDataColumn(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, selection, selectionArg)
            mediaType.equals("audio", true) -> path = getDataColumn(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, selection, selectionArg)
        }


    } else if (uri.isMediaUri()) {
        path = getDataColumn(uri, null, null)
    }
    return path
}

@TargetApi(19)
fun ContentResolver.getRealPathFromUri(contentUri: Uri): String {
    val proj = arrayOf(MediaStore.Audio.Media.DATA)
    val cursor = query(contentUri, proj, null, null, null)
    cursor.use {
        val columnIndex: Int
        return if (it != null) {
            columnIndex = it.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)
            it.moveToFirst()
            it.getString(columnIndex)
        } else {
            ""
        }
    }
}

@TargetApi(19)
fun Context.getDataColumn(uri: Uri, selection: String?, selectionArg: Array<String>?): String {
    val column = "_data"
    val projection = arrayOf(column)

    val cursor = contentResolver.query(uri, projection, selection, selectionArg, null)
    cursor.use {
        if (it != null) {
            val columnIndex = it.getColumnIndexOrThrow(column)
            it.moveToFirst()
            return it.getString(columnIndex)
        }
    }
    return ""
}