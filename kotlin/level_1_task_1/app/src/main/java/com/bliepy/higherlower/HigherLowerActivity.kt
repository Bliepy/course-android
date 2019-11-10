package com.bliepy.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
    }

    /**
     * Set initial view
     */
    private fun initViews() {
        btnHigher.setOnClickListener { play("higher")}
        btnLower.setOnClickListener { play("lower") }
        btnEqual.setOnClickListener { play("equal") }
        updateUI()
    }

    /**
     * Update UI
     */
    private fun updateUI() {
        tvLastThrow.text = getString(R.string.last_throw, lastThrow)

        when (currentThrow) {
            1 -> ivDice.setImageResource(R.drawable.dice1)
            2 -> ivDice.setImageResource(R.drawable.dice2)
            3 -> ivDice.setImageResource(R.drawable.dice3)
            4 -> ivDice.setImageResource(R.drawable.dice4)
            5 -> ivDice.setImageResource(R.drawable.dice5)
            6 -> ivDice.setImageResource(R.drawable.dice6)
        }
    }

    /**
     * Game logic
     */
    private fun play(action : String) {

        lastThrow = currentThrow
        currentThrow = (1..6).random()

        if (action == "higher" && currentThrow > lastThrow) displayMessage(getString(R.string.correct))
        else if (action == "lower" && currentThrow < lastThrow) displayMessage(getString(R.string.correct))
        else if (action == "equal" && currentThrow == lastThrow) displayMessage(getString(R.string.correct))
        else displayMessage(getString(R.string.incorrect))
       updateUI()
    }

    /**
     * Display message
     */
    private fun displayMessage(incorrectMsg : String) {
        Toast.makeText(this, incorrectMsg , Toast.LENGTH_SHORT).show()
    }
}
