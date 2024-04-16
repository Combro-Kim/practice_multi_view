package com.example.nbc_standard_multi_view.item

import android.os.Parcelable
import com.example.nbc_standard_multi_view.viewtype.MyViewType
import kotlinx.parcelize.Parcelize


sealed class MyItem(private val viewType: MyViewType) :Parcelable{
    @Parcelize
    data class Card1(
        val tvName: String,
        val num1:Int,
        val num2:Int,
        val num3: Int,
        val num4: Int,
        val yM: String,
        val price: Double
    ) : MyItem(MyViewType.CARD1)

    @Parcelize
    data class Card2(
        val tvName: String,
        val num1:Int,
        val num2:Int,
        val num3: Int,
        val num4: Int,
        val yM: String,
        val price: Double
    ) : MyItem(MyViewType.CARD2)

    @Parcelize
    data class Card3(
        val tvName: String,
        val num1:Int,
        val num2:Int,
        val num3: Int,
        val num4: Int,
        val yM: String,
        val price: Double
    ) : MyItem(MyViewType.CARD3)

    fun getViewType() = viewType
}