package com.example.aevapay_challenge.data.remote

import com.example.aevapay_challenge.data.models.ReposItem
import javax.inject.Inject

class NetworkDataSource @Inject constructor( private val retrofitServiceConnection :RetrofitServiceConnection):NetworkDataSourceContract{
   override suspend fun getRepos(pageNumber: Int, pageSize: Int): List<ReposItem?>? {


       var response:List<ReposItem>?
       try {
           response =retrofitServiceConnection.getRepos(pageNumber,pageSize)
       }
       catch (e:Exception){
           response = null
       }
       return response
   }
}