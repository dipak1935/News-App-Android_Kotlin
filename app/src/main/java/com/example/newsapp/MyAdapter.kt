package com.example.newsapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView


class MyAdapter(var newsArrayList:ArrayList<News>,var context:Activity) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private lateinit var myListener: OnItemClickListener

    interface OnItemClickListener{

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        myListener=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {

        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false)

        return MyViewHolder(itemView,myListener)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

        val currentItem=newsArrayList[position]

        holder.headingTitle.text=currentItem.newsHeading
        holder.headingImage.setImageResource(currentItem.newsImage)

    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }


    // Listener: onItemClickListener parameter is used to implement the setOnClickListener , it has no use
    // for just showing items

    class MyViewHolder(itemView: View,listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val headingTitle=itemView.findViewById<TextView>(R.id.headingTitle)
        val headingImage=itemView.findViewById<ShapeableImageView>(R.id.headingImage)





        // code for doing things on clicking on views

        init {
            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)
            }
        }


    }
}

