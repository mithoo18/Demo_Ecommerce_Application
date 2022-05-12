package com.example.demoecommerceapplication.Retrofit

import com.example.demoecommerceapplication.model.DataItem
import com.example.demoecommerceapplication.model.DataItem2
import retrofit2.Call
import retrofit2.http.*

interface InterfaceApi {


        @POST("Api/category")
        fun get_category(
            @Query("cus_id") cus_id: String,
            @Query("city") city: String,
            @Query("sPin") sPin: String
        ): Call<DataItem>


        @FormUrlEncoded
        @POST("Api/sub_category")
        fun get_sub_category(
            @Field("cus_id") cus_id: String,
            @Field("cat_id") cat_id: String
        ): Call<DataItem2>



    }