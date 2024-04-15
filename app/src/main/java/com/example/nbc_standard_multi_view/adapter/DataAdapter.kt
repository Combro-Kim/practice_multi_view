package com.example.nbc_standard_multi_view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_standard_multi_view.data.DataItem
import com.example.nbc_standard_multi_view.viewholder.DataViewHolder
import com.example.nbc_standard_multi_view.viewtype.CommonViewHolderFactory
import com.example.nbc_standard_multi_view.viewtype.ViewType

class DataAdapter(
    private val dataSet: Array<DataItem>) : RecyclerView.Adapter<DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return CommonViewHolderFactory.createViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

    override fun getItemViewType(position: Int): Int {
        return ViewType.valueOf(dataSet[position].viewType).ordinal
    }
}