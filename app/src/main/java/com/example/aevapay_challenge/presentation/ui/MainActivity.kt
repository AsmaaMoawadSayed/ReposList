package com.example.aevapay_challenge.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.aevapay_challenge.R
import com.example.aevapay_challenge.data.models.ReposItem
import com.example.aevapay_challenge.databinding.ActivityMainBinding
import com.example.aevapay_challenge.presentation.LoadMore
import com.example.aevapay_challenge.presentation.OnClickItemList
import com.example.aevapay_challenge.presentation.adapter.RepoAdapter
import com.example.aevapay_challenge.presentation.viewmodel.GetRepoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(),LoadMore,OnClickItemList {
    var pageNumber = 1
    val size =15
    lateinit var  repos: ArrayList<ReposItem?>
    @Inject
    lateinit var viewModel :GetRepoViewModel

    private val repoAdapter : RepoAdapter by lazy{
        RepoAdapter(repos,this@MainActivity,this@MainActivity)
    }
    private val viewDataBinding : ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repos = ArrayList()
        getData()

    }


    private fun getData(){
        viewDataBinding.progressBarCyclic.visibility= VISIBLE
        lifecycleScope.launch {
               viewModel.getRepos(pageNumber,size).let {
                   repos.addAll(it!!)
               }
            if(pageNumber==1)
                viewDataBinding.rvRepo.adapter=repoAdapter
            else{
                repoAdapter.setData(repos)
            }
            viewDataBinding.progressBarCyclic.visibility=INVISIBLE
        }


    }

    override fun loadMoreData() {
        pageNumber++
        getData()
    }

    override fun onClick(postion: Int) {
        TODO("Not yet implemented")
    }

}