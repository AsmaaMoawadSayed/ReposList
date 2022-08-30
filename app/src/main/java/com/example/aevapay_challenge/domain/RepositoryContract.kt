package com.example.aevapay_challenge.domain

import com.example.aevapay_challenge.data.models.ReposItem

interface RepositoryContract {
    suspend fun getRepos(pageNumber:Int , pageSize:Int):List<ReposItem?>?
}