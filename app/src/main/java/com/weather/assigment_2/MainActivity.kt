package com.weather.assigment_2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.weather.assigment_2.utils.Plant

class MainActivity : AppCompatActivity() {

    //variables for holding views
    lateinit var  re_view:RecyclerView
    lateinit var add_btn:Button
    lateinit var new_plant:Plant


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //assigning values to the variables
        re_view =findViewById(R.id.recycle_view_layout)
        add_btn=findViewById(R.id.button)
        re_view.layoutManager=LinearLayoutManager(this)




        val plants= mutableListOf(
            Plant("test 1","test sci 1","test discription"),
            Plant("test 2","test sci 2","test discription 2"),
            Plant("test 3","test sci 3","test discription 3"),
            Plant("test 1","test sci 1","test discription"),
            Plant("test 2","test sci 2","test discription 2"),
            Plant("test 3","test sci 3","test discription 3"),
            Plant("test 1","test sci 1","test discription"),
            Plant("test 2","test sci 2","test discription 2"),
            Plant("test 3","test sci 3","test discription 3"),
            Plant("test 1","test sci 1","test discription"),
            Plant("test 2","test sci 2","test discription 2"),
            Plant("test 3","test sci 3","test discription 3"),
        )
        val adapter= ItemAdapter(plants,this)
        if(intent.hasExtra("plant")){
            new_plant=intent.getSerializableExtra("plant")as Plant
            plants.add(0,new_plant)
            adapter.notifyItemInserted(0)
        }




        re_view.adapter=adapter


        //event listeners

        //set the onclick event listener for the button
        add_btn.setOnClickListener { view->

            startActivity(Intent(view.context,AddItemActivity::class.java))
        }



    }

}