package com.example.aevapay_challenge.data.local

import androidx.room.*
import com.example.aevapay_challenge.data.models.ReposItem

@Dao
interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepos(data: List<ReposItem?>?)

    @Query("SELECT * FROM repos")
    fun getAllRepos():List<ReposItem?>?

    @Update
    fun updateRepos(data:List<ReposItem?>?)


    @Query("SELECT id FROM repos")
    fun getAllIds():List<Int>

}