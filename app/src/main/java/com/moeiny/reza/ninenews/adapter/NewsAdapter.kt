package com.moeiny.reza.ninenews.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.moeiny.reza.ninenews.databinding.NewsBinding
import com.moeiny.reza.ninenews.utils.CustomClickListener
import com.moeiny.reza.ninenews.view.ShowActivity
import com.moeiny.reza.ninenews.viewmodel.ShowAsset


class NewsAdapter(var context: Context, var assetList:List<ShowAsset>): RecyclerView.Adapter<NewsAdapter.AssetViewHolder>() ,
    CustomClickListener {

       override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val newsBinding = NewsBinding.inflate(layoutInflater, parent, false)
        return AssetViewHolder(newsBinding)
    }

    override fun getItemCount(): Int {
        return assetList.count()
    }

    override fun onBindViewHolder(holderAsset: AssetViewHolder, position: Int) {
        var asset=assetList.get(position)

        holderAsset.bind(asset)
        holderAsset.newsBinding.setItemClickListener(this)
    }

    inner class AssetViewHolder(val newsBinding: NewsBinding): RecyclerView.ViewHolder(newsBinding.root){
      fun bind(modelView: ShowAsset) {
          this.newsBinding.showAsset = modelView
      }
    }

    override fun cardClicked(asset: ShowAsset) {

            val intent = Intent(context, ShowActivity::class.java)
            intent.putExtra("newsURL", asset.url)
            context!!.startActivity(intent)
       }

    @BindingAdapter("imageUrl")
    fun ImageView.setImageUrl(url: String?) {
        Glide.with(context).load(url).into(this)
    }

}