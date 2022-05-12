package com.example.demoecommerceapplication.model

data class Reddi(
    val cat_name: String,
    val check_level_customer: String,
    val fav_status: String,
    val id: String,
    val image_url: String,
    val status: String,
    var heart: Boolean = false,
    val sub_cat_status: String,
    val title1: String
)