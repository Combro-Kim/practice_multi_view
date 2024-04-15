package com.example.nbc_standard_multi_view.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_standard_multi_view.data.DataItem

abstract class DataViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: DataItem)
}