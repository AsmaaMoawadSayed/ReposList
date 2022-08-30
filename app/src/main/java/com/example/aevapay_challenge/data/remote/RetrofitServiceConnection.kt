package com.example.aevapay_challenge.data.remote

import com.example.aevapay_challenge.data.models.ReposItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServiceConnection {
    @GET("repos")
    suspend fun getRepos(
                                      @Query("page")pageNumber:Int,
                                      @Query("per_page")pageSize:Int):List<ReposItem>

}