package com.example.nbc_standard_multi_view.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_standard_multi_view.databinding.ItemCard1Binding
import com.example.nbc_standard_multi_view.databinding.ItemCard2Binding
import com.example.nbc_standard_multi_view.databinding.ItemCard3Binding
import com.example.nbc_standard_multi_view.item.MyItem
import java.text.DecimalFormat

sealed class MyViewHolder<E : MyItem>(
    binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun onBind(myItem: E)

    val decimal = DecimalFormat("#,##,###.00")
    data class Card1ViewHolder(
        val binding: ItemCard1Binding
    ) : MyViewHolder<MyItem.Card1>(binding) {
        override fun onBind(myItem: MyItem.Card1) {
            binding.tvName.text = myItem.tvName
            binding.tvCardNum1.text = myItem.num1.toString()
            binding.tvCardNum2.text = myItem.num2.toString()
            binding.tvCardNum3.text = myItem.num3.toString()
            binding.tvCardNum4.text = myItem.num4.toString()
            binding.tvYM.text = myItem.yM
            binding.tvPrice.text = decimal.format(myItem.price)
        }
    }

    data class Card2ViewHolder(
        val binding: ItemCard2Binding
    ) : MyViewHolder<MyItem.Card2>(binding) {
        override fun onBind(myItem: MyItem.Card2) {
            binding.tvName.text = myItem.tvName
            binding.tvCardNum1.text = myItem.num1.toString()
            binding.tvCardNum2.text = myItem.num2.toString()
            binding.tvCardNum3.text = myItem.num3.toString()
            binding.tvCardNum4.text = myItem.num4.toString()
            binding.tvYM.text = myItem.yM
            binding.tvPrice.text = decimal.format(myItem.price)
        }
    }
    data class Card3ViewHolder(
        val binding: ItemCard3Binding
    ) : MyViewHolder<MyItem.Card3>(binding) {
        override fun onBind(myItem: MyItem.Card3) {
            binding.tvName.text = myItem.tvName
            binding.tvCardNum1.text = myItem.num1.toString()
            binding.tvCardNum2.text = myItem.num2.toString()
            binding.tvCardNum3.text = myItem.num3.toString()
            binding.tvCardNum4.text = myItem.num4.toString()
            binding.tvYM.text = myItem.yM
            binding.tvPrice.text = decimal.format(myItem.price)
        }
    }
}