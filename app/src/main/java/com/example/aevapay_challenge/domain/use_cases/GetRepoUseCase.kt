package com.example.aevapay_challenge.domain.use_cases

import com.example.aevapay_challenge.data.models.ReposItem
import com.example.aevapay_challenge.domain.RepositoryContract
import javax.inject.Inject

class GetRepoUseCase @Inject constructor(private  val repositoryContract: RepositoryContract){


    suspend fun getRepos(pageNumber:Int, pageSize:Int):List<ReposItem?>? {
        return repositoryContract.getRepos(pageNumber,pageSize)
    }

}