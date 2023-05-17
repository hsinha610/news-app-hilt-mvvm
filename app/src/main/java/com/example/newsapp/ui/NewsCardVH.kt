package com.example.newsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.newsapp.data.Article
import com.example.newsapp.R
import com.example.newsapp.databinding.NewsCardBinding

class NewsCardVH(private val binding: NewsCardBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        private val layout = R.layout.news_card
        fun create(parent: ViewGroup, inflater: LayoutInflater): NewsCardVH {
            val binding = NewsCardBinding.inflate(inflater, parent, false)
            return NewsCardVH(binding)
        }
    }

    fun bind(item: Article, clickInterface: ClickInterface) {
        val circularProgressDrawable = CircularProgressDrawable(itemView.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        binding.iv.load(item.urlToImage){
            placeholder(circularProgressDrawable)
            transformations(RoundedCornersTransformation(20f))
            error(R.drawable.error)
        }
        binding.titleTv.text = item.title

        binding.iv.setOnClickListener {
            clickInterface.newsClicked(item)
        }
    }
}