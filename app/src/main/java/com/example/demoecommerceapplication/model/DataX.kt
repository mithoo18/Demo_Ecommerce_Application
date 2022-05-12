package com.example.demoecommerceapplication.model

data class DataX(
    val cat_id: String,
    val check_level_customer: String,
    val fav_status: String,
    val id: String,
    var heart: Boolean = false,
    val image_url: String,
    val sub_cat_name: String
)