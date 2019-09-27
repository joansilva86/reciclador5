package com.example.recycler5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.template.view.*

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    var list = ArrayList<MyItem>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.template,parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class MyViewHolder(private var view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: MyItem) {
            this.view.txtOne.text = item.author
        }
    }
}