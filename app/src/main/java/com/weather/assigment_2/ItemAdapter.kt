package com.weather.assigment_2

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.weather.assigment_2.utils.Plant

class ItemAdapter(val plants: MutableList<Plant>,val context: Context):RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    class ItemHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        private var name_txt:TextView
        private var scientfic_txt:TextView
        private var parent_view:CardView


        init {
            //TODO initialize views here for the one item in the list
            name_txt=itemView.findViewById(R.id.name_txt)
            scientfic_txt=itemView.findViewById(R.id.sub_txt)
            parent_view=itemView.findViewById(R.id.parent_row)

        }

        //public getters
        fun getNameTextView():TextView{
            return name_txt
        }

        fun getSubTextView():TextView{
            return scientfic_txt
        }
        fun getParentView():CardView{
            return parent_view
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)

        return ItemHolder(view)


    }

    override fun getItemCount(): Int {
        return plants.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        //get the plant from the plants array
        val plant: Plant = plants[position]


        //assigning variable values to textview
        holder.getNameTextView().text=makeFirstLetterCapital(plant.name)
        holder.getSubTextView().text=makeFirstLetterCapital(plant.scientfic_name)

        //event listeners

        //item press listener
        holder.itemView.setOnClickListener{_:View->

            var detailsActivity:Intent=Intent(context,DetailsActivity::class.java)
                .putExtra("item",plant)


            //check if the activity can be opened
            if(detailsActivity.resolveActivity(context.packageManager) !=null){
                context.startActivity(detailsActivity)
            }
        }

        //long-press listener
        holder.itemView.setOnLongClickListener{

            AlertDialog.Builder(context)
                .setTitle("Delete item?")
                .setMessage("Are you sure?")
                .setPositiveButton(R.string.confirm_btn_text){_:DialogInterface,_:Int->
                    plants.removeAt(position)
                    notifyItemRemoved(position)
                }
                .setNegativeButton(R.string.colse_btn_text){
                    v:DialogInterface,_:Int->
                    v.dismiss()

                }
                .setIcon(R.drawable.warning).show()



            true
        }

    }


    //function to make the first letter capital
    private fun makeFirstLetterCapital(text:String?):String{

        if (text != null) {
            return text[0].uppercase()+text.subSequence(1,text.length)
        }
        return "Not Found!"
    }
}



