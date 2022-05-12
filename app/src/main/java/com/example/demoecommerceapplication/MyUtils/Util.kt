package com.example.demoecommerceapplication.MyUtils
import android.widget.ImageView
import com.example.demoecommerceapplication.R
import com.example.demoecommerceapplication.Retrofit.ApiClient
import com.example.demoecommerceapplication.Retrofit.InterfaceApi
import com.google.gson.Gson
import com.squareup.picasso.Picasso

object Util {

    fun getAPiInterface(): InterfaceApi? {
        return ApiClient.getClient()?.create(InterfaceApi::class.java)
    }

    fun loadImageInto(imageUrl: String, imageView: ImageView) {
        Picasso.get().load(imageUrl).into(imageView)
    }


}