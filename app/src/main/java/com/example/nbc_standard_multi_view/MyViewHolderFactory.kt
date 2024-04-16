package com.example.nbc_standard_multi_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.nbc_standard_multi_view.item.MyItem
import com.example.nbc_standard_multi_view.viewholder.MyViewHolder
import com.example.nbc_standard_multi_view.viewtype.MyViewType

class MyViewHolderFactory {
    @Suppress("UNCHECKED_CAST")
    fun getViewHolder(parent: ViewGroup, viewType: MyViewType): MyViewHolder<MyItem> {
        return when (viewType) {
            MyViewType.CARD1 -> MyViewHolder.Card1ViewHolder(viewBind(parent, R.layout.item_card1))
            MyViewType.CARD2 -> MyViewHolder.Card2ViewHolder(viewBind(parent, R.layout.item_card2))
            MyViewType.CARD3 -> MyViewHolder.Card3ViewHolder(viewBind(parent, R.layout.item_card3))
        } as MyViewHolder<MyItem>
    }

    private fun <T : ViewDataBinding> viewBind(parent: ViewGroup, layoutRes: Int): T {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutRes,
            parent,
            false
        )
    }
}