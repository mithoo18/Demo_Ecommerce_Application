package com.example.demoecommerceapplication.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoecommerceapplication.MyUtils.Util
import com.example.demoecommerceapplication.R
import com.example.demoecommerceapplication.adapter.RecyclerAdapter
import com.example.demoecommerceapplication.model.DataItem
import com.example.demoecommerceapplication.model.Reddi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BaseActivity : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView

    lateinit var context : Context
    lateinit var reddi : List<Reddi>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        context = this@BaseActivity
        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView

    }

    override fun onStart() {

        ApiCall()
        super.onStart()
    }

    private fun ApiCall() {
        Util.getAPiInterface()?.get_category(
            "CUS_00002",
            "Gurugram",
            "122001"
        )?.enqueue(object : Callback<DataItem> {
            override fun onResponse(
                call: Call<DataItem>,
                response: Response<DataItem>
            ) {
                Log.d("response",""+response.body())
                reddi = response.body()!!.Reddi
                val recyclerAdapter : RecyclerAdapter = RecyclerAdapter(context,reddi)
                recyclerView.adapter = recyclerAdapter
                recyclerView.layoutManager = GridLayoutManager(context,4)
            }

            override fun onFailure(
                call: Call<DataItem>,
                t: Throwable
            ) {

            }

        })
    }
}