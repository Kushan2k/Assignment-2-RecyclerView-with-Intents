package com.weather.assigment_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.weather.assigment_2.utils.Plant


class AddItemActivity : AppCompatActivity() {


    //variables for holding input fields
    lateinit var name_input:EditText
    lateinit var scientfic_name_input:EditText
    lateinit var description_input:EditText
    lateinit var save_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        //initializing variables
        name_input=findViewById(R.id.plant_name_input)
        scientfic_name_input=findViewById(R.id.scientific_name_input)
        description_input=findViewById(R.id.description_input)
        save_btn=findViewById(R.id.save_btn)

        save_btn.setOnClickListener{view->

            if (name_input.text.isEmpty()){
                Toast.makeText(view.context,"Name can not be empty!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if (scientfic_name_input.text.isEmpty()){
                Toast.makeText(view.context,"Scientific Name can not be empty!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if (description_input.text.isEmpty()){
                Toast.makeText(view.context,"Description can not be empty!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var plant:Plant=Plant(
                name_input.text.toString(),
                scientfic_name_input.text.toString(),
                description_input.text.toString()
            )

            startActivity(Intent(view.context,MainActivity::class.java).putExtra("plant",plant))

        }





    }


}