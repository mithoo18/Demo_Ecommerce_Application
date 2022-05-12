package com.example.demoecommerceapplication.Retrofit

import com.example.demoecommerceapplication.model.DataItem
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

interface InterfaceApi {


        @POST("Api/category")
        fun get_category(
            @Query("cus_id") cus_id: String,
            @Query("city") city: String,
            @Query("sPin") sPin: String
        ): Call<DataItem>


        @POST("Api/sub_category")
        fun get_sub_category(
            @Query("cus_id") cus_id: String,
            @Query("city") city: String,
            @Query("sPin") sPin: String
        ): Call<DataItem>



    }