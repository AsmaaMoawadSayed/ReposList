package com.example.aevapay_challenge.data

import com.example.aevapay_challenge.data.local.LocalDataSourceContract
import com.example.aevapay_challenge.data.models.ReposItem
import com.example.aevapay_challenge.data.remote.NetworkDataSourceContract
import com.example.aevapay_challenge.domain.RepositoryContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Repository @Inject constructor(private val networkDataSourceContract: NetworkDataSourceContract, private val localDataSourceContract: LocalDataSourceContract) :RepositoryContract{
    override suspend fun getRepos(pageNumber: Int, pageSize: Int): List<ReposItem?>? {

        var response = networkDataSourceContract.getRepos(pageNumber,pageSize)
        var item :List<ReposItem?>? = listOf()
        try {
            withContext(Dispatchers.IO){
                    val localData = localDataSourceContract.getRepos()
                    if (localData?.size!! <= 0) {
                        localDataSourceContract.addRepos(response!!)
                    } else {
                        localDataSourceContract.updateRepos(response!!)
                    }
            }
            return response
        }
        catch (e:Exception){
                    item=localDataSourceContract.getRepos()

        }
        return item


    }


}