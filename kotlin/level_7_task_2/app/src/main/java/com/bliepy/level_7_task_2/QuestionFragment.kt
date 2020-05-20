package com.bliepy.level_7_task_2

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import com.bliepy.level_7_task_2.model.QuestionModel

class QuestionFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var questionModel: QuestionModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        questionModel = viewModel.questions.value!![0]

        val questionTitle: TextView = view!!.findViewById(R.id.questionTitle)
        val questionRadioButton1: RadioButton = view!!.findViewById(R.id.questionRadioButton1)
        val questionRadioButton2: RadioButton = view!!.findViewById(R.id.questionRadioButton2)
        val questionRadioButton3: RadioButton = view!!.findViewById(R.id.questionRadioButton3)

        questionTitle.text = questionModel.question
        questionRadioButton1.text = questionModel.choices[0]
        questionRadioButton2.text = questionModel.choices[1]
        questionRadioButton3.text = questionModel.choices[2]

        return inflater.inflate(R.layout.question_fragment, container, false)
    }
}
