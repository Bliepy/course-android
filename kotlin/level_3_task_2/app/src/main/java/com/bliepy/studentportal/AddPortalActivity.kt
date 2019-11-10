package com.bliepy.studentportal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity



class AddPortalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_portal)

        val actionbar = supportActionBar
        actionbar!!.title = "Create a Portal"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val titleInput  = findViewById<EditText>(R.id.title)
        val urlInput =   findViewById<EditText>(R.id.url)
        val addButton = findViewById<Button>(R.id.add_portal)

        addButton.setOnClickListener(View.OnClickListener {

            val profileActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(profileActivityIntent)

        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        val profileActivityIntent = Intent(this, MainActivity::class.java)
        startActivity(profileActivityIntent)
    }
}

