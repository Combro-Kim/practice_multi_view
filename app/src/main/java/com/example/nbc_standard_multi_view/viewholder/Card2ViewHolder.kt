package com.example.nbc_standard_multi_view.viewholder

import androidx.databinding.ViewDataBinding
import com.example.nbc_standard_multi_view.data.DataItem
import com.example.nbc_standard_multi_view.data.viewobject.Card2ViewObject
import com.example.nbc_standard_multi_view.databinding.ItemCard2Binding

class Card2ViewHolder(binding: ViewDataBinding) : DataViewHolder(binding) {
    private val card2Binding = binding as ItemCard2Binding

    override fun bind(item: DataItem) {
        val viewObject = item.viewObject as Card2ViewObject
        card2Binding.apply {
            tvName.text = viewObject.tvName
            tvCardNum1.text = viewObject.num1.toString()
            tvCardNum2.text = viewObject.num2.toString()
            tvCardNum3.text = viewObject.num3.toString()
            tvCardNum4.text = viewObject.num4.toString()
            tvYM.text = viewObject.YM
            tvPrice.text = viewObject.price.toString()
        }
    }
}
