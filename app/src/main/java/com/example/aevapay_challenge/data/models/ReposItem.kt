package com.example.aevapay_challenge.data.models

import android.os.Parcelable
import androidx.databinding.adapters.Converters
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "repos")
data class ReposItem(
    val full_name: String,
    @PrimaryKey
    val id: Int,
    val description: String,

    @TypeConverters(Converters::class)
    val owner: Owner,

) : Parcelable