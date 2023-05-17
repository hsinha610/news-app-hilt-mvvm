package com.example.newsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.data.Article

class NewsAdapter(private val clickInterface: ClickInterface) : ListAdapter<Any,RecyclerView.ViewHolder>(NewsDiffCallback()) {

    companion object {
        private const val ARTICLES = 1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType) {
            ARTICLES -> NewsCardVH.create(parent, inflater)
            else -> NewsCardVH.create(parent, inflater)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when(holder){
            is NewsCardVH -> {
                holder.bind(item = item as Article, clickInterface)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return when(item){
            is Article -> ARTICLES
            else -> 0
        }
    }

}