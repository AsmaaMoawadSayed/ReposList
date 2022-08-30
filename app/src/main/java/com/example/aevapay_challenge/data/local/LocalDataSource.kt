package com.example.aevapay_challenge.data.local

import com.example.aevapay_challenge.data.models.ReposItem
import javax.inject.Inject

class LocalDataSource @Inject constructor(private  val dao : RepoDao):LocalDataSourceContract {
    override fun getRepos(): List<ReposItem?>? {
        return dao.getAllRepos()
    }
    override fun addRepos(repos: List<ReposItem?>?) {
        dao.insertRepos(repos)

    }

    override fun updateRepos(repos: List<ReposItem?>?) {
        dao.updateRepos(repos)
    }

    override fun getAllIds(): List<Int> {
       return dao.getAllIds()
    }


}