package com.gb.reddit.presentation.recycler_view

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.gb.reddit.databinding.ItemHotBinding
import com.gb.reddit.domain.entity.ItemHot

class HotViewHolder(private val binding: ItemHotBinding): ViewHolder(binding.root) {
    fun bind(itemHot: ItemHot){
        binding.run {
            postTextView.text = itemHot.title
            numStarTextView.text = itemHot.ups.toString()
            numMessageTextView.text = itemHot.commentsNumber.toString()
        }
    }
}