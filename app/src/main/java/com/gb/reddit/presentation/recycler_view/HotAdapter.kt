package com.gb.reddit.presentation.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.gb.reddit.databinding.ItemHotBinding
import com.gb.reddit.domain.entity.ItemHot

class HotAdapter : PagingDataAdapter<ItemHot, HotViewHolder>(Comparator) {

    object Comparator : DiffUtil.ItemCallback<ItemHot>() {
        override fun areItemsTheSame(oldItem: ItemHot, newItem: ItemHot): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ItemHot, newItem: ItemHot
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: HotViewHolder, position: Int) {
        getItem(position)?.let {  holder.bind(it) }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotViewHolder =
        HotViewHolder(ItemHotBinding.inflate(LayoutInflater.from(parent.context), parent, false))

}