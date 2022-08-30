package com.example.aevapay_challenge.presentation.adapter

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aevapay_challenge.R
import com.example.aevapay_challenge.data.models.ReposItem
import com.example.aevapay_challenge.presentation.LoadMore
import com.example.aevapay_challenge.presentation.OnClickItemList
import com.squareup.picasso.Picasso

class RepoAdapter (private var repoList :ArrayList<ReposItem?>?, private val loadMore: LoadMore, private val onClickItemList: OnClickItemList):
    RecyclerView.Adapter<RepoAdapter.ReposHolder>() {

    class ReposHolder(link: View) : RecyclerView.ViewHolder(link) {
        val repoName: TextView = link.findViewById(R.id.tv_name)
        val imageProfile: ImageView = link.findViewById(R.id.iv_profile)
        val repoDesc: TextView = link.findViewById(R.id.description)

    }
    fun setData(dataSet: ArrayList<ReposItem?>?) {
        val handler = Handler()
        handler.post {
            repoList = dataSet
            notifyDataSetChanged()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposHolder {
        val  item = LayoutInflater.from(parent.context).inflate(R.layout.item_repo,parent,false)
        return ReposHolder(item)
    }

    override fun onBindViewHolder(holder: ReposHolder, position: Int) {
        if (position>=repoList!!.size-1)
            loadMore.loadMoreData()


        holder.repoName.text=repoList!!.get(position)!!.owner.login
        holder.repoDesc.text= repoList!![position]!!.description
        Picasso.get().load(repoList!![position]!!.owner.avatar_url).into(holder.imageProfile);

    }

    override fun getItemCount(): Int {
        return repoList!!.size
    }
}
