package com.example.aevapay_challenge.data.remote

import com.example.aevapay_challenge.data.models.ReposItem

interface NetworkDataSourceContract {
  suspend  fun getRepos(pageNumber:Int , pageSize:Int):List<ReposItem?>?


}