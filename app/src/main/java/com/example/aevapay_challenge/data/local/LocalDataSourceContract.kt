package com.example.aevapay_challenge.data.local

import com.example.aevapay_challenge.data.models.ReposItem

interface LocalDataSourceContract {
    fun getRepos():List<ReposItem?>?
    fun addRepos( repo:List<ReposItem?>?)
    fun updateRepos( repo:List<ReposItem?>?)
    fun getAllIds():List<Int>
}