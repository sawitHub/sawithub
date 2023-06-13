package com.example.sawithub.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artikel (
    val name : String,
    val urlImage :String,
    val linkUrl: String
):Parcelable