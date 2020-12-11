package com.example.restaurant_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restaurant_app.R
import com.example.restaurant_app.model.Post
import kotlinx.android.synthetic.main.restaurant_layout.view.*

class MyAdapter:RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    private var myList = emptyList<Post>()
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.restaurant_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.restName.text = myList[position].name.toString()
        holder.itemView.restCity.text = myList[position].city.toString()

        Glide.with(holder.itemView.context).load(myList[position].image_url).into(holder.itemView.findViewById<ImageView>(R.id.iv_image)).view
    }

    override fun getItemCount(): Int {
        return myList.size
    }
    fun setData(newList: List<Post>){
        myList = newList
        notifyDataSetChanged()
    }
}
