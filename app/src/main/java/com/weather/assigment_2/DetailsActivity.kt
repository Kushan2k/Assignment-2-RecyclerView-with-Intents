package com.weather.assigment_2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.weather.assigment_2.utils.Plant


class DetailsActivity : AppCompatActivity() {

    //variables to hold the reciving plat
    private lateinit var plant:Plant

    //variables to hold the views
    lateinit var name_text:TextView
    lateinit var sub_name_txt:TextView
    lateinit var discription_txt:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        supportActionBar?.show()

        //initialization
        plant= intent.getSerializableExtra("item") as Plant

        name_text=findViewById(R.id.details_name_txt)
        sub_name_txt=findViewById(R.id.details_sub_text)
        discription_txt=findViewById(R.id.detail_discriiption_txt)
        name_text.text=makeFirstLetterCapital(plant.name.trim())
        sub_name_txt.text=makeFirstLetterCapital(plant.scientfic_name?.trim())
        discription_txt.text=makeFirstLetterCapital(plant.discription.trim())

    }

    //function to make the first letter capital
    private fun makeFirstLetterCapital(text:String?):String{

        if (text != null) {
            return text[0].uppercase()+text.subSequence(1,text.length)
        }
        return "Not Found!"
    }
}