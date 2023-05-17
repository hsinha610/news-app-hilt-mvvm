package com.example.newsapp.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.newsapp.data.Article

class NewsDiffCallback : DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        var itemsAreSame = false
        if (oldItem is Article && newItem is Article)
            itemsAreSame = true
        return itemsAreSame
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        var contentsAreSame = false
        if (oldItem is Article && newItem is Article)
            contentsAreSame = oldItem == newItem
        return contentsAreSame
    }
}