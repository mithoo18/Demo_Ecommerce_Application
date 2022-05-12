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
import com.example.demoecommerceapplication.adapter.RecyclerAdapter2
import com.example.demoecommerceapplication.model.DataItem
import com.example.demoecommerceapplication.model.DataItem2
import com.example.demoecommerceapplication.model.DataX
import com.example.demoecommerceapplication.model.Reddi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BaseActivity : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView

    lateinit var context : Context
    lateinit var dataX : List<DataX>

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
        var id1 : String = "CUS_000034"
        var  id2 : String  = "4"

        Util.getAPiInterface()?.get_sub_category(
            id1,
            id2
        )?.enqueue(object : Callback<DataItem2> {
            override fun onResponse(
                call: Call<DataItem2>,
                response: Response<DataItem2>
            ) {
                Log.d("response",""+response.body())
                dataX = response.body()!!.data
                val recyclerAdapter2 : RecyclerAdapter2 = RecyclerAdapter2(context,dataX)
                recyclerView.adapter = recyclerAdapter2
                recyclerView.layoutManager = GridLayoutManager(context,4)
            }

            override fun onFailure(
                call: Call<DataItem2>,
                t: Throwable
            ) {

            }

        })
    }
}