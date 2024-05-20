package com.modcom.autodeal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MoreoptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_moreoption)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//end padding

        //find the buttons and the edit text using id
        val save = findViewById<Button>(R.id.save)
            val inputname =findViewById<EditText>(R.id.name)
        //set on click listener for button save
        save.setOnClickListener {
            //create the shared preference storage
            val prefs =this.getSharedPreferences("storage", MODE_PRIVATE)
            //create an editor, to edit our prefs
            //using the editor we will add our input data into the storage
            val editor =prefs.edit()
            editor.putString("inputname", inputname.text.toString())
            editor.apply()

            val x = Intent(applicationContext, MainActivity::class.java)
            startActivity(x)
            finish() //terminating the activities in moreoption activity
        }

        //find the button using id
        val clear = findViewById<Button>(R.id.clear)
        //set on click listener for button clear
        clear.setOnClickListener {
            //remove the data stored in shared Preference storage
            val prefs = this.getSharedPreferences("storage", MODE_PRIVATE)
            //create prefs editor
            val editor = prefs.edit()
            //using the editor we will clear the data
            editor.clear()
            editor.apply()
            //create a toast saying preference cleared
            Toast.makeText(applicationContext, "Preference Cleared", Toast.LENGTH_SHORT).show()
            //creat an explicit intent moving us to main activity
            val y = Intent(applicationContext, MainActivity::class.java)
            startActivity(y)
        }

    }//end onCreate
}//end main