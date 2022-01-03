package com.androrubin.troika.nitjclubhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hide = supportActionBar?.hide()

        val grp_names = arrayListOf<String>("GDSC(Google Developer Student Clubs)","MADS(Music and Dramatics Society)", "E-cell(Enterpreneurship Cell)", "Cult Society",
            "Quest", "LADS(Library and Debating Society)", "Bawre(Dramatics Club)", "Netra(Photography Club)", "R-tist(Robotics Club)", "Rajbhasha Smiti", "Fine Arts Society")

        val profile = findViewById<ImageButton>(R.id.profile)
        profile?.setOnClickListener()
        {
            val intent2 = Intent(this@MainActivity,Profile::class.java)
            startActivity(intent2)
        }

        val recyclerView =  findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = MyAdaptor()
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdaptor.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, GroupView::class.java)
                var name = grp_names[position]
                intent.putExtra("Grp_name", name)
                startActivity(intent)
            }
        })
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
