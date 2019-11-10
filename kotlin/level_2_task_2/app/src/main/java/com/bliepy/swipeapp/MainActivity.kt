package com.bliepy.swipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    private val questionList = listOf(
        Question("A 'val' and 'var' are the same.", false),
        Question("Mobile Application Development grants 12 ETCS.", true),
        Question("A Unit in Kotlin corresponds to a void in Java", true),
        Question("In Kotlin 'when' replaces the 'switch' operator in Java", true)
    )

    private val questionAdapter = QuestionAdapter(questionList) { item : Question -> questionItemClicked(item) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvReminders : RecyclerView = findViewById(R.id.questionList)

        rvReminders.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        rvReminders.adapter = questionAdapter
        rvReminders.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))

        val callbackSwipeRight = object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val message = questionList[viewHolder.adapterPosition].answer
                if (message) {
                    Toast.makeText(this@MainActivity, "TRUE", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this@MainActivity, "FALSE", Toast.LENGTH_SHORT).show()
                }
                questionAdapter.notifyItemChanged(viewHolder.adapterPosition)
            }
        }


        val callbackSwipeLeft = object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val message = questionList[viewHolder.adapterPosition].answer
                if (message) {
                    Toast.makeText(this@MainActivity, "TRUE", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this@MainActivity, "FALSE", Toast.LENGTH_SHORT).show()
                }
                questionAdapter.notifyItemChanged(viewHolder.adapterPosition)
            }

        }

        ItemTouchHelper(callbackSwipeLeft).attachToRecyclerView(rvReminders)
        ItemTouchHelper(callbackSwipeRight).attachToRecyclerView(rvReminders)
    }

    private fun questionItemClicked(item : Question) {
        Toast.makeText(this, "The answer: ${item.answer}", Toast.LENGTH_SHORT).show()
    }
}
