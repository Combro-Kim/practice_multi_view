package com.example.nbc_standard_multi_view.viewtype

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.nbc_standard_multi_view.viewholder.DataViewHolder
import com.example.nbc_standard_multi_view.viewholder.Card1ViewHolder
import com.example.nbc_standard_multi_view.viewholder.Card2ViewHolder
import com.example.nbc_standard_multi_view.viewholder.Card3ViewHolder
import com.example.nbc_standard_multi_view.R

object CommonViewHolderFactory {
    fun createViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return when(viewType) {
            ViewType.Card1.ordinal -> Card1ViewHolder(getViewDataBinding(parent, R.layout.item_card1))
            ViewType.Card2.ordinal -> Card2ViewHolder(getViewDataBinding(parent, R.layout.item_card2))
            else -> Card3ViewHolder(getViewDataBinding(parent, R.layout.item_card3))
        }
    }

    private fun <T: ViewDataBinding> getViewDataBinding(parent: ViewGroup, layoutRes: Int): T {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutRes,
            parent,
            false
        )
    }
}

