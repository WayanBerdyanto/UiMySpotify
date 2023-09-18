package com.dicoding.myspotify

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Song(
    val titleSong: String,
    val authSong: String,
    val view: String,
    val photoSong: Int,
    val descriptionSong: String
) :Parcelable