package com.example.demoecommerceapplication.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.demoecommerceapplication.Activity.BaseActivity
import com.example.demoecommerceapplication.MyUtils.Util
import com.example.demoecommerceapplication.R
import com.example.demoecommerceapplication.model.DataX
import com.example.demoecommerceapplication.model.Reddi


class RecyclerAdapter2(contexts: Context, listdata: List<DataX>) :
    RecyclerView.Adapter<RecyclerAdapter2.ViewHolder>(){
    private val listdata: List<DataX>
    private val contexts: Context
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View =
            layoutInflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataX: DataX = listdata[position]
        holder.textView.setText(listdata[position].sub_cat_name)
        if(listdata[position].heart == true){
            holder.imageView1.setImageResource(R.drawable.heart)
        }
        else if(listdata[position].heart == false){
            holder.imageView1.setImageResource(R.drawable.heart1)
        }

        Util.loadImageInto(listdata[position].image_url,holder.imageView)
        holder.relativeLayout.setOnClickListener { view ->

            Toast.makeText(
                view.context,
                "click on item: " + holder.textView.text,
                Toast.LENGTH_LONG
            ).show()

        }

        holder.imageView1.setOnClickListener {
            if(listdata[position].heart) {
                listdata[position].heart = false
                notifyDataSetChanged()
                Log.d("Dtaa", "" + listdata[position].heart)
            }
            else if(!listdata[position].heart) {
                listdata[position].heart = true
                notifyDataSetChanged()
                Log.d("Dtaa", "" + listdata[position].heart)
            }
    }
    }

    override fun getItemCount(): Int {
        return listdata.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var imageView1: ImageView
        var textView: TextView
        var relativeLayout : RelativeLayout

        init {
            imageView = itemView.findViewById<View>(R.id.imageView) as ImageView
            imageView1 = itemView.findViewById<View>(R.id.imageView1) as ImageView
            textView = itemView.findViewById<View>(R.id.textView) as TextView
            relativeLayout = itemView.findViewById<View>(R.id.relativeLayout) as RelativeLayout
        }
    }

    // RecyclerView recyclerView;
    init {
        this.listdata = listdata
        this.contexts = contexts
    }

}