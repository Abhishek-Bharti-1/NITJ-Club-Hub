package com.androrubin.troika.nitjclubhub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdaptor2(): RecyclerView.Adapter<MyAdaptor2.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_view2, parent ,false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title2.text = "Event"
        holder.message.text="events abhi chalenge bfgcvc hgfgcv hfgcxddgfg hgfgdbvghf hghdfchjghgffg kjhjgvvghfghfgdgghghj hjghfgjkhfjhfgwhfghsmfjkwfhgwff ngfhhjfgjfhjkhfejghlslgjklfjuifgjkfhkl jfheghgsjfhksjfjsgfjkshfjksfhkjkfhflkjhfjfjkhfhajlfhukyfgjfhff "
    }

    override fun getItemCount(): Int {
        val size = 10
        return size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val message = itemView.findViewById<TextView>(R.id.message)
        val title2= itemView.findViewById<TextView>(R.id.title2)
    }

}