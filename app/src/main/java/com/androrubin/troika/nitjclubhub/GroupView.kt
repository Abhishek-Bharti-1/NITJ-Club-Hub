package com.androrubin.troika.nitjclubhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*

class GroupView : AppCompatActivity() {

    private lateinit var db : FirebaseFirestore
    private lateinit var eventList : ArrayList<Events>
    private lateinit var adapter : MyAdaptor2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_view)

        val hide = supportActionBar?.hide()

        val recyclerView =  findViewById<RecyclerView>(R.id.recyclerview2)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        eventList = arrayListOf()

        adapter = MyAdaptor2(eventList)
        recyclerView.adapter = adapter



        val pagename = findViewById<TextView>(R.id.page_name)
        pagename.text = intent.getStringExtra("Grp_name")

        var name = intent.getStringExtra("Grp_name")
        //function does black magic
        EventChangeListener(name)

        val post = findViewById<ImageButton>(R.id.post)
        post?.setOnClickListener {

            val intent2 = Intent(this,CreatePost::class.java)
            startActivity(intent2)
        }

    }

    private fun EventChangeListener(page_name:String?=null) {

        db= FirebaseFirestore.getInstance()
        db.collection("$page_name").addSnapshotListener(object : EventListener<QuerySnapshot>{
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {

                if(error!=null)
                {
                    Log.e("Firestore Error",error.message.toString())
                    return
                }
                for(dc:DocumentChange in value?.documentChanges!!){
                    if(dc.type == DocumentChange.Type.ADDED){

                        eventList.add(dc.document.toObject(Events::class.java))
                    }
                }
                adapter.notifyDataSetChanged()
            }

        })
    }
}