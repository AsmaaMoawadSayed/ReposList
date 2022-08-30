package com.example.aevapay_challenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aevapay_challenge.data.models.ReposItem
import com.example.aevapay_challenge.data.remote.RetrofitBuilder
import com.example.aevapay_challenge.data.remote.RetrofitServiceConnection
import com.example.aevapay_challenge.domain.use_cases.GetRepoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class GetRepoViewModel @Inject constructor(private val getRepoUseCase: GetRepoUseCase) :
    ViewModel() {

    suspend fun getRepos(page: Int, size: Int): List<ReposItem?>? {
        var res: List<ReposItem?>? = ArrayList()
        val job = viewModelScope.launch {

            withContext(Dispatchers.IO) {

                res = getRepoUseCase.getRepos(page, size)

            }
        }
        job.join()
        return res

    }

}