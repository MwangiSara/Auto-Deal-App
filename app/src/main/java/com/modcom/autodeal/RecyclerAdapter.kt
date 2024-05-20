package com.modcom.autodeal

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
// This is an Adapter that Creates The data to Put in Our Recycler View.
class RecyclerAdapter(var context: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    // Array of items titles
    private val titles = arrayOf("Audi","Bentley","BMW","McLaren","Mustang")
    // Array of items Details  
    private val details = arrayOf("Car number 1",
        "Car number 2",
        "Car Number 3",
        "Car number 4",
        "car number 5"
        )
    // Array of items costs
    private val cost = arrayOf("4M","40M","6M","50M","15M")

    // Array of items images  
    private val images = intArrayOf(
        R.drawable.audi,
        R.drawable.bentley,
        R.drawable.bmw,
        R.drawable.mclaren,
        R.drawable.mustang
    )

    // Access the Single item XML Layout
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.singleitem, viewGroup, false)
        return ViewHolder(v)
    }
    
    //View Holder that does find Views in single item XML, 1 ImageView, 3 TextView
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        var itemCost: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
            itemCost = itemView.findViewById(R.id.item_cost)

        }
    }

    //Set Items from Arrays and Put/Bind them in respectives Views    
    override fun onBindViewHolder(viewHolder: ViewHolder, product: Int) {
        viewHolder.itemTitle.text = titles[product]
        viewHolder.itemDetail.text = details[product]
        viewHolder.itemImage.setImageResource(images[product])
        viewHolder.itemCost.text = cost[product]

        //creating an explicit intent for audi
        viewHolder.itemView.setOnClickListener {
            //product int signifies the index of the card/items, so item 1(audi) is index 0
            if(product == 0){
                val Audi = Intent(context, audi::class.java) //we dont use applicationContecxt bcs RecyclerAdapter is a class not an activity
                //using a flag we are able to launch an intent from a class
                Audi.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(Audi)
            }//end if
            //create an if statement for bentley
            if(product == 1){
                val bentley = Intent(context, Bentely::class.java)
                bentley.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(bentley)
            }//end if
        }

    }//end onBind

    // Get how many items the array have, All arrays must have equal sizes
    override fun getItemCount(): Int {
        return titles.size
    }
}