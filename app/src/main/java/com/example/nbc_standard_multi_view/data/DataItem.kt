package com.example.nbc_standard_multi_view.data

import com.example.nbc_standard_multi_view.data.viewobject.ViewObject

/** 모든 유형의 아이템은 CommonItem의 형태로 주어집니다. */
data class DataItem(
    val viewType: String,
    val viewObject: ViewObject
)