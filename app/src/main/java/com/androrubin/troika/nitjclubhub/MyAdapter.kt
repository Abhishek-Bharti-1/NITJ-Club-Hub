package com.androrubin.troika.nitjclubhub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MyAdaptor(): RecyclerView.Adapter<MyAdaptor.MyViewHolder>() {

    val grp_names = arrayListOf<String>("GDSC(Google Developer Student Clubs)","MADS(Music and Dramatics Society)", "E-cell(Entrepreneurship Cell)", "Cult Society",
        "Quest", "LADS(Library and Debating Society)", "Bawre(Dramatics Club)", "Netra(Photography Club)", "R-tist(Robotics Club)", "Rajbhasha Smiti", "Fine Arts Society")

    val images = listOf(R.drawable.gdsc_logo,R.drawable.music,R.drawable.entrepreneur,R.drawable.cult,R.drawable.quest,R.drawable.debating,R.drawable.dramatics,R.drawable.photography,R.drawable.robotics,R.drawable.hindi,R.drawable.finearts)

    private lateinit var mlistener :onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position : Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mlistener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_view, parent ,false)
        return MyViewHolder(view,mlistener)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.grp_name.text = grp_names[position]
        holder.image.setImageDrawable(holder.itemView.context.getDrawable(images[position]))
    }

    override fun getItemCount(): Int {
        val size = grp_names.size
        return size
    }

    class MyViewHolder(itemView: View, listener : onItemClickListener): RecyclerView.ViewHolder(itemView) {
        val grp_name = itemView.findViewById<TextView>(R.id.textView)
        val image = itemView.findViewById<ImageView>(R.id.imageView3)

        init {

            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }

        }

    }

}