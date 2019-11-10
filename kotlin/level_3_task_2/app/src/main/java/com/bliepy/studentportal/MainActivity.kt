package com.bliepy.studentportal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.GridLayoutManager



class MainActivity : AppCompatActivity() {

    private val data = arrayListOf<PortalData>()
    private val adapter = PortalAdapter(data)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        data.add(PortalData("VLO","https://vlo.informatica.hva.nl"))
        data.add(PortalData("SIS","https://sis.hva.nl"))
        data.add(PortalData("Roosters","https://rooster.hva.nl"))
        data.add(PortalData("HvA","https://hva.nl"))

        val recyclerView : RecyclerView = findViewById(R.id.portalList)
        recyclerView.setLayoutManager(GridLayoutManager(this, 2))
        recyclerView.setAdapter(adapter)

        fab.setOnClickListener { view ->
            val profileActivityIntent = Intent(this, AddPortalActivity::class.java)
        startActivity(profileActivityIntent)
    }
    }

}
