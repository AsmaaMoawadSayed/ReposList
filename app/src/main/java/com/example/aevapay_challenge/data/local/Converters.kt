package com.example.aevapay_challenge.data.local

import androidx.room.TypeConverter
import com.example.aevapay_challenge.data.models.Owner
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converters {

    @TypeConverter
    fun fromOwnerToString(owner: Owner):String {
        val gson = Gson()
        return gson.toJson(owner)
    }

    @TypeConverter
    fun fromStringToResult(value: String):Owner {
        val result: Type = object : TypeToken<Owner>() {}.type
        return Gson().fromJson(value, result)

    }





















}