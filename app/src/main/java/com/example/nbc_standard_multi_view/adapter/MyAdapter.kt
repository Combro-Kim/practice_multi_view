package com.example.nbc_standard_multi_view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_standard_multi_view.MyViewHolderFactory
import com.example.nbc_standard_multi_view.item.MyItem
import com.example.nbc_standard_multi_view.viewholder.MyViewHolder
import com.example.nbc_standard_multi_view.viewtype.MyViewType

class MyAdapter : RecyclerView.Adapter<MyViewHolder<MyItem>>() {
    private var itemList = listOf<MyItem>()
    private val myViewHolderFactory = MyViewHolderFactory()

    interface ItemClick{
        fun onClick(view: View, position: Int)
    }
    var itemClick:ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder<MyItem> {
        return myViewHolderFactory.getViewHolder(parent, MyViewType.entries[viewType])
    }

    override fun onBindViewHolder(holder: MyViewHolder<MyItem>, position: Int) {
        holder.onBind(itemList[position])
        //Click Event
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it,position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].getViewType().ordinal
    }

    override fun getItemCount() = itemList.size

    fun setItemList(itemList: List<MyItem>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }
    fun getItemList(): List<MyItem> {
        return itemList
    }
}