package com.example.aevapay_challenge.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.aevapay_challenge.data.models.ReposItem


@Database(entities =[ReposItem::class,] , version = 1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class ReposDatabase: RoomDatabase() {
    abstract fun getReposDao(): RepoDao

}