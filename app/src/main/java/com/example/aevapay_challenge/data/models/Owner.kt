package com.example.aevapay_challenge.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(
    val avatar_url: String,
    val id: Int,
    val login: String,

) : Parcelable