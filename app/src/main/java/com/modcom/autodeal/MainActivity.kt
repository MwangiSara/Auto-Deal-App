package com.modcom.autodeal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//end padding
        // connect the RecyclerView to the RecyclerAdapter.kt and give the RecyclerView an orientation(vertical)
        //step 1: find RecyclerView using id
        val recycler =  findViewById<RecyclerView>(R.id.recyclerView)

        //step 2: giving the Recycler view an orientation
        val layout = LinearLayoutManager(this) // this refers to anything (view,activity)
        recycler.layoutManager = layout // now this refers to our RecyclerView

        //step 3: connect the RecyclerView to the RecyclerAdapter.kt
        //get the RecyclerAdapter.kt and make it a current activity
        val my_adapter = RecyclerAdapter(applicationContext)
        recycler.adapter = my_adapter

        //giving the bottom sheet behaviours, ie, moving up and down and being collapsed when the app is opened
        //find the view using id
        val bottom_sheet = findViewById<FrameLayout>(R.id.bottom_sheet_container)
        BottomSheetBehavior.from(bottom_sheet).apply {
            peekHeight = 300
            this.state = BottomSheetBehavior.STATE_COLLAPSED //this refers to the bottom sheet, making it always collapsed, unless moved
        }//end behaviour

        //create explicit intent for BuynowActivity
        //find the button using id
        val buynow_btn = findViewById<Button>(R.id.buynow_btn)
        buynow_btn.setOnClickListener {
            val a = Intent(applicationContext, BuynowActivity::class.java)
            startActivity(a)
        }
        //create explicit intent for ContactusActivity
        val contactus_btn = findViewById<Button>(R.id.contactus_btn)
        contactus_btn.setOnClickListener {
            val b = Intent(applicationContext, ContactusActivity::class.java)
            startActivity(b)
        }
        //create explicit intent for MoreoptionActivity
        val moreoption_btn = findViewById<Button>(R.id.moreoptions_btn)
        moreoption_btn.setOnClickListener {
            val c = Intent(applicationContext, MoreoptionActivity::class.java)
            startActivity(c)
        }//end listener


        //viewing our input data that has been stored in the shared preference storage
        val prefs = this.getSharedPreferences("storage", MODE_PRIVATE)
        val inputname = prefs.getString("inputname", "")
        //befor we input our name, the default value will be "Empty"
        //get textView using id
        val welcome = findViewById<TextView>(R.id.welcome)
        //put/append the input value into the TextView
        welcome.append("$inputname")
        //toast, is a short popup message
        Toast.makeText(applicationContext, "Welcome $inputname, Shared Preference Updated", Toast.LENGTH_SHORT).show() //a toast requires 2 things, 1. location for the toast,
        //2. the message









    }//end onCreate
}//end main