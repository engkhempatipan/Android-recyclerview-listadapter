package com.example.myrecyclerview.model

import java.util.*

data class DataModel(
    var id : String? = UUID.randomUUID().toString(),
    var val1 :String? = "",
    var val2 :String? = ""
)